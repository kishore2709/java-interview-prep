# Mock 12 — Testing Strategy & Quality Gates

**Format:** Technical, no coding · **Duration:** 60 min
**KB tiers:** 3 (Spring Testing), 6 (Testing & Quality), Track2 week07

---

## Interviewer opening (0:00)

> "Testing strategy round — I want your actual policy as a lead, the kind of
> thing you'd write into a team's engineering standards doc."

Timer: 60 minutes.

## Part 1 — Test pyramid (0:00–0:15)

1. "Draw your test pyramid for a typical microservice you've owned. Real
   ratios, not textbook 70/20/10 — what did it actually look like, and
   why?"
2. "Where does TestContainers fit, and what's the cost (time, flakiness)
   you accept for that realism?"
3. "Contract testing (e.g. Pact) — have you actually used it, or is it
   theoretical for you? Be honest, I'll ask a follow-up either way."

## Part 2 — Flaky tests (0:15–0:30)

4. "A test is flaky in CI — passes locally, fails 1 in 20 runs in the
   pipeline. Walk through your actual debugging process."
5. "What's your team policy on flaky tests — quarantine, delete, or fix
   before merge? Defend it against the obvious counterargument."

## Part 3 — Mocking judgment (0:30–0:40)

6. "When do you mock vs use a real dependency (real DB via TestContainers,
   real HTTP call to a test double)? Give me the line you draw and why."
7. "Tell me about a time mocking hid a real bug that only showed up in
   production. What changed in your testing approach after?"

## Part 4 — Quality gates as a lead (0:40–0:55)

8. "Design your CI quality gate: coverage threshold, mutation testing,
   static analysis — what's mandatory to merge, and what's advisory only?
   Defend the line."
9. "A senior engineer pushes back hard on a coverage gate slowing down
   their delivery. How do you handle that conversation?"
10. "How do you avoid coverage becoming a vanity metric (100% coverage,
    zero meaningful assertions)?"

## Part 5 — Wrap-up (0:55–0:58)

11. "If you joined a team with zero tests and a production incident last
    week because of it, what's your first 30-day testing plan?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:** real test pyramid ratios from an actual project,
acknowledged tradeoffs (e.g. "we leaned heavier on integration tests
because the domain was mostly DB-shaped logic, not pure business rules");
concrete mutation-testing or coverage-quality answer beyond "we use
JaCoCo."

**Weak signals:** recites the textbook pyramid with no real numbers; no
position on the flaky-test policy beyond "we'd look into it."
