FROM java:8-jre-alpine
VOLUME /tmp
ADD target/security.war app.war
#拷贝东西进去容器
#COPY ./sapjco3/libsapjco3.jnilib /usr/local/openjdk-8/jre/lib/ext/
#更改时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
           && echo 'Asia/Shanghai' >/etc/timezone
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="" $JAVA_OPTS
#EXPOSE 8888

ENTRYPOINT [ "sh", "-c", "java  -jar /app.war" ]