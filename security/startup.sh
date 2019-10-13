#!/bin/sh
Tag="0.0.$BUILD_NUMBER" #BUILD_NUMBER为内置的构建次数
#security/pom.xml
#构建安全模块
cd security
echo 'maven 构建pls-security开始'
mvn clean package -Dmaven.test.skip=true
echo 'maven 构建pls-security结束'

#注意if格式判断，线程筛选。
security_pid=$(ps -ef | grep pls-security | grep -v grep | awk '{print $2}')
if [ -n "$security_pid" ];then
	kill -9 $security_pid
fi
#避免被Jenkins杀死进程。
BUILD_ID=dontKillMe nohup java -jar target/pls-security.war --spring.profiles.active="dev" > pls-security-log.log &