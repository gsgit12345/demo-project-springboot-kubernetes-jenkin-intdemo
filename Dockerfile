FROM  openjdk:17-jdk-slim-buster
ENV PORT 8082
COPY  target/*.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT exec java -jar app.jar