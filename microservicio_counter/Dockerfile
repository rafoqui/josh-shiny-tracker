FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/microservicio_counter-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} contador.jar
ENTRYPOINT ["java","-jar","contador.jar"]