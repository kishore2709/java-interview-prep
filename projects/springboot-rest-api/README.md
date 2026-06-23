# Spring Boot REST API (practice)

A small Spring Boot service to practice production-grade REST: controller/service/repository layering, DTO validation, a global exception model, and OpenAPI docs.

> Scaffold this as a normal Maven project (`src/main/java/...`, `pom.xml`). Generate from https://start.spring.io with Web + Validation + (optionally) JPA.

## Run
```bash
./mvnw spring-boot:run
```

## What I'm practicing
- [ ] Clean controller → service → repository separation (SRP)
- [ ] `@Valid` request validation + `@ControllerAdvice` global errors
- [ ] Idempotent endpoint design
- [ ] OpenAPI / Swagger UI
