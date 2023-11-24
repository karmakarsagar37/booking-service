# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17

ENV MONGODB_URL=mongodb+srv://sagar:sagar12345@cluster0.ryfnwqt.mongodb.net/?retryWrites=true&w=majority
ENV DB_NAME=booking-test

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container

COPY ./target/java-aws-ecs-backend.jar java-aws-ecs-backend.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "java-aws-ecs-backend.jar"]
