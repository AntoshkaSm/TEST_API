FROM maven:4.0.0-jdk-23.0.1
WORKDIR  /app
COPY .mvn/.mvn
COPY src/./src
ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD ["./TestApi"]