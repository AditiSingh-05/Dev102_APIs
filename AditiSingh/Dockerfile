# --- Stage 1: Build the application ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copy project files
COPY demo/pom.xml .
COPY demo/src ./src

# Build the application
RUN mvn clean package -DskipTests

# --- Stage 2: Run the application ---
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy only the built JAR file from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set environment variable
ENV SPRING_PROFILES_ACTIVE=prod

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
