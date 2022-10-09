FROM java:8
EXPOSE 8080
MAINTAINER webull
VOLUME /tmp
COPY target/cloudControl.jar  /app.jar
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","app.jar","-c"]
