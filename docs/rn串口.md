## 一、RN与原生交互
### 1、创建一个原生模块，是一个继承了ReactContextBaseJavaModule的 Java 类
创建一个新的 Java 类并命名为SerialPortUtil.java，放置到android/app/src/main/java/com/your-app-name/目录下
```
public class SerialPortUtil extends ReactContextBaseJavaModule {
    public SerialPortUtil(ReactApplicationContext reactContext) {
        super(reactContext);
    }


    @Override
    public String getName() {
        return "SerialPort";
    }

}
```
ReactContextBaseJavaModule要求派生类实现getName方法。这个函数用于返回一个字符串名字，这个名字在 JavaScript 端标记这个模块。这里我们把这个模块叫做SerialPort，这样就可以在 JavaScript 中通过NativeModules.SerialPort访问到这个模块。

##### 要导出一个方法给 JavaScript 使用，Java 方法需要使用注解@ReactMethod。方法的返回类型必须为void。React Native 的跨语言访问是异步进行的，所以想要给 JavaScript 返回一个值的唯一办法是使用回调函数或者发送事件，例如：
```
 /*
    列出全部设备
     */
    @ReactMethod
    public void getAll(Callback callback) {
        SerialPortFinder serialPortFinder = new SerialPortFinder();
        Object[] serals = serialPortFinder.getAllDevices();
        if (serals.length != 0) {
            callback.invoke(serals);
        } else {
            callback.invoke("空");
        }
    }
```
### 2、注册模块
需要在应用的 Package 类的createNativeModules方法中添加这个模块。如果模块没有被注册，它也无法在 JavaScript 中被访问到。  

创建一个新的 Java 类并命名为CustomToastPackage.java，放置到android/app/src/main/java/com/your-app-name/目录下，其具体代码如下：
```
package com.awesomeproject;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomToastPackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new ToastModule(reactContext));
        modules.add(new SerialPortUtil(reactContext));//注册模块
        return modules;
    }

}
```
这个 package 需要在MainApplication.java文件的getPackages方法中提供。这个文件位于你的 react-native 应用文件夹的 android 目录中。具体路径是:android/app/src/main/java/com/your-app-name/MainApplication.java
```
public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new CustomToastPackage()//新增
      );
    }

```
### 3、把原生模块封装成一个 JavaScript 模块(RN端)
新建ToastExample.js
```
import { NativeModules } from "react-native";
// 下一句中的SerialPort即对应上文
// public String getName()中返回的字符串
export default { ToastExample: NativeModules.ToastExample, SerialPort: NativeModules.SerialPort};
```
现在，在别处的 JavaScript 代码中可以这样调用你的方法：
```
import modules from './ToastExample'

 getAll = () => {
    modules.SerialPort.getAll((result) => {
      this.setState({ all: result });
    })
  }
```
## 二、具体实现
### 1、打开串口
安卓端代码：
```
/*
打开串口
 */
    @ReactMethod
    private void openSerialPort(Callback success, Callback error) {
        <!--String temp = String.valueOf(new File(portPath).canWrite());-->
        <!--Toast.makeText(getReactApplicationContext(), temp, Toast.LENGTH_SHORT).show();-->
        try {
            serialPort = new SerialPort(new File(portPath), baudRate, 0);//打开串口
            outputStream = serialPort.getOutputStream();
            inputStream = serialPort.getInputStream();
            new ReadThread().start();
            //以下代码为监听是否有数据进来，与打开串口无关
            this.setSCMDataReceiveListener(new SCMDataReceiveListener() {

                @Override
                public void dataRecevie(byte[] data, int size) {
                    Log.d("[gx]", " DataReceive:" + new String(data, 0, size));
                    String  readData = new String(data, 0, size);
                    WritableMap map = Arguments.createMap();
                    map.putString("datas", readData);
                    reactC.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                            .emit("readData", map);
                }
            });
            success.invoke("打开串口成功:" + portPath);
        } catch (IOException e) {
            error.invoke("打开串口失败");
            e.printStackTrace();
        }
    }
 ```
 RN端代码
 ```
   <Button
          onPress={this.openClick}
          title="打开串口"
          color="#841584"
    />
    
    openClick = () => {
    modules.SerialPort.openSerialPort((result) => {
      Alert.alert(
        result,
        'success Msg1',
        [
          { text: 'Cancel', onPress: () => console.log('Cancel Pressed'), style: 'cancel' },
          { text: 'OK', onPress: () => console.log('OK Pressed') },
        ],
        { cancelable: false }
      )

    },

      (result2) => {
        Alert.alert(
          result2,
          'error Msg2',
          [
            { text: 'Cancel', onPress: () => console.log('Cancel Pressed'), style: 'cancel' },
            { text: 'OK', onPress: () => console.log('OK Pressed') },
          ],
          { cancelable: false }
        )

      },
    )
  }
  
```
![image](https://raw.githubusercontent.com/lyzzzzzzz/img/master/1560220567(1).png)

### 2、发送数据
安卓端代码
```
  /**
     * 发送串口指令（字符串）
     *
     * @param data String数据指令
     */
    @ReactMethod
    public void sendSerialPort(String data, Callback callback) {
        Log.d(TAG, "sendSerialPort: 发送数据");
        try {
            byte[] sendData = data.getBytes(); //string转byte[]
            if (sendData.length > 0) {
                outputStream.write(sendData);
                outputStream.write('\n');
                outputStream.flush();
                Log.d(TAG, "sendSerialPort: 串口数据发送成功");
                callback.invoke("sendSerialPort: 串口数据发送成功");
            }
        } catch (IOException e) {
            Log.e(TAG, "sendSerialPort: 串口数据发送失败：" + e.toString());
            callback.invoke("sendSerialPort: 串口数据发送失败");
        }

    }
```
RN端代码
```
 <Button
          onPress={this.sendData}
          title="发送数据"
          color="#841584"
  />
  
  sendData = () => {
    modules.SerialPort.sendSerialPort(this.state.text, (result) => {
      Alert.alert(
        result,
        '发送数据',
        [
          { text: 'Cancel', onPress: () => console.log('Cancel Pressed'), style: 'cancel' },
          { text: 'OK', onPress: () => console.log('OK Pressed') },
        ],
        { cancelable: false }
      )
    })

  }
 ```
 ![image](https://raw.githubusercontent.com/lyzzzzzzz/img/master/1560221399(1).png)
 
 ### 3、接收数据
 安卓端代码：
 ```
  new ReadThread().start();//启动线程
  this.setSCMDataReceiveListener(new SCMDataReceiveListener() {

    @Override
    public void dataRecevie(byte[] data, int size) {
        Log.d("[gx]", " DataReceive:" + new String(data, 0, size));
        String  readData = new String(data, 0, size);
        WritableMap map = Arguments.createMap();
        map.putString("datas", readData);
        reactC.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit("readData", map);//设置监听，名为"readData"
                }
    });
    
   private class ReadThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                int size;
                try {
                    byte[] buffer = new byte[512];
                    if (inputStream == null) return;
                    size = inputStream.read(buffer);
                    if (size > 0) {
                        /*监听数据接收*/
                        SCMDataReceiveListener.dataRecevie(buffer, size);
                        //   onDataReceived(buffer, size);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

public interface SCMDataReceiveListener {
        public void dataRecevie(byte[] data, int size);
    }

public void setSCMDataReceiveListener(SCMDataReceiveListener SCMDataReceiveListener) {
        this.SCMDataReceiveListener = SCMDataReceiveListener;
    }
```

RN端代码
```
 componentDidMount = () => {//监听名为'readData'的事件
    DeviceEventEmitter.addListener('readData', (result) => {
      let temp = this.state.readData
      temp.push(result.datas)
      this.setState({ readData: temp });
    });
  }
  
  <Text style={styles.instructions}>读取：{temp == [] ? '没有数据' : temp.join(',')}</Text>
 ```
 ![image](https://raw.githubusercontent.com/lyzzzzzzz/img/master/1560222023(1).png)


## 三、所用类库（谷歌开源serialPort api）
github地址：https://github.com/cepr/android-serialport-api

项目结构如下：

![image](https://raw.githubusercontent.com/lyzzzzzzz/img/master/1560222827(1).png)

新建以上文件夹，并把下载类库里面相关文件放进去，注意两个java类的文件夹名必须为：android_serialport_api

## 四、映射虚拟串口到模拟器
在cmd中运行：
```
cd C:\Users\PTL\AppData\Local\Android\Sdk\emulator //存放安卓模拟器地址
emulator @test2 -qemu -serial COM2
//test2:模拟器名称
//COM2:要映射的串口名称
```
打开另外一个cmd,运行如下，否则获取不到root权限
```
adb shell
su
setenforce 0
```
