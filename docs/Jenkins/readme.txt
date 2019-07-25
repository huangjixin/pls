1.配置好Jenkins。
2.配置网络环境（用到了swarm-overlay）。
3.配置好harbor(镜像私有仓库，构建Jenkins的机器和推送执行镜像的机器都要建立SSH连接和harbor登录认证)
4.Jenkins核心配置：

构建
clean package -Dmaven.test.skip=true

执行shell脚本
Tag="0.0.$BUILD_NUMBER" #BUILD_NUMBER为内置的构建次数
#security/pom.xml
#构建安全模块
cd security
docker build -t register.myharbor.com/pls_dev/pls_security:$Tag -f src/main/docker/Dockerfile --no-cache .
docker push register.myharbor.com/pls_dev/pls_security:$Tag

docker rmi -f register.myharbor.com/pls_dev/pls_security:$Tag

scp ./pls-security-docker-swarm-dev.yml 172.16.234.153:/tmp/
ssh 172.16.234.153 "export Tag=$Tag && docker stack deploy -c /tmp/pls-security-docker-swarm-dev.yml --with-registry-auth pls"

#构建系统模块
cd ../system-manager
docker build -t register.myharbor.com/pls_dev/pls_system:$Tag -f src/main/docker/Dockerfile --no-cache .
docker push register.myharbor.com/pls_dev/pls_system:$Tag


docker rmi -f register.myharbor.com/pls_dev/pls_system:$Tag

scp ./pls-system-docker-swarm-dev.yml 172.16.234.153:/tmp/
ssh 172.16.234.153 "export Tag=$Tag && docker stack deploy -c /tmp/pls-system-docker-swarm-dev.yml --with-registry-auth pls"

#ssh 172.16.106.25 "cp -f /u06/user/pkg/apache-tomcat-8.5.34/webapps/security.war /u06/user/pkg/apache-tomcat-8.5.34/"
#scp ./security/target/security.war 172.16.106.25:/u06/user/pkg/apache-tomcat-8.5.34/webapps/


# 只需要在manager角色运行yml就可以了，集群自动就会更新。
# scp ./pls-security-docker-swarm-dev.yml 172.16.234.154:/tmp/
# ssh 172.16.234.154 "export Tag=$Tag && docker stack deploy -c /tmp/pls-security-docker-swarm-dev.yml --with-registry-auth pls"

