# Usa imagem oficial do Java
FROM eclipse-temurin:17-jdk-alpine

# Define pasta de trabalho
WORKDIR /app

# Copia o projeto
COPY . .

# Dá permissão para o mvnw (caso use)
RUN chmod +x mvnw

# Faz o build do projeto
RUN ./mvnw clean package -DskipTests

# Expõe a porta (Render usa variável PORT)
EXPOSE 8080

# Comando para rodar o projeto
CMD ["sh", "-c", "java -Dserver.port=${PORT} -jar target/*.jar"]