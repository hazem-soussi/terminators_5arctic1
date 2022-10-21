FROM openjdk:11
COPY target/ tpAchatProject-1.0.jar  tpAchatProject-1.0.jar
ENTRYPOINT ["java", "-jar", "/ tpAchatProject-1.0.jar"]
