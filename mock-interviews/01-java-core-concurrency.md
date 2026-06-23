# Mock 1 — Java Core: Memory & Concurrency

**Format:** Technical, no coding (whiteboard/verbal only) · **Duration:** 60 min
**Role context:** Lead Fullstack Engineer, 13+ yrs · panel: 1 staff engineer
**KB tiers:** 1 (Memory Model, Concurrency)

---

## Interviewer opening (0:00)

> "Thanks for joining. I'm a staff engineer on the platform team. This round
> is going to be a conversation about JVM internals and concurrency — no
> coding, just whiteboard and talking through your reasoning. I'll push back
> and ask follow-ups, that's normal, don't read it as you got something
> wrong. Sound good? Let's start easy and go deeper."

Set a 60-minute timer now. Answer out loud or typed, in full sentences, as if
graded on clarity — not just correctness.

## Part 1 — Warm-up (0:00–0:10)

1. "Walk me through what happens in JVM memory when you call `new Order()` —
   from bytecode to object on the heap."
2. "Where do local variables live vs. object fields? Why does that matter for
   GC?"

*Follow-up if answer is shallow:* "What's the difference between Metaspace
and the old PermGen, and why did that change?"

## Part 2 — Garbage collection (0:10–0:25)

3. "Pick a GC algorithm you've actually tuned in production — G1, ZGC,
   Shenandoah, whatever. Tell me what problem you were solving and what
   flags you changed."
4. "Your service has unpredictable GC pauses under load. Walk me through
   your diagnostic process — tools first, then what you'd look for."
5. "What's a memory leak in Java, given we have a garbage collector? Give me
   a real example you've fixed — not the textbook listener-not-unregistered
   answer, an example from your own work."

## Part 3 — Concurrency core (0:25–0:50)

6. "Explain happens-before. Why does `volatile` alone not make a counter
   increment thread-safe?"
7. "When would you choose `ReentrantLock` over `synchronized`, concretely?
   Give me a case where the extra API surface (tryLock, fairness,
   conditions) actually earned its complexity."
8. "Tell me about a deadlock you've debugged in production. How did you
   find it, and what was the actual fix — not 'we added a timeout.'"
9. "Design a thread-safe bounded cache, verbally — no code. Walk me through
   your locking strategy and why you didn't just slap `synchronized` on
   every method."
10. "What's the difference between livelock and starvation? Have you seen
    either for real, or only in theory?"

## Part 4 — Synthesis (0:50–0:58)

11. "If I gave you a service doing 10k req/sec with intermittent latency
    spikes, walk me through your first 30 minutes of investigation —
    concurrency-specific angle only."

## Candidate questions (0:58–1:00)

Ask the interviewer 1–2 real questions (team's actual JVM version, biggest
recent prod concurrency incident, etc.) — not generic ones.

---

## Debrief — grade yourself honestly

**Strong answer signals (what a staff engineer is listening for):**
- Concrete tool names (JFR, async-profiler, `jcmd`, heap dumps via
  Eclipse MAT) tied to a real story, not just terminology.
- You distinguish "I know the definition" from "I've fixed this in prod" —
  interviewers at this level notice the difference immediately.
- You self-correct or add nuance unprompted (e.g. "well, it depends on GC
  pause goals vs throughput goals").

**Weak answer signals:**
- Reciting happens-before/volatile definitions without a concurrency bug
  story attached.
- No specific GC flags or tool names — only "we profiled it and fixed it."
- Treating deadlock/livelock/starvation as interchangeable.

**Self-grade:** #shaky / #review / #solid on each of Parts 2, 3, 4
separately — concurrency and GC are graded as different skills, don't
average them into one tag.
