FROM  openjdk:11
RUN mkdir app
WORKDIR /app
COPY /target/tpAchatProject-1.0.jar app/tpAchatProject-1.0.jar  
EXPOSE 8089
RUN "chmod 777 app/tpAchatProject-1.0.jar" 
ENTRYPOINT ["java","-jar"," tpAchatProject-1.0.jar"]

