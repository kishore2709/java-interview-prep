# Realistic Mock 11 — Design Patterns, Project-Mapped

**Format:** Client technical interview · **Duration:** 60 min
**Use as:** interviewer script or self-practice. See
[story-bank.md](story-bank.md) for the WSI/CARB anchors referenced below.
Answer template for this whole round: **Problem → pattern → implementation
→ why not a simpler alternative → project usage.**

---

**Ask:** "Where have you actually used the Strategy pattern in a real
system?"
- *Follow-up:* "Walk through the payment/fraud rule case specifically —
  what problem was the if/else chain causing before you refactored?"
- *Cross-question:* "When would adding a Strategy interface here be
  over-engineering instead of good design? Where's the line?"

**Ask:** "Factory vs. Strategy — what's the actual difference, and when do
you reach for one over the other?"
- *Cross-question:* "Give me a case where you used both together — a
  Factory that selects which Strategy implementation to hand back."

**Ask:** "How is the Builder pattern useful for something like an
Accertify or device-fingerprint payload?"
- *Follow-up:* "Why not just a constructor with 8 parameters, or a plain
  setter-based POJO?"
- *Cross-question:* "Your Builder is now used to construct an object with
  some required and some optional fields. How do you enforce the required
  ones at compile time, not just at runtime?"

**Ask:** "Spring singleton beans vs. the classic Singleton design
pattern — what's actually different between them?"
- *Cross-question:* "If Spring already manages a single instance for you,
  why would you ever still hand-write a Singleton in a Spring app?"

**Ask:** "Where would Observer show up in an event-driven system — say,
Kafka event flow for risk or gift-card events?"
- *Cross-question:* "Kafka consumers aren't literally the GoF Observer
  pattern. What's actually analogous, and where does the analogy break
  down?"

**Ask:** "How do you use the Adapter pattern for a third-party
integration — wrapping an external fraud/risk client, for instance?"
- *Follow-up:* "What specifically does the adapter shield your core
  service from? Walk through what changes on the provider side that your
  adapter absorbs without touching calling code."
- *Cross-question:* "This is also Dependency Inversion in disguise — your
  service depends on an interface, not the concrete client. Explain how
  the two principles relate here."

**Ask:** "Where have you used Decorator or Template Method, if at all?
Be honest if these are thinner experience for you."

**Ask:** "How do you personally avoid over-engineering — applying a
pattern where a simpler alternative would've been fine?"
- *Cross-question:* "Give me a real example where you, or someone on your
  team, over-applied a pattern. What did you simplify it back to?"

**Ask:** "How do you apply Dependency Inversion specifically in Spring —
not the textbook definition, the actual annotation-level mechanics?"
- *Cross-question:* "Your service depends on a repository interface.
  Spring injects the implementation. What breaks this if someone
  `new`s up the concrete repository directly somewhere in the codebase
  instead of injecting it?"

**Ask:** "How do you review code for SOLID/pattern violations during a
code review? What do you actually flag, concretely?"

**Candidate questions (last 5 min)**

---

## Debrief (for self-practice)

**Strong signals:** every pattern answer follows Problem → pattern →
implementation → why-not-simpler → project usage, in that order, without
prompting; the over-engineering cross-question gets a real, specific
example of simplifying something back down, not just "we try to keep it
simple."

**Weak signals:** patterns explained as textbook GoF definitions with no
project tied to them; can't articulate where the Observer analogy to
Kafka breaks down (e.g., no guaranteed delivery/ordering semantics like
synchronous in-process Observer has).
