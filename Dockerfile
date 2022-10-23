FROM openjdk:14-alpine
RUN mkdir app
WORKDIR /app
EXPOSE 8089
CMD ["java","-jar","tpAchatProject-1.0.jar"] 