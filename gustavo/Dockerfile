# ==================================
# ESTÁGIO 1: BUILD (Compilação do JAR)
# ==================================
# Usa uma imagem do Maven com o JDK 21 para compilar o projeto
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o POM para baixar as dependências e o código
COPY pom.xml .
COPY src /app/src

# Executa o build, pulando testes para um build mais rápido na nuvem
# Isso gera o arquivo JAR na pasta target/
RUN mvn clean package -DskipTests

# ==================================
# ESTÁGIO 2: RUNTIME (Execução do JAR)
# ==================================
# Usa uma imagem JRE 21 mais leve (sem o SDK/Maven) para rodar a aplicação
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o JAR compilado do estágio 'build' para o estágio 'runtime'
# O nome do seu JAR é gustavo-0.0.1-SNAPSHOT.jar (baseado no pom.xml)
COPY --from=build /app/target/gustavo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando que será executado quando o container iniciar
# Ele inicia o seu JAR usando o Java Runtime
ENTRYPOINT ["java", "-jar", "app.jar"]