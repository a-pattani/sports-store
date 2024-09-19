# Use the official Maven image to build the application
FROM maven:3.2.3-jdk17 AS build
WORKDIR /app

# Copy the pom.xml and project source files
COPY pom.xml .

# Download dependencies to the container cache
RUN mvn dependency:go-offline -B

COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use the official Tomcat image for Tomcat 9.0.93
FROM tomcat:9.0.93-jdk17

# Set the working directory inside the container
WORKDIR /usr/local/tomcat

# Copy your WAR file into the webapps directory of Tomcat
COPY ./target/store-1.0-SNAPSHOT.war webapps/ROOT.war

# Expose port 8080 for accessing the web application
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
