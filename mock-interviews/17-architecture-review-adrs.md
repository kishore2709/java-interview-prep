# Mock 17 — Architecture Review: ADRs & Migration Planning

**Format:** Whiteboard + document critique · **Duration:** 90 min
**KB tiers:** 9, Track2 week12-arch-review

---

## Interviewer opening (0:00)

> "This is an architecture-review-board style round. I'll hand you a
> (hypothetical) proposal and you critique it like you would in a real ADR
> review, then we'll design a migration plan together."

Timer: 90 minutes.

## Part 1 — Critique an ADR (0:00–0:25)

> **Proposal handed to you:** "We propose migrating our monolith's order
> module to a separate microservice, communicating via synchronous REST
> calls to the monolith for inventory checks, deployed independently,
> target: 6 weeks."

Critique it as if in a real review:
1. "What's missing from this ADR before it should be approved?"
2. "What's the biggest risk in '6 weeks' as a timeline, given what's
   described?"
3. "Synchronous REST back to the monolith for inventory — what failure
   mode does this introduce that didn't exist before?"
4. "Write (verbally) the 'Consequences' section this ADR is missing —
   what do you give up by making this change?"

## Part 2 — Trade-off framing (0:25–0:45)

5. "Give me three architecture decisions you've actually documented as
   ADRs in your career. Pick the one you'd defend hardest today, and the
   one you'd reverse if you could."
6. "How do you handle an architecture decision where two senior engineers
   on your team disagree and both have valid points? Walk me through your
   actual process, not 'I'd make the final call.'"

## Part 3 — Migration planning (0:45–1:10)

> "Now design the actual migration plan for the order-module extraction
> above, properly — phased, with rollback points."

7. Sequence the migration: strangler fig vs big-bang — defend your choice.
8. "What's your feature-flag or dual-write strategy during the transition
   period, and how do you verify the new service is correct before fully
   cutting over?"
9. "How do you handle data ownership during the transition — who's the
   source of truth for order data while both systems are partially live?"

## Part 4 — Governance at scale (1:10–1:25)

10. "You're now responsible for architecture consistency across 8 teams
    each making their own service decisions. What's your actual governance
    model — mandatory review board, guardrails-as-code, advisory only?
    Defend it against the obvious failure mode of each option."

## Candidate questions (1:25–1:30)

---

## Debrief

**Strong signals:** the ADR critique identifies the *specific* missing
risk (sync coupling to the monolith means the new "independent" service
isn't actually independently deployable/available) rather than generic
"needs more detail." Migration plan includes a concrete verification step
before cutover (shadow traffic, comparison logging) not just "we'll test
it."

**Weak signals:** governance answer picks one extreme (heavy gate-keeping
or zero process) without acknowledging the failure mode of that extreme.
