FROM java:8-jre-alpine
VOLUME /tmp
ADD *.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="" $JAVA_OPTS
#EXPOSE 8888
#更改时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
           && echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT [ "sh", "-c", "java  -jar /app.jar" ]