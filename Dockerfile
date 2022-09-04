FROM eclipse-temurin:11

RUN groupadd -r watchnext && useradd --no-log-init -r -m -g watchnext watchnext

WORKDIR /app
COPY ./target/watchnext-webapp-0.0.1-SNAPSHOT.jar /app

USER watchnext

ENV WATCHNEXT_DATADIR=/data

EXPOSE 8080

CMD exec java -jar watchnext-webapp-0.0.1-SNAPSHOT.jar
