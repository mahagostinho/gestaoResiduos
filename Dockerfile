FROM openjdk:17-jdk-slim
COPY target/gestaoResiduos-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
CMD ["java", "-jar", "gestaoResiduos-0.0.1-SNAPSHOT.jar"]

