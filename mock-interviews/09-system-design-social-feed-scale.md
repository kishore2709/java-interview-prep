# Mock 9 — System Design: Social Feed at 100M-User Scale

**Format:** Whiteboard system design · **Duration:** 90 min
**KB tiers:** 4, 9 (System Design Interview Prep)

---

## Interviewer opening (0:00)

> "One big design problem this round, deliberately open-ended. I want to see
> how you scope it, not just whether you know fan-out-on-write. Treat me as
> a skeptical staff engineer who will poke every assumption."

Timer: 90 minutes.

## Prompt (0:00–0:05)

"Design the backend for a social media feed — think Twitter/X home
timeline — for 100M daily active users."

Spend the first 5 minutes clarifying requirements out loud:
- Post rate? Read rate? (assume 5M posts/day, 100x more reads)
- Celebrity accounts with 50M followers — in scope? (yes, this is the hard
  part)
- Real-time delivery required, or eventual consistency acceptable?
- Media (images/video) — in scope or just text/links?

## Part 1 — High-level architecture (0:05–0:25)

1. Sketch the major components: write path, read path, storage, cache.
2. Fan-out-on-write vs fan-out-on-read — explain both, then pick a hybrid
   and defend exactly where the line is (the celebrity problem).
3. Data model: how do you store a user's timeline? (precomputed list of
   post IDs vs query-time join)

## Part 2 — The celebrity problem (0:25–0:45)

4. "A user with 50M followers posts. Walk through exactly what happens,
   step by step, and where your design would fall over with naive
   fan-out."
5. "Design your hybrid approach: which users get fan-out-on-write, which get
   fan-out-on-read, and how do you decide the threshold dynamically?"

## Part 3 — Storage & caching (0:45–1:05)

6. "What datastore for the timeline itself — and why not just Postgres?"
7. "Design your caching layer for the read path. What's cached, what's the
   eviction policy, and how do you keep cache and DB from diverging?"
8. "How do you handle a user who has been offline for 3 months and just
   opened the app — their timeline needs computing on demand. Design that
   path."

## Part 4 — Failure modes & curveballs (1:05–1:20)

9. "Your fan-out worker queue backs up by 2 hours during a traffic spike.
   What's the user-visible impact, and what's your mitigation?"
10. "How would you add 'show me posts I might have missed' (ranking, not
    pure reverse-chronological) without redesigning the whole pipeline?"
11. "Multi-region: a user in Singapore follows someone in the US. Where does
    fan-out happen, and what's your cross-region latency budget?"

## Wrap-up (1:20–1:30)

"If you had to cut scope to ship an MVP in 6 weeks with 4 engineers, what's
the first thing you'd cut, and what do you explicitly tell stakeholders
you're deferring?"

---

## Debrief

**Strong signals:** the hybrid fan-out threshold is a concrete, defensible
number (e.g. follower count threshold with a documented reasoning, not just
"some users get treated differently"); failure-mode answers acknowledge
user-visible degradation explicitly instead of assuming infinite scale.

**Weak signals:** treats fan-out-on-write as universally correct without
addressing the celebrity case unprompted; no mention of monitoring/queue
depth as the signal that triggers the degraded mode.
