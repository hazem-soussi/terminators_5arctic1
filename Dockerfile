FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY /target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar  
EXPOSE 8089

