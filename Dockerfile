FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY . .

RUN sed -i 's/\r$//' gradlew && chmod +x gradlew
RUN ./gradlew clean build -x test

CMD ["java", "-jar", "build/libs/transacciones-0.0.1-SNAPSHOT.jar"]