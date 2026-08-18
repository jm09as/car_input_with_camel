FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/quarkus-app/ /app/
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]