# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/github-profile-analyzer-0.0.1-SNAPSHOT.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
