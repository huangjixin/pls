package com.awesomeproject;

import android.util.Log;
import android.widget.Toast;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import android_serialport_api.SerialPort;
import android_serialport_api.SerialPortFinder;

public class SerialPortUtil extends ReactContextBaseJavaModule {

    private static final String TAG = "SerialPort";
    private static SerialPortUtil INSTANCE = null;
    private SerialPort serialPort;
    private OutputStream outputStream;
    private InputStream inputStream;
    private SCMDataReceiveListener SCMDataReceiveListener;
    private ReactApplicationContext reactContext;
    final String portPath = "/dev/ttyS1";
    final int baudRate = 9600;
    private ReactContext reactC;

    public SerialPortUtil(ReactApplicationContext reactContext) {

        super(reactContext);
        reactC = reactContext;
    }


    @Override
    public String getName() {
        return "SerialPort";
    }

    @ReactMethod
    public void setSCMDataReceiveListener(SCMDataReceiveListener SCMDataReceiveListener) {
        this.SCMDataReceiveListener = SCMDataReceiveListener;
    }



/*
打开串口
 */
    @ReactMethod
    private void openSerialPort(Callback success, Callback error) {
        String temp = String.valueOf(new File(portPath).canWrite());
        Toast.makeText(getReactApplicationContext(), temp, Toast.LENGTH_SHORT).show();
        try {
            serialPort = new SerialPort(new File(portPath), baudRate, 0);
            outputStream = serialPort.getOutputStream();
            inputStream = serialPort.getInputStream();
            new ReadThread().start();
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

    /*
    列出全部串口
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


    public interface SCMDataReceiveListener {
        public void dataRecevie(byte[] data, int size);
    }


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


}
