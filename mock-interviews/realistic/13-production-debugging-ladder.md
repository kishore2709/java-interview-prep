# Realistic Mock 13 — Production Debugging, the Diagnostic Ladder

**Format:** Client technical interview, scenario-driven · **Duration:** 60 min
**Use as:** interviewer script or self-practice.

The format senior/lead interviews actually use for these: **don't jump to
a fix.** Walk the method out loud, then narrow to the likely layer.

> **Diagnostic Ladder:** reproduce/confirm the symptom → metrics/dashboards
> first → narrow the layer (app code, GC, threads, DB, downstream,
> network) → form a hypothesis → verify with logs/traces/heap or thread
> dumps → fix → add a guardrail (alert, test, runbook) so it can't
> silently recur.

For each scenario below, narrate the ladder before naming a fix.

---

**Ask:** "API latency jumped from 200ms to 5 seconds. How do you debug
it?"
- *Cross-question:* "You jumped straight to 'it's probably the database.'
  What did you check *before* forming that hypothesis?"
- *(listen for: this is the master-bible gold answer — checkout p95 at
  WSI traced via correlation IDs to a slow Accertify call, fixed with
  timeout + circuit breaker)*

**Ask:** "JVM memory keeps growing and never comes back down. Find the
leak."
- *Cross-question:* "Heap dump shows thousands of instances of one class
  you don't recognize as obviously leaking. What's your next move?"

**Ask:** "CPU is pinned at 100%. What do you check?"
- *Cross-question:* "Thread dump shows most threads in `RUNNABLE`, none
  blocked. Does that point you toward GC, application logic, or
  something else? Why?"

**Ask:** "The database got noticeably slower right after a deploy. Walk
through your process."
- *Cross-question:* "It's not a schema or query change in the diff. What
  else could a routine deploy change that would slow down the DB?"

**Ask:** "A thread-pool queue keeps growing and never drains. Diagnose
it."
- *Cross-question:* "Is this a sizing problem, a deadlock, or a slow
  downstream call? How do you tell the difference quickly?"

**Ask:** "Kafka consumer lag is climbing. How do you find out why, and
how do you fix it?"
- *Cross-question:* "Adding more consumer instances doesn't help. What
  does that tell you about where the bottleneck actually is?"

**Ask:** "Checkout p95 regressed overnight with no deploy in between.
What's your process?"
- *Cross-question:* "No code changed, no deploy happened — what kinds of
  causes are even possible here? Name at least three categories."

**Ask:** "A downstream dependency started timing out intermittently.
Walk through detection and mitigation."

**Ask:** "Design a cache for 10 million users' session or profile data.
What's your eviction policy, and how do you keep it from going stale?"

**Ask:** "Design a rate limiter backed by Redis for an API gateway. What's
the atomicity concern, and how do you solve it?"

---

## Wrap-up (0:55–1:00)

**Ask:** "Of all these, which class of bug have you actually lived
through in production, and which have you only reasoned about
theoretically? Be honest — I'll weight the real one more."

**Candidate questions**

---

## Debrief (for self-practice)

**Strong signals:** every answer states the ladder order out loud
(symptom confirmation → metrics → narrow layer → hypothesis → verify →
fix → guardrail) before naming a specific tool; the "no deploy happened"
cross-question correctly broadens to external causes (traffic pattern
change, a downstream dependency's own regression, a data-shape change, a
certificate/config expiry) instead of staying stuck on code.

**Weak signals:** jumps straight to a fix without confirming the symptom
or checking metrics first; treats every scenario as "check the logs" with
no specific dashboard, tool, or metric named.
