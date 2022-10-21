FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD /var/lib/jenkins/workspace/first_pipeline/target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar  
EXPOSE 8089
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar  "]
