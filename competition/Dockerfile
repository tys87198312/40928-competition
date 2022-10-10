FROM java:8
EXPOSE 8080
MAINTAINER dragee
VOLUME /tmp
COPY target/back.jar  /app.jar
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","app.jar","-c"]
