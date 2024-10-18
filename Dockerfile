# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /usr/app

# Copie o pom.xml e baixe as dependências
COPY pom.xml .

# Execute o Maven para baixar as dependências e gerar o JAR
RUN mvn clean install -DskipTests

# Copie o arquivo JAR gerado para o diretório do contêiner
COPY target/gestaoResiduos-0.0.1-SNAPSHOT.jar /usr/app/

# Exponha a porta onde a aplicação será executada
EXPOSE 8080

# Comando para iniciar o aplicativo
CMD ["java", "-jar", "gestaoResiduos-0.0.1-SNAPSHOT.jar"]

