# Realistic Mock 1 — Core Java + Spring Boot Generalist

**Format:** Client technical interview, 1 interviewer · **Duration:** 60 min
**Use as:** interviewer script (read **Ask** verbatim) or self-practice.
**Real anchor:** controller-service-repository separation in checkout
APIs (SRP) and Spring DI on interfaces, not concretes (DIP) — see
[story-bank.md](story-bank.md) for the full concept-to-project table.

This is the standard first technical round most clients run: background,
then Java fundamentals, then Spring Boot, with follow-ups and
cross-questions woven in — not a flat trivia list.

---

### Background (0:00–0:08)

**Ask:** "Walk me through your background and your most recent project —
what was it, and what was your specific role?"
- *Follow-up:* "Of everything you just described, what part did you
  personally build versus review or delegate?"
- *Cross-question (if the answer is all 'we'):* "Pick one specific piece
  of code or design decision that was entirely yours — what was it?"

### Core Java (0:08–0:25)

**Ask:** "What's the difference between concurrency and multithreading, in
your own words?"
- *Cross-question:* "Give me a case where you had concurrency without
  multiple threads at all." (listen for: async/non-blocking I/O on a
  single thread, e.g. an event loop)

**Ask:** "When would you use a `synchronized` block versus a
`ReentrantLock`?"
- *Follow-up:* "Show me a real case from your work where you needed the
  extra capability `ReentrantLock` gives you — `tryLock`, fairness, or
  `Condition`."
- *Cross-question:* "What does `synchronized` give you for free that
  `ReentrantLock` doesn't?" (listen for: automatic release on exception,
  no risk of forgetting `unlock()`)

**Ask:** "Compare `ExecutorService` and `CompletableFuture` — when do you
reach for each?"
- *Cross-question:* "How do you compose three independent async calls and
  combine their results once all three finish? Name the actual method."
  (listen for: `CompletableFuture.allOf` / `thenCombine`)

**Ask:** "What's the difference between `ConcurrentHashMap` and the old
`Hashtable`?"
- *Cross-question:* "If `Hashtable` is just 'the old slow one,' why does
  it still exist instead of being deleted from the JDK?" (listen for:
  backward compatibility, legacy API contract)

**Ask:** "How would you implement a thread-safe Singleton in Java? Show me
two different ways."
- *Cross-question:* "What's wrong with double-checked locking if you
  forget the `volatile` keyword on the instance field?" (listen for:
  partially constructed object visible to another thread)

**Ask:** "How do parallel streams actually improve performance — and when
do they make things worse?"
- *Cross-question:* "You used `parallelStream()` on a list while reading
  from a shared, non-thread-safe collector. What breaks?"

### Spring & Spring Boot (0:25–0:45)

**Ask:** "What are Spring beans, and how do they get instantiated?"
- *Follow-up:* "Walk through the full bean lifecycle — scanning,
  instantiation, dependency injection, `@PostConstruct`, ready for use."

**Ask:** "Constructor injection vs. setter vs. field injection — which do
you use, and why?"
- *Cross-question:* "Give me a real scenario where field injection was
  actually the pragmatic choice despite the style guides saying
  otherwise."

**Ask:** "You have two implementations of the same interface as Spring
beans. How do you control which one gets injected where?"
- *Follow-up:* "Show me the actual annotations — `@Qualifier`,
  `@Primary` — and when you'd pick one over the other."

**Ask:** "How do you handle exceptions globally across all your REST
controllers?"
- *Cross-question:* "What's the difference between `@ExceptionHandler` on
  a controller versus `@ControllerAdvice`? When does each run?"

**Ask:** "How does Spring Boot's auto-configuration actually decide what
to configure for you?"
- *Cross-question:* "You added a dependency and a bean you expected got
  auto-configured away — `@ConditionalOnMissingBean` style behavior. How
  do you debug that?" (listen for: `--debug` flag, auto-configuration
  report)

**Ask:** "What's the difference between `@Component`, `@Service`, and
`@Repository` — functionally, not just by convention?"

### Wrap-up (0:45–0:55)

**Ask:** "Walk through how you'd design a REST endpoint that creates an
order — request shape, validation, response, error handling."
- *Cross-question:* "What happens if the same request gets sent twice
  because the client's network retried it? Does your design double-create
  the order?"

**Candidate questions (0:55–1:00)**

---

## Debrief (for self-practice)

**Strong signals:** specific ownership in the background answer; can name
the actual annotation/method, not just the concept, every time a
follow-up asks "show me"; catches the double-checked-locking `volatile`
gap and the duplicate-request idempotency gap without being told the
answer.

**Weak signals:** every answer stays at definition-level even after a
follow-up asks for a real example; can't distinguish `@ExceptionHandler`
scope from `@ControllerAdvice` scope.
