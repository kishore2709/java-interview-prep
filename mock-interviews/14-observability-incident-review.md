# Mock 14 — Observability Design & Real Incident Review

**Format:** Behavioral + technical · **Duration:** 60 min
**KB tiers:** 12 (Logging & Monitoring), Track2 week06

---

## Interviewer opening (0:00)

> "Half of this is you walking me through a real incident you led, half is
> a design exercise on observability. I'll interrupt with follow-ups on the
> incident story — I want depth, not a polished narrative."

Timer: 60 minutes.

## Part 1 — Real incident walkthrough (0:00–0:25)

"Tell me about a P1/P0 production incident you personally led the response
for. Use this structure, and I'll probe each phase:"

1. Detection — "How did you find out? Alert, customer report, dashboard?
   How long from cause to detection?"
2. Triage — "What was your first action, and why that one first?"
3. Mitigation — "What stopped the bleeding, and how confident were you it
   would work before you did it?"
4. Root cause — "What was the actual root cause — not the symptom?"
5. Postmortem — "What changed afterward — code, process, or both? Did it
   actually stick 6 months later?"

*Interviewer follow-ups to expect:* "Who else was in the room?" "What did
you do that, in hindsight, was wrong?" "What would've caught this sooner?"

## Part 2 — Observability design (0:25–0:50)

6. "Design logging/metrics/tracing for a request that flows through 5
   microservices. How does a correlation ID get generated and propagated?"
7. "What are your actual SLOs for a critical user-facing endpoint, and how
   do you derive the alert thresholds from them rather than picking
   arbitrary numbers?"
8. "Design a runbook for an on-call engineer for a service you own — what's
   actually in it that makes it useful at 3am, versus generic fluff?"
9. "How do you avoid alert fatigue on a team — too many pages, most not
   actionable?"

## Part 3 — Wrap-up (0:50–0:58)

10. "What's a near-miss — something that almost became an incident but
    didn't — that changed how your team operates?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:** the incident story has specific timestamps/durations,
names a real root cause (not "the server was slow"), and includes at least
one honest admission of something done wrong or slower than ideal.
SLO/alerting answer derives thresholds from user-impact data, not
guesswork.

**Weak signals:** a sanitized, blame-free, suspiciously smooth incident
story with no real friction; runbook answer is generic ("check the logs,
restart the service").
