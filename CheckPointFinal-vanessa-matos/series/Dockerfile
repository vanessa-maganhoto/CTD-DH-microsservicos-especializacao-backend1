FROM openjdk:11.0.16-jdk-slim
ARG JAR_FILE=target/series.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
EXPOSE 8087