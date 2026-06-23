# Mock 15 — JVM Performance Tuning & Profiling Exercise

**Format:** Technical + live coding/profiling · **Duration:** 90 min
**KB tiers:** 8 (Performance & Optimization), Track2 week10

---

## Interviewer opening (0:00)

> "Performance round. First half is discussion and real numbers from your
> career, second half is a live exercise where I describe symptoms and you
> tell me exactly what you'd run and look for."

Timer: 90 minutes.

## Part 1 — JVM tuning fundamentals (0:00–0:20)

1. "Pick a real service you tuned. What was the symptom (latency, GC pause,
   throughput ceiling), what did you change, and what was the measured
   result?"
2. "G1GC vs ZGC — when would you actually switch, and what's the real cost
   of that switch (testing burden, tooling maturity)?"
3. "Container memory limit is 2GB. What JVM heap flags do you set, and why
   not just let the JVM auto-detect?"

## Part 2 — Backpressure & reactive (0:20–0:35)

4. "Design backpressure handling for a reactive pipeline (Project Reactor)
   consuming from a fast producer into a slower downstream sink. What
   operator/strategy, and what happens to the dropped/buffered data?"
5. "Reactive vs imperative — for which of your real services was reactive
   the wrong choice, in hindsight?"

## Part 3 — Live profiling exercise (0:35–1:05)

> I'll describe a symptom. For each, tell me: (a) exact tool/command you'd
> run, (b) what specific output you're looking for, (c) your hypothesis
> before you even look.

- "CPU usage is pegged at 100% on one core, app is otherwise idle."
- "Heap usage climbs steadily over 6 hours then OOMs — classic slow leak."
- "P99 latency has a periodic spike every ~60 seconds, P50 is fine."
- "Throughput dropped 40% after a dependency upgrade, no errors in logs."

For at least one of these, actually write the JFR/async-profiler command
or the `jcmd` invocation you'd run — not just the tool name.

## Part 4 — Caching & lazy init (1:05–1:20)

6. "Lazy initialization pattern — when does it backfire under concurrent
   first-access load? How do you fix the thundering-herd version of this?"
7. "String optimization — when have you actually had to care about string
   interning or compact strings in production, versus it being a non-issue?"

## Candidate questions (1:20–1:30)

---

## Debrief

**Strong signals:** real before/after numbers (e.g. "p99 went from 800ms to
120ms after X"); the periodic-60s-spike symptom correctly triggers a GC
pause hypothesis verified with GC logs, not a guess; actual command syntax
for at least one profiling tool.

**Weak signals:** "we'd profile it" with no named tool; heap-limit question
answered without mentioning container-awareness flags or the
historical Java 8 pre-10 container-memory-detection bug class.
