FROM java:8-jre-alpine
VOLUME /tmp
ADD security.war app.war
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="" $JAVA_OPTS
#EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java  -jar /app.war" ]