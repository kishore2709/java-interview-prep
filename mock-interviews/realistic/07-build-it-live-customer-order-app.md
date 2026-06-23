# Realistic Mock 7 — Build It Live: Customer/Order/Product Spring Boot App

**Format:** Client technical interview, live build/screen-share · **Duration:** 75 min
**Use as:** interviewer script or self-practice. Actually write the
code/structure — don't just describe it in prose.

---

### Warm-up (0:00–0:05)

**Ask:** "Have you worked on a Spring Boot application recently? What was
it, briefly?"

**Ask:** "Do you combine Angular or React with Spring Boot in the same
project? How's that typically deployed — same origin, separate hosting?"

### Live build (0:05–0:30)

**Ask:** "Let's build something. Design a Spring Boot app with `Customer`,
`Order`, and `Product` — walk me through your entities, relationships, and
package structure, live."
- *Follow-up:* "What dependencies go in your build file, and why each
  one?"
- *Cross-question:* "Your `Order` references both `Customer` and a list of
  `Product` line items. Where does the price-at-time-of-order live — do
  you snapshot it, or always read the live `Product` price? What breaks
  if you pick wrong?"

**Ask:** "Write the controller and annotations to expose this as a REST
API."
- *Cross-question:* "Did you use OpenAPI/Swagger here? Show me how you'd
  document one endpoint properly, not just slap `@Operation` on it with no
  detail."

### Deployment (0:30–0:40)

**Ask:** "How would you deploy this on-prem using JBoss instead of the
embedded server?"
- *Follow-up:* "Is there a way to run a Spring Boot app without deploying
  to JBoss or Tomcat at all? What's the actual mechanical difference?"
- *Cross-question:* "What in your build configuration has to change to go
  from 'runs standalone' to 'deployable as a WAR on JBoss'?"

### Concurrency (0:40–0:55)

**Ask:** "Two customer service reps pull up the same order and both try
to update it at the same time. Show me — actually implement — how you
prevent one from silently overwriting the other's change."
- *Follow-up:* "What does the losing request actually get back? What does
  the UI do with that?"
- *Cross-question:* "Your lock/version check works for two reps on the
  same app instance. Does it still hold across two separate instances
  behind a load balancer? Why?"

### Data access & performance (0:55–1:10)

**Ask:** "What's the real difference between raw JDBC and Spring Data JPA
for this app's data layer?"

**Ask:** "Rate your SQL comfort, then prove it: write a query to get the
count of usernames per city."

**Ask:** "The 'review order' method has gotten slow in production. Walk
through your actual diagnostic steps before you touch any code."
- *Cross-question:* "You found it's an N+1 query loading line items.
  Show me the actual JPA-level fix — not 'add caching.'"

**Ask:** "How would you efficiently retrieve just the most recent 10
orders for a customer?"

**Ask:** "Now the table has 10 million orders and someone wants to page
through all of them. How do you handle that efficiently?"
- *Cross-question:* "Why is `OFFSET 500000 LIMIT 10` a bad idea at this
  scale, specifically? What do you replace it with?"

**Candidate questions (1:10–1:15)**

---

## Debrief (for self-practice)

**Strong signals:** concurrent-update fix is actually implemented
(`@Version` field for optimistic locking is the expected shape), and the
multi-instance follow-up gets a real answer, not just "the database
handles it" without explaining how; N+1 fix is a specific JPA mechanism
(fetch join, entity graph, batch fetching), not "we added Redis."

**Weak signals:** describes optimistic locking verbally but never writes
the `@Version` field or explains the conflict response; pagination answer
stays at `LIMIT`/`OFFSET` with no cursor/keyset alternative even after the
10-million-row cross-question.
