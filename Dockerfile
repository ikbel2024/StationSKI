# Utiliser l'image de base de Java 17
FROM openjdk:17-jdk-slim

# Spécifier le répertoire de travail dans l'image Docker
WORKDIR /app

# Copier le JAR généré dans le conteneur
COPY target/*.jar app.jar

# Exposer le port sur lequel l'application sera lancée
EXPOSE 8080

# Commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
