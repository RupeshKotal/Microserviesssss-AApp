# # Use OpenJDK base image
# FROM openjdk:17-jdk-slim

# # Set working directory
# WORKDIR /app

# # Copy the JAR file into the container
# COPY target/department-service-0.0.1-SNAPSHOT.jar app.jar

# # Expose the port
# EXPOSE 8082

# # Run the JAR file
# ENTRYPOINT ["java", "-jar", "app.jar"]


# Use a multi-stage build for smaller final image
# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /usr/src/app

# Copy Maven project files
COPY pom.xml .
COPY src/ ./src/

# Cache dependencies and build the application
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal runtime image
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /usr/src/app/target/*.jar app.jar

# Create a non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Expose application port
EXPOSE 8080

# Set environment variables
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# Run the application
ENTRYPOINT ["sh", "-c"]
CMD ["java $JAVA_OPTS -jar app.jar"]
