# Realistic Mock 3 — Parking System Design + Fullstack

**Format:** Client technical interview, live system design · **Duration:** 75 min
**Use as:** interviewer script or self-practice. Actually sketch the
design (paper/whiteboard app) — don't just talk through it.

---

### System design (0:00–0:30)

**Ask:** "Design a REST API to retrieve a list of parking garages near a
specific location."
- *Follow-up:* "What does 'near' mean in your query — radius search,
  bounding box? How does that translate to an actual index or query?"
- *Cross-question:* "Your nearest-garage query is now slow at 5 million
  garages worldwide. What do you change?"

**Ask:** "Now design the API to get available parking spots for a
specific garage someone selects."
- *Cross-question:* "Spot availability changes every few seconds as
  people park and leave. Is this endpoint hitting the database live every
  time, or is something cached? If cached, how stale can it be before
  it's a real problem?"

**Ask:** "How would you implement a reservation system mapping users to
specific parking spots? Walk through the flow from 'user taps reserve' to
'spot is held.'"

**Ask:** "Sketch the entities and relationships for this whole system."
- *Cross-question:* "Where, structurally, does your model prevent two
  people from holding the same spot — is it enforced by the schema, or
  just by application logic? What's the difference in practice?"

**Ask:** "Two users tap 'reserve' on the same spot within the same
second. Walk me through exactly what happens in your system, end to end,
so only one of them gets it."
- *Follow-up:* "What does the losing user actually see, and how fast?"
- *Cross-question:* "Your lock/constraint approach now needs to work
  across multiple application instances behind a load balancer, not just
  one process. Does your design still hold? Why or why not?"

### Frontend (0:30–0:55)

**Ask:** "What are closures in JavaScript, and how do they affect variable
scope? Give me a real example from something you've actually built."

**Ask:** "How do promises work — what are `resolve` and `reject` doing
under the hood? How does `async`/`await` change how you write that code
versus raw `.then()` chains?"

**Ask:** "You'd build the garage-search and reservation screens in Angular
or React. What's the real difference between one-way and two-way data
binding between the two, as you've used them?"

**Ask:** "How do you manage state in React so the spot count updates in
real time as other users reserve, without the user refreshing the page?"
- *Follow-up:* "Is that polling, WebSocket, or server-sent events here?
  Defend the choice for this specific use case."
- *Cross-question:* "500 users are viewing the same garage page right now.
  Does your real-time approach scale to that, or does it fall over? What
  changes if it does?"

**Ask:** "What testing libraries have you used for Angular or React
components, and how do `jest.mock`/`jest.fn` help you test something like
the reservation API call in isolation?"

### Backend DI (0:55–1:10)

**Ask:** "What are Spring beans and how are they instantiated?"

**Ask:** "If you have two implementations of the same interface — say two
different `PricingStrategy` beans for different garage tiers — how do you
control which one Spring injects where?"
- *Cross-question:* "Now the pricing strategy needs to be selected at
  *runtime* based on the garage's tier, not wired at startup. How does
  that change your design?"

**Candidate questions (1:10–1:15)**

---

## Debrief (for self-practice)

**Strong signals:** the double-reservation answer names a real mechanism
(DB unique constraint, optimistic/pessimistic lock, short-lived hold with
TTL) and explicitly addresses the multi-instance follow-up — a
single-process lock that silently breaks under horizontal scaling is the
most common trap here; React real-time answer is tied to the actual
500-concurrent-viewer scale-up question, not left at "we'd use
WebSockets" with no fan-out plan.

**Weak signals:** entity sketch has no structural mechanism preventing
double-booking; runtime-strategy-selection follow-up gets no real answer
beyond "we'd add an if-statement."
