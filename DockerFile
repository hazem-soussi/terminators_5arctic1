FROM openjdk:11-alpine
RUN mkdir app
WORKDIR /app
COPY /target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar  
EXPOSE 8089
CMD ["java","-jar","tpAchatProject-1.0.jar"] 