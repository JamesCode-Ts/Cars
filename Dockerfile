FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .


# Download and install Gradle
RUN \
    cd /usr/local && \
    curl -L https://services.gradle.org/distributions/gradle-2.5-bin.zip -o gradle-2.5-bin.zip && \
    unzip gradle-2.5-bin.zip && \
    rm gradle-2.5-bin.zip

# Export some environment variables
ENV GRADLE_HOME=/usr/local/gradle-2.5
ENV PATH=$PATH:$GRADLE_HOME/bin JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Define default command.
CMD ["bash"]