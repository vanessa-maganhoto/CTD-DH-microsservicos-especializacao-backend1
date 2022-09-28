#FROM openjdk:11.0.16-jdk-slim
FROM openjdk:11.0.16-jdk-slim
ARG JAR_FILE=target/catalogo.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
EXPOSE 8084