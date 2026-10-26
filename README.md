# Landon Hotel: Multithreaded Spring Boot + Angular App

A hotel reservation app with a Spring Boot back end and an Angular front end. I extended it with multithreaded localization, time zone conversion, and multi-currency pricing, and packaged it as a single Docker image.

## What I built

- **Multithreaded bilingual welcome:** `WelcomeMessageService` loads English and French `ResourceBundle`s on two separate threads, joins them, and returns both messages to the UI.
- **Time zone conversion:** `TimeZoneService` converts a `ZonedDateTime` between Eastern, Mountain, and UTC with `withZoneSameInstant`. It's used to announce a live presentation's start time in all three zones.
- **REST endpoints:** `GET /api/messages/welcome` and `GET /api/messages/presentation-time`, called by the Angular front end.
- **Multi-currency prices:** each room's price is shown in U.S. dollars, Canadian dollars, and euros.
- **Docker:** a multi-stage `Dockerfile`. The Maven + Node stage builds the Angular UI and the Spring Boot JAR, and a slim JRE stage runs the app.

## Tech stack

Java 17, Spring Boot, Spring Data JPA, H2, Angular, TypeScript, Docker, Maven

## Running with Docker

```bash
docker build -t landon-hotel .
docker run -d -p 8080:8080 --name landon-hotel landon-hotel
```

Then open http://localhost:8080.

## Running locally

```bash
./mvnw spring-boot:run
```

## Deploying to the cloud

The image can be pushed to Amazon ECR and run on AWS (ECS Fargate or Elastic Beanstalk), with a managed database in place of H2 for production.

## Credits

Built on a Landon Hotel reservation starter template, which provided the base Spring Boot API, the reservation and room model, and the Angular UI (see the first commits). The localization, multithreading, time zone, currency, and Docker work are my own.
