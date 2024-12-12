# Etapa de build
FROM maven:3.9.9-jdk-21 AS build

# Define o diretório de trabalho
WORKDIR /src/main

# Copia os arquivos do projeto para o container
COPY . .

# Executa o build do projeto
RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:21

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta (ajuste conforme sua aplicação)
EXPOSE 8080

# Comando para rodar o JAR
CMD ["java", "-jar", "app.jar"]
