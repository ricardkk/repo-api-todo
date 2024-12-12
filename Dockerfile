# Etapa de build
FROM maven:3.8.7-jdk-17 AS build

# Define o diretório de trabalho
WORKDIR /src/main

# Copia os arquivos do projeto para o container
COPY . .

# Executa o build do projeto
RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /src/main/target/*.jar app.jar

# Expõe a porta (ajuste conforme sua aplicação)
EXPOSE 8080

# Comando para rodar o JAR
CMD ["java", "-jar", "app.jar"]
