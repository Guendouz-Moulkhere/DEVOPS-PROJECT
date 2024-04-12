FROM openjdk:11
EXPOSE 8081
ADD target/imc-app-0.0.1-SNAPSHOT.jar imc-app.jar
ENTRYPOINT ["java", "-jar","/imc-app.jar"]