# Use Eclipse Temurin JDK 17 (reliable, official)
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (caches dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execute permission to Maven wrapper
RUN chmod +x mvnw

# Download dependencies offline
RUN ./mvnw dependency:go-offline -B

# Copy all source code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Expose port your app runs on
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/loan-backend-0.0.1-SNAPSHOT.jar"]
