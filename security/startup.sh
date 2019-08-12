#!/bin/bash
#echo 'maven 构建开始'
#mvn clean package -Dmaven.test.skip=true
#echo 'maven 构建结束'
#注意if格式判断，线程筛选。
security_pid=$(ps -ef | grep pls-security | grep -v grep | awk '{print $2}')
if [ -n "$security_pid" ];then
	kill -9 $security_pid
fi
#-Dhudson.util.ProcessTree.disable=true
nohup java -jar target/pls-security.war --spring.profiles.active="dev" &