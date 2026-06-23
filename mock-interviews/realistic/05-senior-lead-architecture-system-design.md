# Realistic Mock 5 — Senior/Lead Architecture & System Design

**Format:** Client technical interview, architect/staff panel · **Duration:** 75 min
**Use as:** interviewer script or self-practice.
**Real anchors:** WSI (Tech Anchor role, Azure) for org/leadership
questions; CARB (AWS) for migration/governance questions. See
[story-bank.md](story-bank.md) — don't cross the cloud streams.

This round tests judgment at the lead level — tradeoffs, not trivia. Every
question has a cross-question that pushes back on the first answer, the
way a real architect-level panel does.

---

### Background & scope (0:00–0:10)

**Ask:** "Tell me about the largest system you've been the lead architect
or tech lead for — scale, team size, and your actual decision-making
authority on it."
- *Cross-question:* "What's one architectural decision on that system you
  now think was wrong? What would you do differently?"

### Service boundaries & decomposition (0:10–0:25)

**Ask:** "How do you decide where one microservice ends and another
begins? Walk through a real split you made."
- *Follow-up:* "What signal told you the boundary was wrong, if any ever
  was?"
- *Cross-question:* "Two services end up needing the same piece of
  reference data constantly. Do you duplicate it, share a service, or
  share a database? Defend your answer."

**Ask:** "When does breaking a monolith into microservices actively make
things worse? Give me a real case, not a hypothetical."
- *Cross-question:* "If that's true, why did your team do it anyway, or
  why would you advise against it next time?"

### Data consistency (0:25–0:40)

**Ask:** "Design a flow where an order is placed, payment is charged, and
inventory is decremented — three separate services. How do you keep this
consistent?"
- *Follow-up:* "Walk through exactly what happens when payment succeeds
  but inventory decrement fails."
- *Cross-question:* "Your compensating transaction for a refund also
  fails — payment processor is down. What does the system do now? Don't
  say 'retry' without telling me the retry policy and what the customer
  sees in the meantime."

**Ask:** "When would two-phase commit actually still be the right call
over a saga, if ever?"
- *Cross-question:* "Given the latency and availability cost of 2PC, what
  specific constraint would have to be true for you to accept that cost?"

### Resilience (0:40–0:55)

**Ask:** "Design circuit breaker, retry, and bulkhead for a service calling
a flaky downstream dependency. Give me real starting numbers — failure
threshold, half-open interval, retry backoff."
- *Cross-question:* "Your retries just made the downstream service's
  outage worse instead of better. What did you get wrong, and how do you
  detect this happening in real time before it compounds?"

**Ask:** "Tell me about a cascading failure you've actually lived through.
What was the root cause, and what changed afterward so it couldn't happen
the same way twice?"
- *Cross-question:* "Six months later, would the fix you made have
  actually prevented a *different* cascading failure, or just that exact
  one?"

### Governance at scale (0:55–1:10)

**Ask:** "You're responsible for architecture consistency across 8 teams,
each shipping their own services independently. What's your actual
governance model?"
- *Cross-question:* "A team ignores your guardrail and ships anyway,
  because their deadline was real. What do you do — after the fact, and
  to prevent the next one?"

**Ask:** "How do you handle a technical disagreement with another senior
engineer or architect where you both have a legitimate case and no clear
right answer?"
- *Cross-question:* "What if you're overruled and you still think you're
  right — what do you do next?"

### Closing (1:10–1:15)

**Ask:** "If you had to cut scope on a major architectural initiative to
hit a hard deadline, what's the first thing you'd cut, and what would you
tell stakeholders you're explicitly deferring?"

**Candidate questions (1:15–1:20)**

---

## Debrief (for self-practice)

**Strong signals:** every "design this" answer includes a concrete failure
path, not just the happy path; admits a real past architectural mistake
with specifics; governance answer acknowledges the tradeoff of whichever
model is picked rather than presenting it as costless.

**Weak signals:** saga/compensating-transaction answer has no plan for
when the compensation *itself* fails; governance answer is pure
"mandatory review board" or pure "trust the teams" with no middle ground
or escalation path.
