FROM openjdk:11.0.16-jdk-slim

COPY target/catalogo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8086