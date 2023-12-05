FROM gradle:8-jdk21-alpine AS build

WORKDIR /app

COPY src ./src
COPY build.gradle.kts .

RUN gradle build -x test


FROM eclipse-temurin:21-jre-alpine
RUN apk add dumb-init

RUN addgroup --system appuser && adduser -S -s /bin/false -G appuser appuser

WORKDIR /app
RUN chown -R appuser:appuser /app

COPY --from=build --chown=appuser:appuser /app/build/libs/app-1.0-SNAPSHOT.jar app.jar

USER appuser

ENTRYPOINT ["dumb-init", "--"]
CMD "java" "-jar" "app.jar"
