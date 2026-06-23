# Projects

Bigger, standalone practice builds — too large to live inside a track day/week folder. Each project is **self-contained**: its own folder, its own `README.md`, its own build file (`pom.xml` / `build.gradle`), runs on its own.

| Project | Stack | What it practices |
| --- | --- | --- |
| [springboot-rest-api/](springboot-rest-api/) | Spring Boot | REST, layering, validation, error model, OpenAPI |
| [java-lru-cache/](java-lru-cache/) | Plain Java | LRU with HashMap + doubly linked list, TTL, generics |

Add a new project as a new folder here. Keep its README to: what it is, how to run it, what I learned.

## Conventions
- One project = one folder = one build. Don't nest unrelated projects.
- Spring Boot: standard Maven/Gradle layout (`src/main/java`, `src/main/resources`).
- Link from a track note if a project demonstrates that track's topic (e.g. a RAG mini app ↔ Track 3).
