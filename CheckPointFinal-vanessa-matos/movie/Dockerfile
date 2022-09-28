FROM openjdk:11.0.16-jdk-slim
ARG JAR_FILE=target/movie.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
EXPOSE 8086