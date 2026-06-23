# Realistic Mock 14 — Coding Filters Bank

**Format:** Live coding, client screen · **Duration:** 75 min
**Use as:** interviewer script or self-practice. Solve each in 15–25 min,
narrating: **brute force → optimized → edge cases → complexity → dry run,
out loud.** This is what "coding filters" (14% of the readiness weight)
actually means in a real screen — not a silent IDE session.

Pick 3–4 of these per run rather than all of them in one sitting.

---

**Ask:** "Implement an LRU cache. Two ways: first with `LinkedHashMap`,
then explain how you'd hand-roll it with a `HashMap` + doubly linked
list."
- *Cross-question:* "Why would you ever hand-roll it instead of just
  using `LinkedHashMap(accessOrder=true)`?" (listen for: interview
  signal / no library dependency / custom eviction hooks)

**Ask:** "Find the first non-repeating character in a string."
- *Cross-question:* "Do it without a `HashMap` — using a frequency
  array instead. Why might that be preferable here?"

**Ask:** "Find the longest substring without repeating characters."
- *Cross-question:* "Name the pattern before you code: is this fixed or
  variable sliding window? What specifically triggers shrinking the
  window?"

**Ask:** "Two sum, then move zeroes to the end in place, then binary
search — pick whichever you're least confident on and do that one
properly."
- *Cross-question (two sum):* "Brute force is O(n²). What's the
  optimized approach and its actual trade-off (extra space for speed)?"
- *Cross-question (binary search):* "Write the overflow-safe midpoint
  calculation. Why does the naive `(low + high) / 2` matter at scale?"

**Ask:** "Validate a binary search tree."
- *Cross-question:* "A solution that only compares each node to its
  immediate parent passes some invalid trees. Why? Fix it."

**Ask:** "Find the Kth largest element in an array."
- *Cross-question:* "Min-heap or max-heap, and of what size? People get
  this backwards under pressure — justify yours."

**Ask:** "Write two threads that print odd and even numbers alternately."
- *Cross-question:* "What's actually coordinating the hand-off between
  the two threads in your solution? Could this deadlock, and why or why
  not?"

**Ask:** "Implement a producer-consumer setup using `BlockingQueue`."
- *Follow-up:* "Why reach for `BlockingQueue` in production instead of
  hand-rolled `wait`/`notify`?"
- *Cross-question:* "What happens to your consumer if the queue is
  unbounded and the producer runs much faster, over a long period?"

**Ask:** "Implement a thread-safe Singleton using double-checked
locking."
- *Cross-question:* "What breaks if you forget `volatile` on the instance
  field specifically?"

**Ask:** "Quick theory check while you catch your breath: `equals()` and
`hashCode()` — what's the contract, and what breaks if you override one
without the other?"

**Ask:** "`ArrayList` vs. `LinkedList`, and `HashSet` vs. `TreeSet` — Big-O
for the operations that actually matter, not all of them."

**Ask:** "Fail-fast vs. fail-safe iterators — what's the actual mechanism
behind each, not just the name?"

---

## Wrap-up

**Ask:** "Across everything just now, which pattern (two pointers,
frequency array, sliding window, heap, fast/slow pointers) did you reach
for fastest, and which took you the longest to recognize?"

**Candidate questions**

---

## Debrief (for self-practice)

**Strong signals:** states the pattern name before writing code, every
time; states complexity unprompted; catches edge cases (empty input,
single element, all-duplicates) before being asked; the LRU and
producer-consumer follow-ups get real architectural reasoning, not just
"it works."

**Weak signals:** writes code silently then explains after; needs the
interviewer to point out the k-largest min/max-heap mix-up instead of
catching it self.
