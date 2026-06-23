# Mock 6 — NoSQL, Caching Strategy & Live Coding

**Format:** Technical + live coding · **Duration:** 90 min
**KB tiers:** 11 (MongoDB, Redis)

---

## Interviewer opening (0:00)

> "We'll talk caching and NoSQL decisions for about 40 minutes, then one
> coding exercise around cache invalidation. Talk through your reasoning as
> you go."

Timer: 90 minutes.

## Part 1 — Document modeling (0:00–0:15)

1. "You're moving an order-history feature from Postgres to MongoDB. Design
   the document shape — embed line items or reference them? Defend it."
2. "When does a denormalized MongoDB document become a liability? Give me a
   real example of a document that grew unbounded."
3. "Query patterns drive MongoDB schema, not the other way around — agree
   or disagree, with an example."

## Part 2 — Redis & caching strategy (0:15–0:35)

4. "Cache-aside vs write-through vs write-behind — pick one for a product
   catalog with high read, low write, and defend it."
5. "Design cache invalidation for a price that updates in the DB — what's
   your TTL strategy, and how do you avoid serving stale prices on a
   flash sale?"
6. "Cache stampede: 10,000 requests hit a cold cache key simultaneously
   after expiry. What's your mitigation?"
7. "Redis as a session store vs a dedicated session DB — tradeoffs, and
   when would you NOT use Redis for sessions?"

## Part 3 — Live coding (0:35–1:10)

**Problem: "Cache-aside layer with stampede protection"**

> Implement a `CacheAsideService<K, V>` with:
> - `get(K key, Supplier<V> loader)` — checks cache, loads on miss, caches
>   result with a TTL.
> - Stampede protection: if two threads miss on the same key
>   simultaneously, only one should call `loader`, the other should wait
>   for and reuse that result.
> - Use any in-memory structure to simulate "Redis" — I'm not testing Redis
>   client API knowledge, I'm testing your concurrency-safe design.
>
> Follow-up once it works: "Now add negative caching — loader returning
> null/empty shouldn't be retried on every single request."

## Part 4 — Wrap-up (1:10–1:20)

8. "Tell me about a real cache-related production incident — stale data,
   stampede, or eviction storm. What was the fix?"

## Candidate questions (1:20–1:30)

---

## Debrief

**Strong signals:** stampede solution uses a lock/future-per-key (e.g.
`ConcurrentHashMap<K, CompletableFuture<V>>` computeIfAbsent pattern) rather
than a single global lock that serializes all keys.

**Weak signals:** "we'd just add a cache" with no invalidation or stampede
strategy; conflating cache-aside and write-through without being able to
explain the consistency difference.
