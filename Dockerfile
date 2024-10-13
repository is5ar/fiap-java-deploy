# Etapa de build
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Etapa de execução
FROM eclipse-temurin:11-jdk
WORKDIR /app
COPY --from=build /app/target/Semaforo.jar /app/Semaforo.jar
CMD ["java", "-jar", "/app/Semaforo.jar"]
