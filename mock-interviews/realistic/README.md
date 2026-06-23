# Realistic Mock Interviews — ready-to-run client interview scripts

Pure technical/client-interview content — no staffing-agency logistics.
Built from three layers:

1. **[story-bank.md](story-bank.md)** and **[cheat-sheet.md](cheat-sheet.md)**
   — pulled directly from the Master Bible and Tracks 1–4 in
   [../../tracks](../../tracks): the WSI/CARB project anchors, the Golden
   Answer Formula, gold-standard answer skeletons, the Diagnostic Ladder,
   and the day-before traps. **Read these two first** — every mock below
   assumes you've internalized them.
2. **The mocks themselves (01–17)** — full Ask → Follow-up → Cross-question
   scripts, grounded in the exact weekly framing from
   [track2-senior-mastery](../../track2-senior-mastery),
   [track1-near-term](../../track1-near-term), and the real interview
   patterns in [MyInterviewExperiences](../../../MyInterviewExperiences).
3. **[java-developer-knowledge-base](../../../java-developer-knowledge-base)**
   — the textbook to go deeper on any topic a mock exposes as weak. See
   the tier pointers in each mock's debrief.

## The two project anchors — internalize before running any mock

- **WSI** — eCommerce. Cloud is **Azure-only**. Cart/checkout, Accertify
  fraud/risk, Kafka gift-card events, Tech Anchor (reviews, offshore,
  decisions).
- **CARB** — payments / state-gov migration. Cloud is **AWS**. Struts →
  Spring Boot strangler, monolith → microservices, Cognito/API
  Gateway/S3/CloudWatch, IMPS/ISO8583.
- **Never cross them** — answering a WSI cloud question with AWS specifics
  (or vice versa) is the exact positioning trap Track 4 calls out.

## How to use these

**As the candidate (practicing):** pick one, set a timer for the stated
duration, answer out loud as if the call is real. Don't open the KB or
notes — but do have story-bank.md's stories already rehearsed, the way
you would before a real call.

**As the interviewer (running someone else through it tomorrow):** read
the **Ask** line verbatim. If they answer well, use the **Follow-up** to
go deeper. If shallow, vague, or wrong, use the **Cross-question** to
probe or challenge it. The `(listen for: ...)` notes tell you what a
strong answer actually contains.

## The 17 scripts

| # | File | Focus | Duration | Coding? |
|---|---|---|---|---|
| 1 | [01-core-java-spring-boot-generalist.md](01-core-java-spring-boot-generalist.md) | General Java + Spring Boot | 60 min | Light |
| 2 | [02-payment-gateway-fintech-deep-dive.md](02-payment-gateway-fintech-deep-dive.md) | Payments/fintech, security, Kafka (CARB) | 60 min | No |
| 3 | [03-parking-system-design-fullstack.md](03-parking-system-design-fullstack.md) | Live system design + Angular/React | 75 min | Design only |
| 4 | [04-microservices-migration-architect-round.md](04-microservices-migration-architect-round.md) | Migration leadership (CARB, AWS) | 75 min | No |
| 5 | [05-senior-lead-architecture-system-design.md](05-senior-lead-architecture-system-design.md) | Senior/lead architecture & judgment | 75 min | No |
| 6 | [06-rapid-fire-spring-kafka-jpa.md](06-rapid-fire-spring-kafka-jpa.md) | Fast topic jumps across the stack | 45 min | No |
| 7 | [07-build-it-live-customer-order-app.md](07-build-it-live-customer-order-app.md) | Live build + concurrency | 75 min | Yes, heavy |
| 8 | [08-production-support-java-internals.md](08-production-support-java-internals.md) | On-call + JVM internals | 60 min | Yes, 2 small |
| 9 | [09-leadership-conflict-behavioral.md](09-leadership-conflict-behavioral.md) | Leadership, conflict (WSI Tech Anchor) | 45 min | No |
| 10 | [10-final-loop-everything-at-once.md](10-final-loop-everything-at-once.md) | Full 2-hour mixed final round | 120 min | Yes, embedded |
| 11 | [11-design-patterns-project-mapping.md](11-design-patterns-project-mapping.md) | Patterns mapped to WSI/CARB (Track 2 Wk3) | 60 min | No |
| 12 | [12-twelve-factor-clean-architecture-ddd.md](12-twelve-factor-clean-architecture-ddd.md) | 12-factor, clean API, DDD-lite (Wk 2/4/5) | 75 min | No |
| 13 | [13-production-debugging-ladder.md](13-production-debugging-ladder.md) | The Diagnostic Ladder, 10 real scenarios | 60 min | No |
| 14 | [14-coding-filters-bank.md](14-coding-filters-bank.md) | LRU, top-K, BST, threading coding screens | 75 min | Yes, heavy |
| 15 | [15-sql-db-scaling.md](15-sql-db-scaling.md) | Window functions, indexing, scaling order | 60 min | SQL only |
| 16 | [16-ai-rag-positioning.md](16-ai-rag-positioning.md) | AI/RAG differentiator, honesty guardrails | 45 min | No |
| 17 | [17-modern-java-concurrency-theory.md](17-modern-java-concurrency-theory.md) | Java 17/21, virtual threads, concurrency | 60 min | Light |

## What's deliberately out of scope

**Track 4 (advanced gaps)** — DP/graphs, deep AWS/K8s/SRE, JVM internals
deep-dive, advanced distributed systems, deep NoSQL/search — is gated
"learn only if a JD asks" by the track system itself. No mock here covers
it by default. If you're prepping for a specific JD that names one of
these, say so and a targeted mock can be built — don't pre-build it on
spec.

## Suggested order for a tight week

Mirrors the Master Bible's weekly operating schedule: 1 → 14 → 2 → 11/12
→ 13 → 15 → 9 → 10, with 16/17 worked in wherever there's slack. Score
every run on the Mock Scorecard logic from the Master Bible: open
(answered before explaining), structure (no rambling), example (real
project + number), follow-up (handled the curveball), time (finished in
the window).
