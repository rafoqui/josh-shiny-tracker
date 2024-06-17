FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/eureka_server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} eureka.jar
ENTRYPOINT ["java","-jar","eureka.jar"]