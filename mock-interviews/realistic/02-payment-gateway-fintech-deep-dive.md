# Realistic Mock 2 — Payment Gateway / Fintech Deep Dive

**Format:** Client technical interview, panel of 2 · **Duration:** 60 min
**Use as:** interviewer script or self-practice.
**Real anchor:** CARB's IMPS/payment switch (ISO8583 flow) and AWS
migration (API Gateway, Cognito) — see
[story-bank.md](story-bank.md). CARB's cloud is **AWS** — don't drift into
Azure specifics here.

---

### Domain & security (0:00–0:15)

**Ask:** "What's your experience with payment-processing systems —
compliance requirements like PCI-DSS, standards like ISO 20022 or
ISO8583, whatever you've actually touched?"
- *Follow-up:* "Walk through the IMPS/payment-switch flow specifically —
  where does ISO8583 fit, and what did your service actually do with
  those messages?"
- *Cross-question (if limited):* "Fine — pick whatever payment or
  sensitive-data system you *have* worked on, and tell me what compliance
  or security constraint shaped the design the most."

**Ask:** "How do you secure a REST API that's moving payment data
specifically — what's different versus a normal internal API?"
- *Follow-up:* "Walk through OAuth/JWT as you've implemented it — what's
  actually in the token, and who validates it, where?"
- *Cross-question:* "Your JWT is stateless. How do you revoke one before
  it expires, say because a card was reported stolen mid-session?"

### Kafka at scale (0:15–0:30)

**Ask:** "How do you handle high-throughput messaging — say 10,000+
transactions per second — using Kafka? What changes in your design versus
a low-volume topic?"
- *Cross-question:* "Where's your actual bottleneck at that volume —
  producer, broker, or consumer? How would you find out for real instead
  of guessing?"

**Ask:** "What's the role of partitions in a Kafka consumer group?"
- *Cross-question:* "You have more consumer instances than partitions on
  this topic. What happens to the extra consumers?"

**Ask:** "How do you implement idempotency in a Kafka producer? Give me a
concrete scenario where, without it, a customer gets double-charged."
- *Follow-up:* "Now the consumer side — if the same message somehow gets
  delivered twice anyway, how does your downstream logic avoid
  double-processing it?"

**Ask:** "Kafka Streams vs. the plain producer/consumer API — when do you
reach for Streams specifically?"

### Resilience (0:30–0:45)

**Ask:** "Walk me through a real production incident: a consumer
application running slow, producer queue backing up. What did you
actually do, step by step?"
- *Cross-question:* "How did you know it was the consumer and not, say,
  network or broker-side issues, before you started fixing anything?"

**Ask:** "What's the circuit breaker pattern, and where have you actually
wired one in — the real call site, not the textbook definition?"
- *Follow-up:* "What's the fallback when the downstream payment processor
  trips the breaker — what does the system do instead of just failing the
  request?"
- *Cross-question:* "Fallback behavior for a *payment* call is trickier
  than for a read — you can't just return cached or default data. What do
  you actually do?"

### Service boundaries (0:45–0:55)

**Ask:** "How do you decide service boundaries breaking apart a payment
system? Where's one service, where's another, and why there specifically?"
- *Cross-question:* "Authorization and settlement happen at different
  times and have different consistency needs — same service or different
  ones? Defend it."

**Candidate questions (0:55–1:00)**

---

## Debrief (for self-practice)

**Strong signals:** JWT revocation answer reaches for a real mechanism
(short-lived access token + revocable refresh, or a denylist) instead of
"you can't, that's the tradeoff"; idempotency answer names the actual
mechanism (idempotency key, dedup store, Kafka's idempotent producer
config) tied to the double-charge scenario; payment-specific fallback
answer doesn't just reuse the generic "return cached data" pattern.

**Weak signals:** circuit breaker and fallback treated as the same
answer restated twice; no real incident-diagnosis sequence, just "we
looked at the logs and fixed it."
