FROM openjdk:11
ADD target/*.jar /
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/ tpAchatProject-1.0.jar"]
