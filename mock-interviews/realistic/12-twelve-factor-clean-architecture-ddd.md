# Realistic Mock 12 — 12-Factor, Clean Architecture & Domain Modeling

**Format:** Client technical interview · **Duration:** 75 min
**Use as:** interviewer script or self-practice. Covers Track 2 weeks
2, 4, and 5 in one sitting — the way a real round often blends "how do you
design a service" questions together rather than separating them cleanly.

---

### 12-Factor (0:00–0:15)

**Ask:** "What does it mean to build a 12-factor, cloud-native Spring Boot
service? Walk through the ones that actually matter in practice."
- *Follow-up:* "How do you handle config — profiles, env vars, secrets —
  differently per environment without hardcoding anything?"
- *Cross-question:* "Your config approach works for one service. Does it
  still hold when you have 20 services each needing slightly different
  secrets and config sources? What changes?"

**Ask:** "What does 'processes should be stateless and disposable' mean
concretely for a Spring Boot REST API? What breaks if you violate it?"
- *Cross-question:* "Where did session or in-memory state sneak into a
  'stateless' service you've worked on, even unintentionally? How was it
  found?"

**Ask:** "How does your CI/CD pipeline separate build, release, and run as
distinct stages? Why does that separation actually matter?"

### Clean API design (0:15–0:35)

**Ask:** "Design a clean REST API for cart/checkout. Talk through DTOs vs.
entities, validation, error model, versioning, and idempotency keys."
- *Follow-up:* "Why not just expose your JPA entities directly as the
  API response? What specifically goes wrong?"
- *Cross-question:* "Your idempotency-key design — where does the key
  live, what's its retention window, and what happens on a *concurrent*
  repeat, not just a sequential retry?"

**Ask:** "Design your global exception model — what's the actual response
shape, and how do you keep error codes consistent as the API grows?"

**Ask:** "How do you propagate a correlation ID from the API entry point
through to downstream logs and services?"
- *Cross-question:* "A request fails three services deep. Walk through
  exactly how you'd trace it back using that correlation ID, end to end."

**Ask:** "How do you version this API without breaking clients who are
already integrated against v1?"

### Domain modeling / DDD-lite (0:35–0:55)

**Ask:** "Model the domain — not just the tables — for cart, checkout,
payment, fraud/risk, and order. What are your bounded contexts?"
- *Follow-up:* "Where's an aggregate in this model, and what invariant
  does it protect?"
- *Cross-question:* "Two of your bounded contexts both want to own
  'order status.' How do you resolve that, and what's the cost of getting
  it wrong?"

**Ask:** "What's an anti-corruption layer, and where would you put one
around a legacy system or a third-party client like a fraud/risk
provider?"
- *Cross-question:* "Give me a real case where a *missing* ACL let a
  legacy system's model leak into your clean domain and cause coupling.
  What did that coupling actually break later?"

**Ask:** "Tell me about a time a wrong bounded-context boundary caused
real coupling pain. What was the boundary, and how did you fix it without
a full rewrite?"

### Wrap-up (0:55–1:10)

**Ask:** "Pull it together — design the checkout service end to end: API
shape, domain boundaries, 12-factor config, and idempotency, in one
coherent walkthrough."

**Candidate questions (1:10–1:15)**

---

## Debrief (for self-practice)

**Strong signals:** 12-factor answer goes beyond config to disposability
and dev/prod parity unprompted; idempotency-key answer explicitly handles
the concurrent-repeat case (unique constraint, not just a lookup-then-act
race); DDD answer names a real invariant an aggregate protects, not just
"aggregates group related entities."

**Weak signals:** DTO-vs-entity answer with no concrete failure mode for
exposing entities directly (e.g., leaking lazy-loaded associations,
coupling API contract to schema changes); bounded-context answer with no
real story of a wrong boundary causing pain.
