# Start with an official Maven image to build the application
FROM maven:3.8.8-eclipse-temurin-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY ./api .

# Build the application
RUN mvn clean package -DskipTests

# Use a smaller JDK image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built application JAR from the builder stage
COPY --from=builder /app/target/user-management-api*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
