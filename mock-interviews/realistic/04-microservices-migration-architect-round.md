# Realistic Mock 4 — Microservices Migration / Architect Round

**Format:** Client technical interview, architect-level · **Duration:** 75 min
**Use as:** interviewer script or self-practice.
**Real anchor:** this round *is* the CARB story — Struts → Spring Boot
migration (strangler), monolith → microservices, AWS migration (API
Gateway, Cognito, S3, CloudWatch). See [story-bank.md](story-bank.md).
CARB's cloud is **AWS** — this is the one round where naming AWS services
specifically is correct and expected.

---

### Background & scope (0:00–0:10)

**Ask:** "Give me an overview of a microservices migration you led — your
specific role, and how much you personally built versus supervised."
- *Follow-up:* "Was this the Struts → Spring Boot strangler migration, or
  the monolith → microservices split, or both — walk through how the two
  related, if they did."
- *Cross-question:* "Who actually made the final call on the service
  boundaries — you alone, a committee, someone above you? Walk through
  one real decision and who was in the room."

**Ask:** "How many services did the system end up split into, and how did
you arrive at that number — was it planned upfront or did it evolve?"

### Communication architecture (0:10–0:30)

**Ask:** "How did the services communicate with each other?"
- *Follow-up:* "Point-to-point or event-driven? Why that choice over the
  other, specifically for this system?"
- *Cross-question:* "What's a concrete situation where you now wish you'd
  picked the other one?"

**Ask:** "How was the API Gateway set up, and how did authentication flow
through it — where does a token get issued, and where does it get
validated?"
- *Cross-question:* "If the gateway is down, what happens to every
  service behind it? Is that an acceptable single point of failure, and
  if not, what's your mitigation?"

### Consistency patterns (0:30–0:50)

**Ask:** "What's the saga pattern? Did you actually implement one here —
walk through a specific saga end to end, including the compensating
steps."
- *Cross-question:* "What are the ways you'd ensure a database commit
  only happens once *all* the involved services have succeeded — compare
  that directly to the saga approach you just described, and tell me why
  you didn't use it."

**Ask:** "How can circuit breakers help in the communication between the
services you built specifically?"
- *Cross-question:* "Give me the actual numbers you'd configure — failure
  threshold, half-open retry interval — and how you'd arrive at them
  rather than guessing."

### Messaging (0:50–1:05)

**Ask:** "Why did you personally introduce Kafka producers and consumers
into this system? What was the actual use case driving it?"
- *Cross-question:* "What else did you consider before Kafka, and why did
  it lose?"

**Ask:** "Did you run into any issues with message ordering or duplicate
consumption? What happened, and how did you resolve it?"

### Frontend integration (1:05–1:15)

**Ask:** "Is it possible to refresh data in a React app using
server-side events? Have you used WebSocket or SSE in a real-time
feature?"
- *Cross-question:* "Why SSE over WebSocket, or vice versa, for that
  specific feature — what made one clearly better than the other here?"

**Candidate questions (1:15–1:20)**

---

## Debrief (for self-practice)

**Strong signals:** clean, honest split between "I built this" and "I
supervised/reviewed this"; saga answer includes real compensating actions
and explicitly contrasts against distributed-commit rather than treating
them as unrelated; gateway-as-SPOF question gets a real mitigation (HA
gateway deployment, client-side fallback) not "it doesn't go down."

**Weak signals:** can't give a real number for service count or hand-waves
the boundary decision; no real story for the Kafka ordering/duplicate
question once Kafka is mentioned at all — this should be rehearsed cold.
