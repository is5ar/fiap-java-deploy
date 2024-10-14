# Usando uma imagem base do Maven para construir a aplicação
FROM maven:3.8.4-openjdk-11-slim AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código fonte
COPY src ./src

# Compila a aplicação
RUN mvn package -DskipTests

# Usando uma imagem do OpenJDK para rodar a aplicação
FROM openjdk:11-jre-slim

# Copia o arquivo jar gerado para o container
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
