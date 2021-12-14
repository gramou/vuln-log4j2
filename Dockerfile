FROM openjdk:8-jdk-alpine

#RUN apk add maven

COPY src .
COPY pom.xml .
#RUN mvn clean install
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]