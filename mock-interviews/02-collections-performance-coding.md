# Mock 2 — Collections Internals, Performance & Live Coding

**Format:** Technical + live coding · **Duration:** 90 min
**Role context:** Lead Fullstack Engineer, 13+ yrs · panel: 1 senior engineer
**KB tiers:** 1 (Collections Framework), 8 (Performance & Optimization)

---

## Interviewer opening (0:00)

> "This round is half discussion, half hands-on. We'll talk through
> collections internals and performance for about 30 minutes, then I'll
> give you two coding problems — you can use any IDE/editor, just talk
> through your thinking as you go. I care more about your reasoning than a
> perfect solution on the first try."

Timer: 90 minutes. For the coding parts, actually write runnable Java —
don't just describe it.

## Part 1 — Collections internals (0:00–0:15)

1. "Walk me through what happens internally when you call `map.put()` on a
   `HashMap` that's about to resize."
2. "Java 8 changed HashMap's collision handling — what changed and why?"
3. "When would `LinkedHashMap` actually be the right choice over `HashMap`
   in a production system you've built?"
4. "`TreeMap` vs `HashMap` vs `LinkedHashMap` — give me the Big-O for get/put
   on each, then tell me about a real bug caused by picking the wrong one."

## Part 2 — Performance discussion (0:15–0:30)

5. "You inherited a service where a `for` loop over a `List<Order>` calling
   `list.contains()` inside it is the hot path. What's wrong, and what do
   you change it to?"
6. "When have you actually used `ArrayDeque` over `LinkedList`, and why does
   that matter for cache locality?"
7. "Tell me about a time you used JMH (or another benchmarking tool) to
   settle a real disagreement on a team about performance. What was the
   disagreement and what did the data show?"

## Part 3 — Live coding problem 1 (0:30–0:55)

**Problem: "Top K Frequent Elements with a twist"**

> Given a stream of `Order` objects arriving continuously (assume a method
> `getNextOrder()` you can call in a loop), maintain the top 5 customers by
> total order value at any point in time, queryable in O(log n) or better.
>
> - Don't worry about thread-safety for this version — single-threaded is
>   fine.
> - I want to see your data structure choice reasoning out loud before you
>   write code.
> - Follow-up once it works: "Now make `getTop5()` callable from multiple
>   threads concurrently while orders keep arriving. What do you change?"

Write it. Test it mentally against: empty stream, all same customer,
exactly 5 customers, ties in value.

## Part 4 — Live coding problem 2 (0:55–1:15)

**Problem: "Defensive copy bug hunt"**

> I'll hand you (mentally, or written below) a class:
> ```java
> public class OrderBatch {
>     private final List<Order> orders;
>     public OrderBatch(List<Order> orders) { this.orders = orders; }
>     public List<Order> getOrders() { return orders; }
> }
> ```
> Find every way this breaks immutability/encapsulation, then fix it. Then:
> "Now make `Order` itself properly immutable — what does that class need to
> guarantee, and what's the catch with collections *inside* an immutable
> object (e.g. a `List<LineItem>` field)?"

## Part 5 — Wrap-up (1:15–1:25)

8. "If you had to explain to a junior engineer why `Collections.unmodifiableList`
   isn't the same as a truly immutable list, what would you say?"

## Candidate questions (1:25–1:30)

---

## Debrief

**Strong signals:**
- You name the actual complexity class (O(1) amortized, O(log n)) without
  being asked, and justify the data structure choice (e.g. min-heap of size
  5, or a `TreeMap<Double, Customer>`) before coding.
- For the concurrency follow-up, you reach for `ConcurrentHashMap` +
  `PriorityBlockingQueue` or similar rather than "I'd add `synchronized`
  everywhere."
- In the bug hunt, you catch the *aliasing* problem (constructor stores the
  reference directly) without prompting, and separately catch the "shallow
  immutability" trap for `Order`'s internal list.

**Weak signals:**
- Reaching for `ArrayList` + linear scan for top-K without naming the
  Big-O cost out loud.
- Missing that `unmodifiableList` is a *view* — the backing list can still
  mutate.

**Self-grade:** tag Part 1–2 (theory) and Part 3–4 (coding) separately.
