# Realistic Mock 8 — Production Support + Java Internals

**Format:** Client technical interview, mixed troubleshooting + internals · **Duration:** 60 min
**Use as:** interviewer script or self-practice. Two small live-coding
moments are embedded — write real code for those, not pseudocode.

---

### Performance & measurement (0:00–0:12)

**Ask:** "Tell me about a real performance improvement you made — what
was slow, what did you change, and how did you actually measure the
before/after?"
- *Cross-question:* "What metric specifically did you capture, and over
  what time window? A single before/after number isn't enough — how did
  you rule out noise?"

**Ask:** "What's your general process for Java performance optimization,
start to finish?"

**Ask:** "How do you handle a deadlock you find in production — walk
through detection and the actual fix, not just 'we added a timeout.'"

### JVM internals (0:12–0:28)

**Ask:** "What are the different types of classloaders in Java?"
- *Follow-up:* "Write a simple custom classloader and explain what it
  does." (real code — at minimum, override `findClass`, load bytes, call
  `defineClass`)
- *Cross-question:* "Why would you ever need a custom classloader in a
  real system — give me an actual use case, not just 'plugins.'"

**Ask:** "Explain Java memory management — what parts of memory store
what?"

**Ask:** "Where are string literals stored, and why is that beneficial?"
- *Cross-question:* "How many objects are created by:
  ```java
  String s1 = "test";
  String s2 = new String("test");
  ```
  Walk through it precisely, line by line."

### Live coding (0:28–0:45)

**Ask:** "Write a utility that converts a number to its Excel column
string — `1 -> A`, `27 -> AA`, `28 -> AB`."
- *Cross-question:* "Why isn't this just straightforward base-26
  conversion? What's the off-by-one trap here, and did you hit it?"

**Ask:** "Given two linked lists, determine if they intersect, and return
the intersection node."
- *Cross-question:* "Your solution uses extra space — say a `HashSet` of
  visited nodes. Can you do it in O(1) extra space instead? What's the
  trick?" (listen for: length difference + two-pointer alignment, or
  cycle-detection-style approach)

### Production/ops (0:45–0:58)

**Ask:** "What Java profilers or monitoring tools have you actually used,
by name, and for what specific problem?"

**Ask:** "Walk through your process for writing and testing a RESTful API,
end to end."

**Ask:** "Describe a real VPN or networking issue that broke API calls
between services. What was the actual root cause, and how did you find
it?"

**Ask:** "What's your approach to finding whether a vulnerable dependency
— say Log4j — exists somewhere in a large Maven project, without relying
on a scanner like Veracode or Qualys?"
- *Cross-question:* "Your project has 40 transitive dependencies three
  levels deep. `mvn dependency:tree` shows you what's there — how do you
  actually search it efficiently for one specific artifact?"

**Candidate questions (0:58–1:00)**

---

## Debrief (for self-practice)

**Strong signals:** the measurement question gets a real metric and time
window, not just a confident-sounding percentage; `s1`/`s2` answer
correctly lands on 1 object for `s1` (string pool hit) and 2 for `s2`
(pool entry + a separate heap object), with the *why* explained; both
coding problems get attempted with working code, and the O(1)-space
follow-up on the linked-list problem gets a real algorithmic answer, not
just "I'd think about it."

**Weak signals:** classloader question answered as pure theory with no
code attempt; Excel-column conversion ships with the off-by-one bug
uncaught (forgetting it's not zero-indexed base-26).
