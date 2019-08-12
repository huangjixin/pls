#构建系统模块
cd ../system-manager
echo 'maven 构建pls-system-manager开始'
mvn clean package -Dmaven.test.skip=true
echo 'maven 构建pls-system-manager结束'
system_pid=$(ps -ef | grep pls-system-manager | grep -v grep | awk '{print $2}')
if [ -n "$system_pid" ];then
	kill -9 $system_pid
fi
#避免被Jenkins杀死进程。
BUILD_ID=dontKillMe nohup java -jar target/pls-system-manager.jar --spring.profiles.active="dev" > pls-system-manager-log.log &