FROM openjdk:14-alpine
RUN mkdir app
WORKDIR /app
COPY /target/tpAchatProject-1.0.jar app/tpAchatProject-1.0.jar  
EXPOSE 8089
RUN chmod 777 app/tpAchatProject-1.0.jar 
ENTRYPOINT ["java","-jar"," app/tpAchatProject-1.0.jar"]
CMD ["-start"]
