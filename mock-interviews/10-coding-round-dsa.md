# Mock 10 — Pure Coding Round: DSA Under Time Pressure

**Format:** Live coding, no discussion fluff · **Duration:** 60 min
**KB tiers:** 4, 9 (Coding Interview Patterns, DSA)

---

## Interviewer opening (0:00)

> "Three problems, roughly 18 minutes each. I'll give the next one whether
> or not you finish — partial credit for approach and communication
> matters. Think out loud."

Timer: 60 minutes total, ~18 min/problem, 6 min buffer.

## Problem 1 — Sliding window (0:00–0:18)

> Given a string `s` and an integer `k`, find the length of the longest
> substring with at most `k` distinct characters.
>
> Example: `s = "eceba"`, `k = 2` → answer `3` (`"ece"`).
>
> Constraints: `0 <= s.length <= 10^5`.

Write working code. State time/space complexity unprompted when done.
Follow-up: "Now do it with at most k *repeats* of any character instead of
distinct characters — what changes?"

## Problem 2 — Tree BFS/DFS with a scaling twist (0:18–0:36)

> Given a binary tree, return the maximum width of any level (the width
> being the distance between the leftmost and rightmost non-null nodes at
> that level, counting nulls in between as if the tree were complete).
>
> Follow-up once solved: "This tree has 10M nodes and doesn't fit in memory
> as objects — your BFS needs to stream from disk/a remote store level by
> level. What changes about your approach at a high level?" (verbal, not
> coded)

## Problem 3 — Backtracking with a production-safety twist (0:36–0:54)

> Given a list of available discount codes (strings) and a target discount
> percentage, find all combinations of codes that sum exactly to the
> target (each code used at most once).
>
> Solve it with backtracking first.
>
> Follow-up: "This is now an API endpoint a client calls with arbitrary
> input. What do you add before this logic ships — input bounds,
> timeout, memory guard? Be specific, not 'add validation.'"

## Buffer / wrap-up (0:54–1:00)

If problem 3 isn't finished, explain your remaining approach verbally —
graded partly on communication under incomplete work, which is realistic.

---

## Debrief

**Strong signals:** states complexity without being asked; handles edge
cases (empty string, k=0, single-node tree, empty discount list) proactively
before being asked "what about edge case X"; production-safety follow-up
gets a concrete answer (e.g. cap combination depth, request timeout, reject
absurdly large input lists) not a vague "add validation."

**Weak signals:** silent coding with no narration; needs every edge case
pointed out by the interviewer.
