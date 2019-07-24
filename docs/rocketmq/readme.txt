RocketMQ安装（官网：http://rocketmq.apache.org/docs/motivation/
下载地址：https://www.apache.org/dyn/closer.cgi?path=rocketmq/4.5.1/rocketmq-all-4.5.1-bin-release.zip）

1.环境：Linux CentOS7, JDK8.0, git(yum install git -y) maven 3.2+

配置 vi/etc/profile，在末尾加入以下语句，修改完毕后保存退出，source /etc/profile使环境生效。
export JAVA_HOME=/u06/user/pkg/jdk1.8.0_181
export CLASSPATH=.:${JAVA_HOME}/jre/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH

export MAVEN_HOME=/u06/user/pkg/apache-maven-3.5.4
export PATH=$MAVEN_HOME/bin:$PATH

2.下载zip包，解压。
unzip rocketmq-all-4.5.1-bin-release.zip
cd /rocketmq-all-4.5.1-bin-release

3.启动nameserver并且查看日志。
nohup sh bin/mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log

4.启动broker
修改conf/broker.conf，启动broker并且查看日志：nohup sh bin/mqbroker -c /u06/user/pkg/rocketmq-all-4.5.1-bin-release/conf/broker.conf &
tail -f ~/logs/rocketmqlogs/broker.log
关闭broker：./mqshutdown broker

5.安装RocketMQ控制台(参考：https://my.oschina.net/buru1kan/blog/1814356)
进入https://github.com/apache/rocketmq-externals
git clone -b release-rocketmq-console-1.0.0 https://github.com/apache/rocketmq-externals.git
进入项目文件夹并修改配置文件
cd rocketmq-externals/rocketmq-console/
vi src/main/resources/application.properties

将项目打成jar包，并运行jar文件
mvn clean package -Dmaven.test.skip=true
nohup java -jar target/rocketmq-console-ng-1.0.0.jar &  //表示后台运行
访问：
http://ip:端口/rocketmq

常用命令
查看集群情况 ./mqadmin clusterList -n 127.0.0.1:9876
查看 broker 状态 ./mqadmin brokerStatus -n 127.0.0.1:9876 -b 172.20.1.138:10911 (注意换成你的 broker 地址)
查看 topic 列表 ./mqadmin topicList -n 127.0.0.1:9876
查看 topic 状态 ./mqadmin topicStatus -n 127.0.0.1:9876 -t MyTopic (换成你想查询的 topic)
查看 topic 路由 ./mqadmin topicRoute -n 127.0.0.1:9876 -t MyTopic


附broker.conf:
#broker名字，最好修改，以便区分
brokerName=broker-a

#所属集群名字
brokerClusterName=cluster
#0 表示 Master， >0 表示 Slave
brokerId=0
namesrvAddr=localhost:9876
#在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
defaultTopicQueueNums=4
#是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
autoCreateTopicEnable=true
#是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
autoCreateSubscriptionGroup=true
#Broker 对外服务的监听端口
listenPort=10911
#删除文件时间点，默认凌晨 0点
deleteWhen=04
#文件保留时间，默认 48 小时
fileReservedTime=120
#commitLog每个文件的大小默认1G
mapedFileSizeCommitLog=1073741824
#ConsumeQueue每个文件默认存30W条，根据业务情况调整
mapedFileSizeConsumeQueue=300000
#destroyMapedFileIntervalForcibly=120000
#redeleteHangedFileInterval=120000
#检测物理文件磁盘空间
diskMaxUsedSpaceRatio=88
#存储路径
storePathRootDir=/data/rocketmq
#commitLog 存储路径
storePathCommitLog=/data/rocketmq/commitlog
#消费队列存储路径存储路径
storePathConsumeQueue=/data/rocketmq/consumequeue
#消息索引存储路径
storePathIndex=/data/rocketmq/index
#checkpoint 文件存储路径
storeCheckpoint=/data/rocketmq/checkpoint
#abort 文件存储路径
abortFile=/data/rocketmq/abort
#限制的消息大小
maxMessageSize=65536
#flushCommitLogLeastPages=4
#flushConsumeQueueLeastPages=2
#flushCommitLogThoroughInterval=10000
#flushConsumeQueueThoroughInterval=60000
#Broker 的角色
#- ASYNC_MASTER 异步复制Master
#- SYNC_MASTER 同步双写Master
#- SLAVE
brokerRole=SYNC_MASTER
#刷盘方式
#- ASYNC_FLUSH 异步刷盘
#- SYNC_FLUSH 同步刷盘
flushDiskType=SYNC_FLUSH
#checkTransactionMessageEnable=false
#发消息线程池数量
#sendMessageThreadPoolNums=128
#拉消息线程池数量
#pullMessageThreadPoolNums=128
#宿主机IP
brokerIP1=172.16.234.153
namesrvAddr = 172.16.234.153:9876

