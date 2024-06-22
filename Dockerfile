FROM openjdk:17-jdk-alpine
VOLUME /tmp
ENV IMG_PATH=/img
EXPOSE 8080
RUN mkdir -p /img
ADD ./target/demo-0.0.1-SNAPSHOT.jar app.jar
ADD ./src/main/resources/schema.sql /app/schema.sql
ENTRYPOINT ["java", "-jar", "app.jar"]