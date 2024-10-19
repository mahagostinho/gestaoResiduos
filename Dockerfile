# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Instalar o Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# Defina o diretório de trabalho no contêiner
WORKDIR /usr/app

# Copie o pom.xml para o contêiner e baixe as dependências
COPY pom.xml .

# Execute o Maven para baixar as dependências e gerar o JAR
RUN mvn clean install -DskipTests

# Copie o arquivo JAR gerado para o contêiner
COPY target/gestaoResiduos-0.0.1-SNAPSHOT.jar /usr/app/

# Exponha a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para rodar a aplicação no contêiner
CMD ["java", "-jar", "gestaoResiduos-0.0.1-SNAPSHOT.jar"]


