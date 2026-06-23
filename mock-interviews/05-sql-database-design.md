# Mock 5 — SQL, Indexing & Schema Evolution

**Format:** Technical + whiteboard SQL · **Duration:** 90 min
**Role context:** Lead Fullstack Engineer, 13+ yrs · panel: 1 DBA-leaning
backend lead
**KB tiers:** 7 (SQL Databases: Postgres/MySQL), 13 (Migrations)

---

## Interviewer opening (0:00)

> "This is a data-heavy round. Some whiteboard SQL, mostly discussion about
> decisions you've made on real systems with real data volume — I'll ask
> for numbers (row counts, latency) wherever I can, vague answers will get
> follow-up pressure."

Timer: 90 minutes.

## Part 1 — Indexing (0:00–0:20)

1. "Table has 500M rows, mixed read/write, queries filter on
   `(customer_id, created_at)`. Design your indexing strategy and explain
   the tradeoff on write throughput."
2. "What's the difference between a composite index and two separate
   single-column indexes, in terms of what the query planner can actually
   use?"
3. "Whiteboard: write a query that would benefit from a covering index, then
   tell me what that index looks like."
4. "Tell me about a time an index made things *worse* — what happened and
   how did you catch it?"

## Part 2 — N+1 and ORM pitfalls (0:20–0:35)

5. "You're handling a Spring Data JPA service where a list endpoint takes
   8 seconds and the DB isn't under load. Walk through your diagnosis."
6. "Fix the N+1 — give me the actual JPA-level fix (fetch joins, entity
   graphs, batch fetching) and explain when each is the right tool."

## Part 3 — Transactions & isolation (0:35–0:50)

7. "Explain Read Committed vs Repeatable Read vs Serializable with a
   concrete bug example for each — not the textbook definition, a story."
8. "You see a phantom-read-caused bug in production. How do you confirm
   that's actually what happened, and what's your fix — isolation level
   change, optimistic locking, or something else? Defend the choice."
9. "Long-running transaction holding a lock and blocking writes across the
   table — how do you find it live in production, and how do you prevent
   recurrence?"

## Part 4 — Schema evolution (0:50–1:05)

10. "Add a `NOT NULL` column with a default to a table with 200M rows, zero
    downtime. Walk through your actual migration steps."
11. "Liquibase vs Flyway — pick one and defend it for a team of 25 engineers
    across 10 services sharing migration conventions."
12. "Backward-incompatible schema change (e.g. splitting a column) while
    the old code is still deployed in some pods during a rolling
    deploy — how do you sequence it?"

## Part 5 — Engine-specific judgment (1:05–1:20)

13. "Postgres vs MySQL — pick a real project you used each on and tell me
    the actual deciding factor, not generic pros/cons."
14. "Replication lag just caused a read-your-own-write bug for a user.
    What's your fix — and is it a code fix or an infra fix?"

## Candidate questions (1:20–1:30)

---

## Debrief

**Strong signals:**
- You give actual numbers when asked (row counts, query times) instead of
  staying abstract.
- Zero-downtime migration plan has explicit phases (add nullable column →
  backfill → add constraint → deploy code that requires it → cleanup), not
  "we just add the column."
- You distinguish "the index made writes slower" as a real tradeoff you've
  hit, not a theoretical caveat.

**Weak signals:**
- Picks an isolation level without being able to describe the specific bug
  it prevents.
- No specific batching/fetch-join answer for N+1 — just "we added caching."

**Self-grade per part.**
