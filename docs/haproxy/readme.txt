挂载出文件和两个端口号：
docker run -d -p 17066:7066 -p 11081:1081 --net=swarm-overlay -v /u06/user/pkg/pls-haproxy/haproxy.cfg:/usr/local/etc/haproxy/haproxy.cfg --name pls-haproxy haproxy