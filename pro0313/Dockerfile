FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src src

RUN chmod +x gradlew
RUN ./gradlew build -x test

CMD ["java", "-jar", "build/libs/pro0313-0.0.1-SNAPSHOT.jar"]