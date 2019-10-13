FROM java:8-jre-alpine
VOLUME /tmp
ADD *.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="" $JAVA_OPTS
#EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java  -jar /app.jar" ]