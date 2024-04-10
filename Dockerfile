# Estágio de construção
FROM ubuntu:latest AS build

# Atualiza os repositórios e instala as dependências
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk curl zip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho e copia o código-fonte
WORKDIR /usr/local
COPY . .

# Baixa e instala o Gradle
RUN curl -L https://services.gradle.org/distributions/gradle-2.5-bin.zip -o gradle-2.5-bin.zip && \
    unzip gradle-2.5-bin.zip && \
    rm gradle-2.5-bin.zip

# Estágio de execução
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Define o diretório de trabalho
WORKDIR /usr/local/app

# Copia o arquivo JAR do estágio de construção
COPY --from=build /usr/local/build/libs/cars-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de inicialização do contêiner
ENTRYPOINT ["java", "-jar", "app.jar"]
