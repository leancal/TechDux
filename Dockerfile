# Dockerfile

# Use the official OpenJDK image as a parent image
FROM adoptopenjdk/openjdk17:alpine-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the specified working directory
COPY target/pruebatecnica-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the app runs in
EXPOSE 8080

# Run the specified command within the container
CMD ["java", "-jar", "app.jar"]
