# Story Bank — the crown jewel

Per the Master Bible: *"The asset no one else can copy, and the part most
candidates do worst. Do not leave these as titles — write each out and
rehearse to a tight two minutes."* Every mock in this folder expects you to
pull from here, not invent a fresh story live.

## The two project anchors

**WSI — eCommerce.** Cloud is **Azure-only**. Cart/checkout, Accertify
fraud/risk integration, Kafka producer/consumer (gift-card balance-inquiry
risk event), Tech Anchor role (reviews, offshore coordination, decisions).

**CARB — payments / state-government migration.** Cloud is **AWS**.
Struts → Spring Boot migration (strangler), monolith → microservices, AWS
migration (API Gateway, Cognito, S3, CloudWatch), Cognito/OAuth/JWT auth
flow, IMPS/payment switch (ISO8583 flow).

**Positioning trap to avoid:** never answer a WSI cloud question with AWS
specifics, or a CARB cloud question with Azure specifics. If a generic
"design this on AWS" question comes up and your real depth there is CARB,
say so. If it's WSI-flavored (eCommerce, Accertify, gift-card), map cloud
specifics to Azure: AKS (not EKS/ECS), Functions (not Lambda), Service Bus
/ Event Grid (not SQS/SNS), Cosmos DB (not DynamoDB), Azure SQL (not RDS).

## STAR-plus template (every story)

- **Context** — system, scale, your team, the stakes (1–2 lines).
- **Problem** — what was actually wrong or needed.
- **Your role** — specifically what *you* did, not "we."
- **Decision + alternatives** — the call you made, what you rejected, why.
- **Impact** — a defensible, bounded number.
- **What you'd do differently** — seniority and reflection.

**Honesty rule on numbers:** no exact figures? Don't invent precise ones —
a sharp interviewer asks "how did you measure that?" Use bounded phrasing:
"cut checkout p95 from roughly X to Y," "eliminated duplicate downstream
calls with an idempotent consumer." Bounded and honest survives
follow-ups; fabricated precision collapses.

## Stories to build (write each to 2 minutes, rehearse out loud)

**WSI / eCommerce**
- Cart & checkout optimization
- Accertify fraud/risk integration
- Kafka producer/consumer (keying, group, idempotency, DLQ)
- Gift-card balance-inquiry risk event
- Tech Anchor role (reviews, offshore, decisions)

**CARB · Payments**
- Struts → Spring Boot migration (strangler)
- Monolith → microservices (boundaries, ownership)
- AWS migration (API Gateway, Cognito, S3, CloudWatch)
- Cognito / OAuth / JWT auth flow
- IMPS / payment switch (ISO8583 flow)

**Cross-cutting**
- Production debugging (correlation ID → root cause → fix)
- Idempotency in payments (business key, safe reprocess)

Aim for 4–5 airtight stories, not 15 shallow ones — if one gets drilled and
it's thin, the whole project-anchoring strategy backfires.

## Concept → project mapping (Track 2)

| Concept | Project example |
|---|---|
| SRP | Controller-service-repository separation in checkout APIs |
| OCP | Payment/fraud rules via Strategy so new rules don't change orchestration |
| Builder | Accertify / device payload creation |
| Adapter | Wrapper around an external fraud/risk client |
| Observer | Kafka event flow for risk / eGift / gift-card events |
| 12-factor config | Profiles / env vars / secrets per environment |
| Idempotency | Payment/checkout/Kafka processing on a business key / event ID |
| Observability | Correlation ID from API to downstream logs; Kafka lag dashboard |
| Security | Cognito/OAuth/JWT in CARB; JWT filter chain in Spring Security |
| Leadership | Tech Anchor: reviews, offshore coordination, decisions, delivery |

## The Golden Answer Formula

Use this shape for any "how do you handle X" question:

1. **Direct answer** — one clear line, before any explanation.
2. **Why it matters** — the business or technical risk/benefit.
3. **How it works** — the mechanism or flow.
4. **Trade-offs** — limits, edge cases, alternatives.
5. **Real example** — WSI, CARB, or payments.
6. **What you'd improve** — shows seniority and reflection.

### Gold-standard skeletons (learn the shape, swap in your numbers)

**"How do you handle a downstream service failure?"**
Direct: timeout + retry w/ backoff + circuit breaker + fallback, with
idempotency so retries are safe. Why: a slow/dead dependency otherwise
cascades and exhausts threads. How: Resilience4j — timeout caps the wait,
retry handles blips, breaker opens on sustained failure, serves fallback.
Trade-off: fallback can be stale; retries without idempotency create
duplicates. Example: the Accertify fraud call in WSI checkout — protect
checkout latency when risk evaluation is slow. Improve: add bulkhead
isolation so one slow dependency can't starve the rest.

**"How do you handle duplicate Kafka messages?"**
Direct: an idempotent consumer keyed on event ID or business key. Why:
real systems run at-least-once, so the same event sometimes arrives
twice. How: check a processed-ID store before acting; skip if seen,
otherwise process and record the ID. Trade-off: the dedup store costs
storage and a lookup; size its TTL to the redelivery window. Example: the
gift-card balance-inquiry risk event — no duplicate downstream calls or
wrong status. Improve: use the DB transaction + an outbox so processing
and the dedup record commit together.

**"Explain the JPA N+1 problem and how you fix it."**
Direct: one query loads the parents, then one extra query per child — N+1
round trips. Why: quietly turns one logical read into hundreds, blowing up
latency under load. How: a fetch join or `@EntityGraph` loads children in
one query; batch fetching is the middle ground. Trade-off: multiple fetch
joins cause a cartesian explosion — prefer `@EntityGraph` or batch size for
several collections. Example: loading a checkout order with its line
items and promotions in one go. Improve: read paths often want projection
DTOs instead of full entities.

**"How do you guarantee idempotency in checkout/payment?"**
Direct: a client-supplied idempotency key (or business key) that makes a
repeated request a no-op. Why: network retries and double-clicks must
never charge twice or place two orders. How: persist the key with the
result; on a repeat, return the stored result instead of re-executing.
Trade-off: needs a key store and a retention window; concurrent repeats
need a unique constraint. Example: idempotent checkout/payment endpoints
at WSI; in payments, the transaction reference is the key. Improve:
combine with an outbox so the side effect and the key commit atomically.

**"API latency jumped from 200ms to 5s — how do you debug?"**
Direct: walk a diagnostic ladder — confirm the symptom, read metrics
first, then narrow to a layer before touching code. Why: latency can come
from app code, GC pauses, thread-pool exhaustion, the DB, a slow
downstream, or the network — guessing wastes the outage. How: check
dashboards (p95/p99, error rate, CPU, heap, GC, pool saturation); narrow
with traces and correlation IDs; confirm with thread/heap dumps or
slow-query logs. Trade-off: a fast rollback restores service but hides the
root cause — capture diagnostics first if you can. Example: checkout p95
regression at WSI traced through correlation IDs to a slow Accertify
call; fixed with timeout + circuit breaker. Improve: add an alert and a
runbook so the same regression is caught automatically next time.

## Honesty guardrail (applies everywhere, especially AI/RAG and cloud)

- Don't claim production ownership of something that was only a demo.
- Don't claim model training unless you actually trained/fine-tuned one.
- Don't claim AWS production expertise for WSI, or Azure for CARB.
- Say "I built / explored / prototyped" when that's the honest level.
- Speak in the first person ("I"), not "we." Lead with a number. Have the
  rejected alternative ready for the follow-up.
