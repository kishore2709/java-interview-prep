# Pre-Interview Cheat Sheet — Traps & One-Liners

The day-before page, pulled from the Master Bible + Track 1 + Track 2. These
are the distinctions that separate a senior answer from a mid-level one.
Skim this right before any mock in this folder, not during.

## Coding
- Override `equals()` and `hashCode()` together — never one alone.
- Overflow-safe mid: `low + (high - low) / 2`.
- Validate a BST with a min/max range, not just parent comparison;
  inorder of a BST is sorted.
- Top-K → heap of size K, O(n log k); **min-heap for k-largest**,
  max-heap for k-smallest — easy to get backwards under pressure.
- Use a dummy node for any list head-modifying op; null-check before
  `.next`.
- `volatile` = visibility, not atomicity.
- Confirm whether an array is sorted before reaching for two pointers;
  watch integer overflow in sum-based logic.
- Decide fixed vs. variable sliding window up front — the bug is almost
  always in how you shrink the window.
- `toMap` throws on duplicate keys without a merge function; fail-fast
  iterators throw `ConcurrentModificationException`.

## Spring / JPA
- Constructor injection — final, testable, fail-fast.
- `@Transactional` is proxy-based — self-invocation and private methods
  skip it. Default propagation is `REQUIRED`.
- N+1 → fetch join / `@EntityGraph`; batch fetching for several
  collections.
- `@Bean` = explicit/3rd-party config; `@Component` = classpath-scanned.
- Auto-configuration is conditional (`@ConditionalOnClass`,
  `@ConditionalOnMissingBean`...). Externalize config via profiles/env,
  never hardcode.

## Kafka
- Ordering holds only within a partition; the key picks the partition.
- Throughput = sequential IO + zero-copy + batching + page cache.
- Design for at-least-once + idempotent consumers.
- Exactly-once is real *inside* Kafka (idempotent producer +
  transactions); end-to-end across external systems it's effectively
  at-least-once + dedup. Say this distinction explicitly — it's the
  senior signal.
- Broker fails → an in-sync replica is elected leader; `acks=all` avoids
  loss.
- Poison messages → DLQ after bounded retries.

## Microservices
- Downstream failure = timeout + retry(backoff) + breaker + fallback +
  idempotency.
- Boundaries by business capability + data ownership; each service owns
  its data — no shared database.
- Distributed transaction → saga, not 2PC; outbox for reliable publish.
- Saga: choreography (events, decoupled) vs. orchestration (a central
  coordinator, easier to reason about).
- REST for sync, messaging for decoupled/async, gRPC for low-latency
  internal calls.

## SQL / DB
- Window functions (`ROW_NUMBER`/`RANK`/`DENSE_RANK`) for per-group
  ranking.
- Index the `WHERE`/`JOIN` columns; correlated subqueries are slow.
  `HAVING` filters aggregates, `WHERE` filters rows.
- Scale order: **index → tune → replica → cache → partition → shard.**
  Shard last, not first.
- CAP: under a partition you pick consistency or availability.
- Cassandra is query-first — model to the read, not the entity.

## System design
- Sequence every time: requirements → capacity → API → data model →
  components → bottlenecks → trade-offs.
- State assumptions and rough QPS first, or you design the wrong system.
- Make checkout/payment idempotent. Separate the read path
  (catalog/cart) from the write path (order/payment).

## Java 17 / 21
- Virtual threads for IO-bound concurrency; don't pool them; not for
  CPU-bound. They pin the carrier inside `synchronized` or native calls
  — prefer locks.
- Records are shallow-immutable data carriers.
- Sealed types for controlled hierarchies + exhaustive switch.

## Cloud — know which anchor you're answering for
- **WSI = Azure.** AKS, Functions, Service Bus/Event Grid, Cosmos DB,
  Azure SQL.
- **CARB = AWS.** API Gateway, Cognito, S3, CloudWatch.
- Never swap them. If asked a generic AWS question and your real depth
  is Azure (WSI), map the concept across and say so honestly.

## Behavioral
- Speak in the first person ("I"), not "we."
- Lead with a number; have the rejected alternative ready.
- Keep metrics bounded and honest — "roughly X to Y," not a suspiciously
  precise figure you can't defend under a follow-up.

## Production debugging — the Diagnostic Ladder
Reproduce/confirm the symptom → metrics/dashboards first → narrow the
layer (app code, GC, threads, DB, downstream, network) → form a
hypothesis → verify with logs/traces/heap or thread dumps → fix → add a
guardrail (alert, test, runbook) so it can't silently recur. Don't jump to
a fix before walking the ladder out loud — that's what gets graded.
