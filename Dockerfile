FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/money-exchange-api-1.0-SNAPSHOT.jar

WORKDIR /usr/local/runme

COPY ${JAR_FILE} app.jar
