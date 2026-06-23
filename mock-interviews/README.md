# Mock Interviews — Lead Fullstack (13+ yrs), Java/Spring track

20 end-to-end mock interviews, written like a real client loop: intro → warm-up →
deep technical (with or without live coding) → behavioral/closing → my own
candidate questions. Each one is self-contained — read the prompt cold, set a
timer, answer out loud or in writing before peeking at the "what they're
listening for" notes.

Pulled from [java-developer-knowledge-base](../../java-developer-knowledge-base)
tiers and my own [track2-senior-mastery](../track2-senior-mastery) /
[track1-near-term](../track1-near-term) work — see the tier mapping in
`tier-mapping.md`.

## How to run one

1. Pick the next un-`#solid` one below.
2. Set a real timer (60–120 min as marked). No notes open, no KB open.
3. Talk or type your answers as if the interviewer is on the call.
4. Only after time's up: open the file's "debrief" section, grade yourself,
   tag weak spots `#shaky` / `#review` / `#solid` in a `notes.md` you add
   next to it.
5. Re-run any `#shaky` one in 2 weeks.

## The 20, in loop order

| # | File | Format | Duration | Focus |
|---|---|---|---|---|
| 1 | [01-java-core-concurrency.md](01-java-core-concurrency.md) | Tech, no coding | 60 min | JVM memory, concurrency |
| 2 | [02-collections-performance-coding.md](02-collections-performance-coding.md) | Tech + live coding | 90 min | Collections internals, perf, 2 coding problems |
| 3 | [03-spring-boot-api-design.md](03-spring-boot-api-design.md) | Tech, no coding | 60 min | DI internals, REST API design |
| 4 | [04-spring-security-oauth.md](04-spring-security-oauth.md) | Tech, no coding | 60 min | Security, OAuth2/JWT, OWASP |
| 5 | [05-sql-database-design.md](05-sql-database-design.md) | Tech + whiteboard SQL | 90 min | Indexing, N+1, transactions, migrations |
| 6 | [06-nosql-caching-coding.md](06-nosql-caching-coding.md) | Tech + live coding | 90 min | Redis/Mongo, cache design, 1 coding problem |
| 7 | [07-microservices-distributed-systems.md](07-microservices-distributed-systems.md) | Tech, no coding | 60 min | Sagas, resilience, messaging |
| 8 | [08-system-design-url-shortener-ratelimiter.md](08-system-design-url-shortener-ratelimiter.md) | Whiteboard system design | 60 min | URL shortener + rate limiter |
| 9 | [09-system-design-social-feed-scale.md](09-system-design-social-feed-scale.md) | Whiteboard system design | 90 min | Feed fan-out, 100M users |
| 10 | [10-coding-round-dsa.md](10-coding-round-dsa.md) | Pure live coding | 60 min | 3 DSA problems under time pressure |
| 11 | [11-design-patterns-clean-architecture.md](11-design-patterns-clean-architecture.md) | Tech + code critique | 60 min | SOLID, patterns, live critique exercise |
| 12 | [12-testing-strategy-quality.md](12-testing-strategy-quality.md) | Tech, no coding | 60 min | Test pyramid, flaky tests, quality gates |
| 13 | [13-cicd-docker-kubernetes.md](13-cicd-docker-kubernetes.md) | Tech, no coding | 60 min | Pipelines, Dockerfile, k8s probes |
| 14 | [14-observability-incident-review.md](14-observability-incident-review.md) | Behavioral + tech | 60 min | Real incident walkthrough, observability design |
| 15 | [15-performance-tuning-coding.md](15-performance-tuning-coding.md) | Tech + live coding | 90 min | JVM tuning, backpressure, 1 coding/profiling exercise |
| 16 | [16-fullstack-frontend-integration.md](16-fullstack-frontend-integration.md) | Tech, no coding | 60 min | API contracts, frontend integration, gaps to self-study |
| 17 | [17-architecture-review-adrs.md](17-architecture-review-adrs.md) | Whiteboard + doc critique | 90 min | ADRs, trade-off docs, migration planning |
| 18 | [18-leadership-mentoring-behavioral.md](18-leadership-mentoring-behavioral.md) | Pure behavioral | 60 min | Mentoring, reviews, growing engineers |
| 19 | [19-conflict-stakeholders-behavioral.md](19-conflict-stakeholders-behavioral.md) | Pure behavioral | 60 min | Conflict, incidents, stakeholder management |
| 20 | [20-final-loop-mixed-bar-raiser.md](20-final-loop-mixed-bar-raiser.md) | Mixed, 2 hrs | 120 min | Bar-raiser: technical + design + behavioral combined |

## Coverage note

Interviews 1–15, 17 draw on java-developer-knowledge-base (see
`tier-mapping.md`). Interviews 16, 18, 19, 20 lean partly or fully on original
material since the KB has no frontend content and only light leadership
material — flagged inline where that's the case.
