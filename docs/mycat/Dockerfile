FROM ubuntu:18.10
ADD Mycat-server-1.6.6.1-release-20181031195535-linux.tar.gz /
ADD jre-8u201-linux-x64.tar.gz /
# 假如在不需要代理的情况下，则应移除 “http_proxy=http://huang-ji-xin:huang@172.16.129.7:8010 \ &&”和 “\ && unset http_proxy”,该段表示的意义是：修改时区。
RUN export http_proxy=http://huang-ji-xin:huang@172.16.129.7:8010 \
        && apt-get update -y \
        && apt-get install -y tzdata \
        && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
        && unset http_proxy
EXPOSE 8066
EXPOSE 9066
#将配置文件拷入镜像中
COPY conf/server.xml /mycat/conf/
COPY conf/schema.xml /mycat/conf/
COPY conf/rule.xml /mycat/conf/
COPY conf/sequence_db_conf.properties /mycat/conf/
ENV JAVA_HOME /jre1.8.0_201
ENV MYCAT_HOME /mycat
ENV PATH $JAVA_HOME/bin:$MYCAT_HOME/bin:$PATH
CMD sh -c '/mycat/bin/mycat console'