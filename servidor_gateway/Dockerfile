FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/servidor_gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java","-jar","gateway.jar"]