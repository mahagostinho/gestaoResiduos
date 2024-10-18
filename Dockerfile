# Use a imagem oficial do OpenJDK 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven para dentro do contêiner
COPY target/myapp.jar /app/myapp.jar

# Defina o comando para rodar a aplicação
CMD ["java", "-jar", "myapp.jar"]
