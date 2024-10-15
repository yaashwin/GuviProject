# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory into the container
COPY target/Guvi_Project-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application's port
EXPOSE 8080

# Run the jar file when the container launches
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

