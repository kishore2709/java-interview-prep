# Realistic Mock 17 — Modern Java (17/21) & Concurrency Theory

**Format:** Client technical interview, mostly spoken (light coding) · **Duration:** 60 min
**Use as:** interviewer script or self-practice.

---

### Java 17/21 (0:00–0:20)

**Ask:** "What do records actually solve, and what's the catch with
'shallow immutability' if a record holds a mutable field like a `List`?"

**Ask:** "Sealed classes and pattern matching for switch — what do these
buy you over a regular interface and if/else chain?"
- *Cross-question:* "What does the compiler actually guarantee for you
  with sealed types in an exhaustive switch that a plain interface
  doesn't?"

**Ask:** "Virtual threads vs. platform threads — when do you actually
reach for virtual threads, and when are they the wrong tool?"
- *Follow-up:* "Be honest about adoption — many systems you've worked on
  probably still run Java 8/11/17. Where does that leave virtual threads
  in your real-world experience?"
- *Cross-question:* "What happens to a virtual thread when it hits a
  `synchronized` block or a native call? Why does that matter, and what
  do you do instead?" *(listen for: pinning to the carrier thread —
  prefer `ReentrantLock` over `synchronized` in virtual-thread-heavy
  code)*

**Ask:** "Should you pool virtual threads the way you'd pool platform
threads in an `ExecutorService`? Why or why not?"

**Ask:** "What's structured concurrency trying to solve that plain
`ExecutorService` + `Future` doesn't?"

### Concurrency theory (0:20–0:45)

**Ask:** "`CompletableFuture` vs. `Future` — what can the former do that
the latter fundamentally can't?"

**Ask:** "`synchronized` vs. `ReentrantLock` — beyond 'one is a keyword,'
what concrete capability does `ReentrantLock` give you?"
- *Cross-question:* "What does `synchronized` give you for free that you
  have to remember to do manually with `ReentrantLock`?" *(listen for:
  automatic unlock on exception/exit — forgetting `finally { lock.unlock() }`
  is a classic bug)*

**Ask:** "What's CAS (compare-and-swap), and how does it let
`AtomicInteger` avoid locking entirely?"

**Ask:** "`CountDownLatch` vs. `CyclicBarrier` — what's the structural
difference in how they get reused?"

**Ask:** "What actually causes a deadlock, mechanically? And what's the
difference between deadlock, livelock, and thread starvation — people
often blur these."

**Ask:** "How do you size a `ThreadPoolExecutor` for a CPU-bound workload
vs. an IO-bound one? What's actually different about the math?"

**Ask:** "`volatile` vs. `Atomic*` — where does `volatile` alone stop
being enough?"

### Wrap-up (0:45–0:55)

**Ask:** "Tie this together: design a simple in-memory rate limiter using
only `AtomicLong`/`AtomicInteger` and no external library. Talk through
your approach."
- *Cross-question:* "Where's the race condition if you check-then-update
  two separate atomics instead of one compound operation?"

**Candidate questions**

---

## Debrief (for self-practice)

**Strong signals:** virtual-thread answer is honest about real-world
adoption lag rather than implying every system already uses them;
correctly identifies carrier-thread pinning inside `synchronized`/native
calls as the specific reason to prefer locks in virtual-thread code;
deadlock/livelock/starvation are given three genuinely distinct
definitions, not synonyms.

**Weak signals:** recommends pooling virtual threads (defeats their
purpose); `synchronized`-vs-`ReentrantLock` answer with no mention of the
automatic-release safety `synchronized` provides.
