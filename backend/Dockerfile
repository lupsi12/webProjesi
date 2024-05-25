FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Install necessary tools and dependencies
RUN apt-get update && \
    apt-get install -y wget tar && \
    rm -rf /var/lib/apt/lists/*

# Download and install Maven
RUN wget https://downloads.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz && \
    tar xzf apache-maven-3.9.6-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.6 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

# Set Maven environment variables
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH

# Copy the project files
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/web_proje-0.0.1-SNAPSHOT.jar"]