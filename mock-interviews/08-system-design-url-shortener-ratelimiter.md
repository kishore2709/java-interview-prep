# Mock 8 — System Design: URL Shortener + Rate Limiter

**Format:** Whiteboard system design · **Duration:** 60 min
**KB tiers:** 4, 9 (System Design)

---

## Interviewer opening (0:00)

> "Two smaller system design problems, 25-30 min each. I want requirements
> clarification first, then a design, then I'll throw scale/failure
> curveballs at you."

Timer: 60 minutes. Actually draw boxes/arrows (paper, whiteboard app, or
ASCII) — don't just describe verbally.

## Problem 1 — URL Shortener (0:00–0:28)

**Prompt:** "Design a URL shortener like bit.ly."

Clarify with the interviewer (answer these yourself first, then proceed):
- Read:write ratio? (assume 100:1)
- Custom aliases needed? (assume yes, optional)
- Expected scale? (assume 100M URLs created, 10B redirects/month)

Then design:
1. API shape (`POST /shorten`, `GET /{code}`)
2. Short code generation — base62 counter vs hash vs random — pick one,
   defend collision handling
3. Datastore choice and schema
4. Caching layer for hot redirects
5. Capacity estimate: storage for 100M URLs, QPS for redirects

**Curveballs the interviewer throws:**
- "Your base62 counter is a single point of contention at 10k writes/sec.
  Fix it."
- "A URL goes viral — 500k redirects/sec for one code. What breaks, and
  what's your fix?"
- "Product wants analytics (click count) per link without slowing down the
  redirect path. Design that."

## Problem 2 — Rate Limiter (0:28–0:55)

**Prompt:** "Design a rate limiter for an API gateway sitting in front of
50 microservices, limiting per-API-key."

1. Algorithm choice: token bucket, leaky bucket, fixed window, sliding
   window log, sliding window counter — pick one and defend against the
   others' weaknesses.
2. Where does state live — in-memory per-instance, or shared (Redis)? What
   breaks with each at scale across 20 gateway instances?
3. Whiteboard the Redis-based implementation: what commands, what
   atomicity guarantee do you need (Lua script / `MULTI`?), what's the
   race condition if you get this wrong?

**Curveballs:**
- "Redis becomes a bottleneck/SPOF for rate limiting at this scale. What's
  your fallback design?"
- "Different rate limits for different subscription tiers, changeable at
  runtime without a redeploy. How?"

## Wrap-up (0:55–1:00)

"Of these two designs, which has the failure mode you're least comfortable
with, and why?" — answer honestly, this is testing self-awareness.

---

## Debrief

**Strong signals:** explicit capacity math (not hand-waved), names the race
condition in naive Redis rate-limiting (check-then-increment without
atomicity) and fixes it with a Lua script or `INCR`+`EXPIRE` atomic pattern.

**Weak signals:** jumps to "use a database" or "use Redis" without
justifying against the stated scale; no answer for the SPOF/fallback
curveball.
