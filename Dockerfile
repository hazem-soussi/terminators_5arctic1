FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar  
EXPOSE 8089
// ENTRYPOINT ["java", "-jar", "tpAchatProject-1.0.jar"]
