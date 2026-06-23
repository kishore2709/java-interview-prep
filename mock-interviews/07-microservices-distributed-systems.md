# Mock 7 — Microservices & Distributed Systems

**Format:** Technical, no coding · **Duration:** 60 min
**KB tiers:** 9 (Microservices Patterns)

---

## Interviewer opening (0:00)

> "This round is distributed-systems judgment — communication patterns,
> failure handling, data consistency across services you don't fully
> control. I want real architecture decisions, not pattern names."

Timer: 60 minutes.

## Part 1 — Communication (0:00–0:15)

1. "Sync REST vs async messaging between two services — give me your actual
   decision framework, with a real example of each from your career."
2. "Service discovery and load balancing — client-side vs server-side, which
   have you run in production, and what broke?"

## Part 2 — Consistency & transactions (0:15–0:35)

3. "Order placed → payment charged → inventory decremented, across 3
   services. Design this with the saga pattern. Orchestration or
   choreography — defend your choice."
4. "What happens when step 2 (payment) succeeds but step 3 (inventory)
   fails? Walk through your compensating transaction."
5. "When would 2PC actually still be the right call over a saga, if ever?"

## Part 3 — Resilience (0:35–0:50)

6. "Design circuit breaker + retry + bulkhead for a service calling a
   flaky downstream dependency. What are the actual threshold numbers
   you'd start with, and how do you tune them from real data?"
7. "Retry storms — a downstream service degrades, and your retries make it
   worse. How do you detect and prevent this?"
8. "Tell me about a cascading failure you've actually lived through. What
   was the root cause and the fix that actually stuck?"

## Part 4 — Config & observability across services (0:50–0:58)

9. "Config management for 30 microservices across dev/staging/prod, owned
   by different teams — what's your actual setup?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:** saga answer includes concrete compensating actions, not
just "we roll back" — and acknowledges sagas are eventually consistent, with
a real example of a user-visible consequence of that. Circuit breaker
answer has real numbers (failure threshold %, half-open retry interval).

**Weak signals:** treats sagas as a free lunch with no compensation
complexity; can't name a real cascading-failure root cause.
