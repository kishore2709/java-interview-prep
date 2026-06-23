# Mock 3 — Spring Boot Internals & REST API Design

**Format:** Technical, no coding · **Duration:** 60 min
**Role context:** Lead Fullstack Engineer, 13+ yrs · panel: 1 architect
**KB tiers:** 2 (Spring Core, Spring Boot, MVC & REST)

---

## Interviewer opening (0:00)

> "I'm an architect here — this round is about how you think through API and
> framework design decisions at a lead level, not trivia. I'll often ask
> 'why not X instead' even if your answer was right, just to hear your
> reasoning. Let's go."

Timer: 60 minutes.

## Part 1 — Spring internals (0:00–0:15)

1. "Explain the bean lifecycle from class scan to a fully wired singleton
   ready to serve traffic. Where do `@PostConstruct` and `BeanPostProcessor`
   fit in?"
2. "You have a circular dependency between two `@Service` beans. Spring
   throws at startup. What are your actual options to fix it, ranked by
   how much you'd hate doing each in a real codebase?"
3. "Tell me about a time Spring Boot auto-configuration did something you
   didn't expect. How did you find the cause, and what did you change?"

## Part 2 — REST API design (0:15–0:35)

4. "Design the API contract for a payments service — just the shape: paths,
   verbs, status codes, idempotency. Walk me through it."
5. "Why does idempotency matter for a `POST /payments` call specifically,
   and how would you actually implement an idempotency key — where does it
   get stored and for how long?"
6. "How do you version a public API you've already shipped to external
   clients, without breaking them? Walk through your actual migration
   process, not just 'use /v2'."
7. "Design your error response shape. What's in it, and how do you keep
   error codes consistent across 20 microservices owned by different
   teams?"

## Part 3 — Validation & cross-cutting concerns (0:35–0:50)

8. "Where does input validation belong — controller, service, or domain
   layer — and why? Defend a position, I'll push back."
9. "Tell me about a production bug caused by validation happening in the
   wrong layer, or not at all."
10. "How do you handle cross-cutting concerns like request logging,
    correlation IDs, and auth checks without copy-pasting them into every
    controller? (Listening for AOP / filters / interceptors reasoning.)"

## Part 4 — Lead-level judgment (0:50–0:58)

11. "You're handed a legacy Spring MVC app full of fat controllers with
    business logic inline. You have one quarter and a team of 4. What's
    your actual refactor plan — priorities, not a wishlist?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:**
- Concrete answer to circular dependency question that includes
  `@Lazy`, constructor vs setter injection tradeoffs, and "the real fix is
  usually that the design is wrong" — not just "use `@Lazy`."
- Idempotency key design includes storage choice (Redis with TTL is the
  common right answer) and what happens on a *retry during processing*.
- API versioning answer covers deprecation timelines and client comms, not
  just URL paths.

**Weak signals:**
- Validation answer with no real bug story attached.
- Refactor plan that's a vague wishlist ("we'd modernize it") instead of
  sequenced, risk-ranked steps.

**Self-grade per part.**
