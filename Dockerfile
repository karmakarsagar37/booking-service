# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17

ENV MONGODB_URL=mongodb+srv://sagar:sagar12345@cluster0.ryfnwqt.mongodb.net/?retryWrites=true&w=majority
ENV DB_NAME=booking-test

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container

COPY ./target/booking-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 9095

# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
