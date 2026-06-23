# Realistic Mock 16 — AI/RAG Positioning (Track 3 Differentiator)

**Format:** Client technical interview · **Duration:** 45 min
**Use as:** interviewer script or self-practice.

**Positioning statement to internalize before running this:** "My core is
Java/Spring Boot microservices. AI/RAG is an extension layer I'm building
on top of backend systems — ingest, chunk, embed, retrieve, augment, and
generate grounded answers. I frame it honestly as a growing
differentiator, not as inflated AI production experience."

This round is graded as much on **honesty under pressure** as on
knowledge — see the cross-questions, which are deliberately designed to
tempt overclaiming. See [story-bank.md](story-bank.md)'s honesty guardrail.

---

**Ask:** "Explain RAG to me in two minutes — the full pipeline."
- *(listen for: ingest → chunk → embed → retrieve → augment → generate)*
- *Cross-question:* "Where in that pipeline does hallucination actually
  get introduced, and where does grounding fight back against it?"

**Ask:** "What are embeddings, and what is vector search actually doing
under the hood?"
- *Cross-question:* "Semantic search vs. keyword search — give me a case
  where keyword search would actually outperform semantic search, not
  just the reverse."

**Ask:** "How do you decide chunk size when building a RAG pipeline?"
- *Cross-question:* "Your chunks are too small. What specifically degrades
  — retrieval precision, generation quality, or both, and why?"

**Ask:** "What's top-k retrieval, and what's reranking, and why would you
need both instead of just a bigger k?"

**Ask:** "Have you actually built something with Spring AI — `ChatClient`,
a vector-store abstraction, pgvector? Walk through what you built,
honestly."
- *Cross-question (this is the trap question):* "So is this running in
  production right now, serving real user traffic?" — **answer this
  exactly as honestly as the real situation is.** If it's a prototype,
  say "prototype," not "production."

**Ask:** "How would you add AI to an existing eCommerce Spring Boot app —
say, a gift-reminder or occasion-classification feature?"
- *Follow-up:* "Walk through it the way you would frame it honestly: core
  is Java/Spring, AI is the edge layer on top — what does that mean
  concretely in this design?"

**Ask:** "How do you secure a GenAI-backed application — specifically,
how do you avoid sending PII to a model provider?"

**Ask:** "What's prompt injection, and how would you defend against it in
a customer-facing RAG feature?"

**Ask:** "How do you evaluate RAG quality — not just 'it works,' but an
actual evaluation approach?"

**Ask:** "How do you handle cost and latency for an LLM-backed feature in
a production-adjacent system?"
- *Cross-question:* "Do you cache LLM responses? What's safe to cache and
  what isn't — think about a personalized answer vs. a generic one."

**Ask:** "Last one, and it's the one that matters most: how do you
explain your AI experience honestly to a client who's clearly trying to
gauge whether you're overselling it?"

**Candidate questions**

---

## Debrief (for self-practice)

**Strong signals:** uses "I built / explored / prototyped" language
naturally, without being walked into it; the production-traffic trap
question gets an honest, immediate answer rather than a hedge that
implies more than is true; chunk-size answer connects the tradeoff to a
concrete retrieval-quality consequence, not just "smaller chunks are more
precise."

**Weak signals:** any answer that implies production-scale GenAI
ownership when the real experience is a finished demo or prototype — this
is explicitly the credibility trap the Track 3 material warns against,
and a sharp interviewer will find the gap fast if you overclaim here.

**Reminder:** this is only 3% of the master bible's readiness weighting —
useful as a differentiator, not something to over-invest prep time in at
the expense of Spring/Kafka/SQL/project depth.
