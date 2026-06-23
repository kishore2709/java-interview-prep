# Realistic Mock 15 — SQL & Database Scaling

**Format:** Client technical interview, whiteboard SQL · **Duration:** 60 min
**Use as:** interviewer script or self-practice. Write real queries by
hand — don't describe them in prose.

---

### SQL by hand (0:00–0:20)

**Ask:** "Write a query to find the second-highest salary in an
`employees` table — without using `LIMIT`/`OFFSET`."
- *Cross-question:* "Now generalize it to the Nth-highest salary using a
  window function. Which one — `ROW_NUMBER`, `RANK`, or `DENSE_RANK` —
  and why does the choice matter if there are salary ties?"

**Ask:** "Write a query for the max salary per department."
- *Cross-question:* "Now get the *employee* earning that max per
  department, not just the number — what changes in your query?"

**Ask:** "What's the actual difference between `WHERE` and `HAVING`, and
where have you been bitten by using the wrong one?"

**Ask:** "A correlated subquery is running slow over a large table. Why,
specifically, and how do you rewrite it?"

### Indexing & tuning (0:20–0:35)

**Ask:** "What columns do you index, and why specifically those?"
- *Cross-question:* "You added an index and a *different* query got
  slower. What just happened?"

**Ask:** "Walk through your general process for tuning a slow query —
what do you check first?"

### Scaling (0:35–0:50)

**Ask:** "Walk through the order you'd actually apply scaling techniques
to a relational database under growing load."
- *Follow-up:* "Why that order — what goes wrong if you reach for
  sharding first?"
- *Cross-question:* "You're now at the caching step and cached data goes
  stale after a write. How do you keep that window small without giving
  up the performance win?"

**Ask:** "RDBMS vs. NoSQL — give me a real decision you made, not the
generic tradeoffs list."
- *Cross-question:* "Cassandra vs. PostgreSQL specifically — what's
  different about how you'd *model the same data* in each?" (listen for:
  Cassandra is query-first — model to the read pattern, not normalized
  entities)

**Ask:** "What does CAP actually constrain you to choose, and when does
that choice actually bite in a real system — not as theory?"

### Wrap-up (0:50–0:58)

**Ask:** "Design the read path for an order-history page that needs to
stay fast at 10 million orders. Walk through indexing, caching, and
whether you'd ever denormalize."

**Candidate questions**

---

## Debrief (for self-practice)

**Strong signals:** Nth-highest-salary answer correctly distinguishes
`RANK` (ties share rank, gaps after) from `DENSE_RANK` (ties share rank,
no gaps) from `ROW_NUMBER` (no ties, arbitrary tiebreak) and picks the
right one for the stated tie behavior; scaling order is stated as index →
tune → replica → cache → partition → shard, with sharding explicitly
called out as last resort; Cassandra-vs-Postgres answer talks about
modeling to the read, not just "Cassandra scales better."

**Weak signals:** reaches for sharding or NoSQL as a first answer to
"how do you scale this" without the cheaper steps first; can't explain
why an added index slowed down a different query (write amplification,
planner picking a worse index, or unnecessary index maintenance overhead).
