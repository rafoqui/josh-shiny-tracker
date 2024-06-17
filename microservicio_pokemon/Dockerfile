FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/microservicio_pokemon-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} pokes.jar
ENTRYPOINT ["java","-jar","pokes.jar"]