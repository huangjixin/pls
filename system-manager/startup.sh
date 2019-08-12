#!/bin/bash
echo 'maven 构建开始'
mvn clean package -Dmaven.test.skip=true
echo 'maven 构建结束'
#注意if格式判断，线程筛选。
system_pid=$(ps -ef | grep pls-system-manager | grep -v grep | awk '{print $2}')
if [ -n "$system_pid" ];then
	kill -9 $system_pid
fi
#-Dhudson.util.ProcessTree.disable=true
nohup java -jar target/pls-system-manager.jar --spring.profiles.active="dev" -Dhudson.util.ProcessTree.disable=true &