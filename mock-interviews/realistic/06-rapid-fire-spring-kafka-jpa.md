# Realistic Mock 6 — Rapid-Fire: Spring Security, Kafka, JPA, Streams

**Format:** Client technical interview, fast topic jumps · **Duration:** 45 min
**Use as:** interviewer script or self-practice. Real rapid-fire rounds
punish over-explaining — keep each answer under ~90 seconds, with the
cross-question only fired if the first answer is shallow.

---

**Ask:** "Give me a quick rundown of the architectures you've worked on."
- *Cross-question:* "Is your current architecture actually scalable —
  give me a real number, users or transactions per second."

**Ask:** "Do your microservices talk directly to each other, or through an
API Gateway?"

**Ask:** "How did you implement security for your APIs?"
- *Follow-up:* "How does the system check whether a user has permission
  to call a *specific* API — walk through the actual check."
- *Cross-question:* "How does `@PreAuthorize` actually work under the
  hood — what's intercepting the call before your method runs?"

**Ask:** "What does a JWT token actually contain, and how is it
validated?"
- *Cross-question:* "Where does validation happen — at the gateway, at
  each service, or both? What's the tradeoff?"

**Ask:** "Have you used Kafka for inter-service communication? Give a
specific example."
- *Cross-question:* "What happens if a message gets duplicated — how do
  you guarantee idempotent consumption?"

**Ask:** "What are consumer groups, and what happens if you have more
consumer instances in a group than partitions on the topic?"

**Ask:** "How have you used `parallelStream()` in real code, and what
precautions do you take?"
- *Cross-question:* "You used `parallelStream()` over a list while reading
  from a database connection inside the stream. What's the actual risk?"

**Ask:** "How do `filter()` and `groupingBy()` work together — give a real
example from your code."

**Ask:** "What's L1 versus L2 cache in JPA/Hibernate — and what's the
scope of each?"
- *Cross-question:* "Two different transactions in the same HTTP request
  load the same entity. Does L1 cache help here? Why or why not?"

**Ask:** "What's the actual difference between using JPA directly versus
going through Hibernate's native session API?"

**Ask:** "Have you used streaming/cursor-based reads in JPA for large
result sets? When would you need that over a normal query?"

**Ask:** "Did you implement Kafka producers and consumers yourself,
hands-on, or mostly consume what others built?"
- *Cross-question (if hands-on claimed):* "Walk me through the actual
  producer config you'd set for at-least-once delivery, by name."

**Ask:** "Did you use Redis or any other caching strategy? What was being
cached, and what invalidated it?"

---

## Debrief (for self-practice)

**This round rewards breadth and pace, not depth on any one answer.** If
you catch yourself going past 90 seconds on one question, that's a signal
to compress, not a sign you should keep going.

**Strong signals:** kept pace across all questions without visibly
rushing the back half; honest about hands-on vs. consumed when asked
directly; L1/L2 cache answer correctly scopes L1 to the
persistence-context/transaction and L2 to the shared `SessionFactory`.

**Weak signals:** ran long on 2-3 favorite topics and rushed the rest;
`parallelStream()` answer with no mention of shared-state or
blocking-I/O-on-the-common-pool risks.
