# live

JavaCV OpenCV 直播

## 1. 下载 nginx 或 openResty 安装包

[nginx download][1]

[openResty download][2]

## 2. 下载nginx-rtmp-module

github: [https://github.com/arut/nginx-rtmp-module.git][3]

## 3. 安装工具

```
yum -y install gcc glibc glibc-devel make pkgconfig lib-devel openssl-devel
```

## 4. 编译安装

```
    ./configure --prefix=/usr/local/nginx \
        --conf-path=/usr/local/nginx/nginx.conf
        --with-http_ssl_module \
        --add-module=/路径/nginx-rtmp-module

    make && make install
```

## 5. 配置nginx.conf

```
user  nginx;
worker_processes  1;

error_log  /var/log/nginx/error.log warn;
pid        /var/run/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    include /u06/user/pkg/openresty/openresty/conf.d/*.conf;
}

#切换自动推送(多 worker 直播流)模式。默认为 off
rtmp_auto_push on;

#当 worker 被干掉时设置自动推送连接超时时间。默认为 100 毫秒
rtmp_auto_push_reconnect 1s;

rtmp {  
    server {  
        listen 1935;  
        #直播
        application live {  
            live on;  
            #on_publish http://172.30.20.136:9999/live/on_publish;  # 认证发送请求地址
            recorder rec1{
                record all manual;     # 手动控制录制停止开启
                record_unique on;
                record_path /tmp/live/record;   # 录制目录
                record_suffix -%Y-%m-%d-%H_%M_%S.flv;
                #on_record_done http://172.30.20.136:9999/live/on_record_done;      # 录制完毕发送请求地址
            }
        }

        application hls {  
            live on;   #启用rtmp直播

            #on_publish http://172.30.20.136:9999/live/on_publish;

            hls on;    #启用hls直播
            hls_path /tmp/hls;
            wait_key on; #对视频切片进行保护，这样就不会产生马赛克了。
            hls_fragment 10s;     #每个视频切片的时长。
            hls_playlist_length 60s;  #总共可以回看的事件，这里设置的是1分钟。
            hls_continuous on; #连续模式。
            hls_cleanup on;    #对多余的切片进行删除。
            hls_nested on;     #嵌套模式。

            #启用录制
            recorder rec {
              record all manual;  #手动控制录制停止开启
              record_suffix _rec.flv;
              record_path /tmp/record;
              record_unique on;
              #on_record_done http://172.30.20.136:9999/live/on_record_done;
            }
        } 

        #点播
        application vodhls {
            play /tmp/hls/record;
        }
        application vodlive {
            play /tmp/live/record;
        }

        #rtmp日志设置
        access_log /var/log/nginx/rtmp_access.log;
    }  
}
```

## 6. 配置default.conf

```
也可以配置其他文件，需要放在nginx.conf同级目录下的conf.d目录内
server {
    listen       8081;
    server_name  localhost;

    #charset koi8-r;
    charset utf-8;
    #access_log  /var/log/nginx/host.access.log  main;

    #rtmp状态页面
    location /stat {
        rtmp_stat all;         
        rtmp_stat_stylesheet stat.xsl;
    }

    location /stat.xsl {
        root /u06/user/pkg/nginx/nginx-rtmp-module/;
    }

    location /hls {  
        types {  
            application/vnd.apple.mpegurl m3u8;  
            video/mp2t ts;  
        }       
        alias /tmp/hls;  
        add_header Cache-Control no-cache;
    }

    location /vod {
        alias /tmp/hls/record;
    }

    location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    }

#    location ~ \.flv$ {
#       flv;
#       root /tmp/live/record;
#    }

    #error_page  404              /404.html;

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }
}
```

## 7. 启动nginx

```
/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
```

## 8. 访问页面

```
http://IP:8081/stat
```

## 9. JavaCV使用

代码在测试类中

[1]: http://nginx.org/download/ "nginx"
[2]: http://openresty.org/cn/download.html "openResty"
[3]: https://github.com/arut/nginx-rtmp-module.git "https://github.com/arut/nginx-rtmp-module.git"
