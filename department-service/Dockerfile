# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /usr/src/app

# Copy Maven project files
COPY pom.xml .  

# Cache dependencies separately (improves build performance)
RUN mvn dependency:go-offline -B

# Copy source code and build the project
COPY src/ ./src/
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
EXPOSE 8082

# Set environment variables
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# Run the application
ENTRYPOINT ["sh", "-c"]
CMD ["java $JAVA_OPTS -jar app.jar"]