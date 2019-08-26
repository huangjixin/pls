## 1. code-push-server搭建

### 1.1 容器方式

#### 1.1.1 拉取镜像

```
docker pull tablee/code-push-server:v0.5.2
```

#### 1.1.2 创建数据库codepush

```
使用sql文件夹下的codepush.sql创建数据库
```

#### 1.1.3 启动容器

```
docker volume create code-push-storage

docker run -d -p 3000:3000 \
    --name code-push-server \
    --restart always \
    -e RDS_HOST=EXTERNAL_MYSQL_IP \
    -e RDS_USERNAME=root \
    -e RDS_PASSWORD=password \
    -e RDS_PORT=3306 \
    -e NODE_ENV=production \
    -e STORAGE_DIR=/data/storage \
    -e LOCAL_DOWNLOAD_URL=https://域名(:端口)/download \
    -v code-push-storage:/data/storage \
    tablee/code-push-server:v0.5.2

RDS_HOST 为mysql服务IP
RDS_USERNAME 为mysql帐号，默认为root，不使用-e RDS_USERNAME=XXX即使用默认
RDS_PASSWORD 为mysql密码，默认为空
RDS_PORT 为mysql端口，默认为3306
LOCAL_DOWNLOAD_URL 修改为https://域名(:端口)/download，如果带端口必须与-p前一个端口一致
另外，此处有一个坑，必须使用https协议和域名，否则，调试版本可以正常使用，但发布版本不能正常使用
```

### 1.2 普通安装方式

#### 1.2.1 下载

```
git clone https://github.com/lisong/code-push-server.git
```

#### 1.2 安装

```
cd code-push-server
npm install

另外启动数据库并初始化
./bin/db init --dbhost localhost --dbuser root --dbpassword passwd --dbport 3306 --skip_add_locks --skip-lock-tables
```

#### 1.3 配置

```
vi config/config.js

修改mysql的ip、用户、密码和端口
  db: {
    username: process.env.RDS_USERNAME || "root",
    password: process.env.RDS_PASSWORD || "abc123",
    database: process.env.DATA_BASE || "codepush",
    host: process.env.RDS_HOST || "172.16.106.00",
    port: process.env.RDS_PORT || 3307,
    dialect: "mysql",
    logging: false,
    operatorsAliases: false,
  },

修改downloadUrl为本机IP,修改存储目录
  local: {
    // Binary files storage dir, Do not use tmpdir and it's public download dir.
    storageDir: process.env.STORAGE_DIR || "/data/code-push",
    // Binary files download host address which Code Push Server listen to. the files storage in storageDir.
    downloadUrl: process.env.LOCAL_DOWNLOAD_URL || "https://域名(:端口)/download",  //必须使用https和域名
    // public static download spacename.
    public: '/download'
  },

创建存储目录
mkdir -p /data/code-push
```

#### 1.4 启动

```
nohup ./bin/www &

访问页面http://IP:3000

登录
用户admin
密码123456

复制token
```

## 2. code-push-cli

### 2.1 安装

```
npm install -g code-push-cli
```

### 2.2 添加应用

```
登录server
code-push login http://IP:3000

输入token

添加app
code-push app add <appName> android react-native 

保存key
```

## 3. react-native集成code-push

### 3.1 安装组件

```
npm install react-native-code-push --save
```

### 3.2 添加依赖

```
react-native link react-native-code-push

添加过程中会要求输入 2.2 步骤中的Key

输入后会卡在IOS处，直接Ctrl+C取消即可
```

### 3.3 修改MainApplication

```
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new CodePush(getResources().getString(R.string.reactNativeCodePush_androidDeploymentKey), getApplicationContext(), BuildConfig.DEBUG, getResources().getString(R.string.reactNativeCodePush_androidServerURL))  //修改此行，最后添加一个参数
      );
    }
```

### 3.4 修改app/src/main/res/values/strings.xml

```
<resources>
    <string moduleConfig="true" name="reactNativeCodePush_androidDeploymentKey">YourDeploymentKey</string>
    <string moduleConfig="true" name="reactNativeCodePush_androidServerURL">https://域名(:端口)/</string>  <!-- 此行为添加内容 -->
    <string name="app_name">appName</string>
</resources>
```

### 3.5 修改app/build.gradle

```
将defaultConfig下的versionName修改为三位版本号，例如:1.0.0

注意：发布版本号相同时，才会检测到更新。即安装的是1.0.0版本，而发布到code-push-server上的是1.0.1版本时，是检测不到更新的。
```

## 4. 发布更新

```
测试版本：
    code-push release-react <appName> android -t 1.0.0 --des "更新描述"
生产版本：
    code-push release-react <appName> android -t 1.0.0 -d Production --des "更新描述"
强制更新：
    最后加上参数 -m true
```

## 5. js中使用

```
请参考demo中的App.js
```

## 6. 问题和解决方法

### 6.1 数据库问题

```
使用percona-xtradb-cluster问题
错误： 
    Percona-XtraDB-Cluster prohibits use of LOCK TABLE/FLUSH TABLE <table> WITH READ LOCK with pxc_strict_mode = ENFORCING

解决方法：
    SET GLOBAL pxc_strict_mode=PERMISSIVE;
    执行完sql后，恢复
    SET GLOBAL pxc_strict_mode=ENFORCING;
```

### 6.2 App无法连接CodePush服务器

```
解决方法：
    使用https协议和域名访问

    例(使用nginx代理)：
    server {
        listen       443 ssl http2 default_server;
        listen       [::]:443 ssl http2 default_server;
        server_name  _;
        root         /usr/share/nginx/html;

        ssl_certificate "/etc/nginx/ssl/xxx.cn-ca-bundle.crt";
        ssl_certificate_key "/etc/nginx/ssl/xxx.cn.key";
        ssl_session_cache shared:SSL:1m;
        ssl_session_timeout  10m;
        ssl_ciphers HIGH:!aNULL:!MD5;
        ssl_prefer_server_ciphers on;

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        location / {
                proxy_pass http://YOUR_IP:3000;
        }

        error_page 404 /404.html;
            location = /40x.html {
        }

        error_page 500 502 503 504 /50x.html;
            location = /50x.html {
        }
    }
```
