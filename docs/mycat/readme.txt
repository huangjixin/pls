/////////////////////////////////////////////////////////////////////////////////
//////  第一次构建日记
/////////////////////////////////////////////////////////////////////////////////
1.docker swarm init --advertise-addr 172.30.20.210

2.docker swarm join-token manager

3.docker swarm join --token SWMTKN-1-4wa1ci0otgvp4n9brrokmbc203ol3d6pxc0zj6i5kqibqz7ons-es8e6emxs6woqfjud51qrs8s3 172.30.20.210:2377


4. docker network create -d overlay --driver overlay --attachable=true pxc-net
docker network create  -d  --attachable=true  --driver overlay pxc-net

docker network create -d overlay  --attachable=true pxc-net

5.chmod 777 /data/mysql1/

  1. 创建结点1
docker run -d -p 3307:3306 -e MYSQL_ROOT_PASSWORD=654321 -e CLUSTER_NAME=PXC -e XTRABACKUP_PASSWORD=123456 -v /data/mysql1/:/var/lib/mysql --privileged --name=node1 --net=pxc-net percona/percona-xtradb-cluster

注：mysql的root用户密码为654321，xtrabackup用户密码为123456，结点1的名称为node1
复制时，注意--net=pxc-net前的两个横线符号

  1. 进入结点1容器执行bash命令
docker exec -it node1 bash

  2. 进入mysql
mysql -uroot -p

注：在容器内进入mysql

  3. 授权
grant reload,lock tables,replication client,process on *.* to 'xtrabackup'@'localhost' IDENTIFIED BY '123456' WITH GRANT OPTION;
flush privileges;

  4. 退出mysql
exit
exit

/////////////////////////////////////////////////////////////////////////////////
//////  第二次构建日记
/////////////////////////////////////////////////////////////////////////////////
  1. 创建结点2
docker run -d -p 3308:3306 -e MYSQL_ROOT_PASSWORD=654321 -e CLUSTER_NAME=PXC -e XTRABACKUP_PASSWORD=123456 -e CLUSTER_JOIN=node1 -v /data/mysql1/:/var/lib/mysql --privileged --name=node2 --net=pxc-net percona/percona-xtradb-cluster

注：CLUSTER_JOIN一定要填写结点1的容器名
复制时，注意--privileged前的两个横线符号

docker network rm pxc-net

//////////////////////////////////////////////////////////////////////////////////////////
//////	新的操作
//////////////////////////////////////////////////////////////////////////////////////////
1.使用swarm-overlay网络建立集群1。
docker run -d -p 30060:3306 --restart=always \
-e MYSQL_ROOT_PASSWORD=abc123 \
-e CLUSTER_NAME=percona \
-e XTRABACKUP_PASSWORD=abc123 \
-v /u06/user/pkg/percona/data1:/var/lib/mysql \
--privileged \
--name=percona_cluster_master-node1 \
--net=swarm-overlay \
percona/percona-xtradb-cluster

docker run -d -p 30061:3306 --restart=always \
-e MYSQL_ROOT_PASSWORD=abc123 \
-e CLUSTER_NAME=percona \
-e XTRABACKUP_PASSWORD=abc123 \
-e CLUSTER_JOIN=percona_cluster_master-node1 \
-v /u06/user/pkg/percona/data2/:/var/lib/mysql \
--privileged \
--name=percona_cluster_worker-node1  \
--net=swarm-overlay \
percona/percona-xtradb-cluster


2.查看日志看看有没有启动成功
docker logs -f 8a1113d070bd


没有授权，使用chmod -R 777  /u06/user/pkg/percona/data1 进行授权
使用ll /u06/user/pkg/percona/data1 查看权限情况


2.使用swarm-overlay网络建立集群2。（如果过程不成功，要重新运行容器，必须清理一下目录：rm -rf  /u06/user/pkg/percona/data3/*）
172.16.106.9
docker run -d -p 30062:3306 --restart=always \
-e MYSQL_ROOT_PASSWORD=abc123 \
-e CLUSTER_NAME=percona2 \
-e XTRABACKUP_PASSWORD=abc123 \
-v /u06/user/pkg/percona/data3:/var/lib/mysql \
--privileged \
--name=percona_cluster_master-node2 \
--net=swarm-overlay \
percona/percona-xtradb-cluster

172.16.106.25
docker run -d -p 30063:3306 --restart=always \
-e MYSQL_ROOT_PASSWORD=abc123 \
-e CLUSTER_NAME=percona2 \
-e XTRABACKUP_PASSWORD=abc123 \
-e CLUSTER_JOIN=percona_cluster_master-node2 \
-v /u06/user/pkg/percona/data4/:/var/lib/mysql \
--privileged \
--name=percona_cluster_worker-node2 \
--net=swarm-overlay \
percona/percona-xtradb-cluster


rm -rf  /u06/user/pkg/percona/data3/*


/////////////////////////////////////////////////////////////////////////////////
//////  第三次构建日记
/////////////////////////////////////////////////////////////////////////////////
构建镜像的命令：
docker build -t pls/pls-mycat:1.0 .
暴露端口号，不暴露将使用不了
指定网络：mysql集群应当与MyCat使用同一网段的集群。
指定别名
docker run -d -p 8066:8066 -p 9066:9066 --net=swarm-overlay --name mycat mycat:1.0
docker rm -f mycat
查看日志：使用docker exec -it 容器ID bash进入容器内部，
cd /mycat/logs
tail -f -n 0 mycat.log干掉日志
tail -f  mycat.log查看日志
mycat 不支持DISTINCT去重查询。

git checkout test进行分支切换
git merge uat把当前的分支进行合并

导出镜像和向目标服务器拷贝镜像，装载镜像，运行镜像：
docker save -o /u06/user/pkg/mycat/mycat.tar  mycat:1.0
scp /u06/user/pkg/mycat/mycat.tar 172.16.106.25:/u06/user/pkg/mycat/
ssh 172.16.106.25 'docker load -i /u06/user/pkg/mycat/mycat.tar'
docker run -d -p 9066:9066 -p 8066:8066  --network=swarm-overlay --name mycat mycat:1.0


集群版本的。
运行：
docker stack deploy -c pls-mycat.yml plsmycat
移除：
docker stack rm plsmycat
查看：
docker stack ls

更新集群（强制更新）：
docker service update --force --image award:1.0 awardswarm_award

运行镜像：
docker run -d -p 18066:8066 -p 19066:9066 --net=swarm-overlay --name pls-mycat pls/pls-mycat:1.0

挂载配置目录：
docker run -d -p 18066:8066 -p 19066:9066 -v /u06/user/pkg/pls-mycat:/mycat/conf --net=swarm-overlay --name pls-mycat pls/pls-mycat:1.0

提升节点从worker到manager的命令是：
docker node promote java-docker
java-docker 是所在worker的主机名称（查看命令是：hostname）


用于Jenkins构建的脚本命令：
award_service=$(docker service ls | grep awardswarm_award | awk '{print $1}')
if [ "$award_service" != "" ]; then
	echo "docker swarm根据镜像更新服务开始"
	docker service update --force --image award:1.0 awardswarm_award
	echo "docker swarm根据镜像更新服务结束"
else
	echo '执行Docker-compose(集群)开始'
	docker stack deploy -c award-docker-swarm.yml awardswarm
	echo '执行Docker-compose(集群)结束，休眠60秒'
fi