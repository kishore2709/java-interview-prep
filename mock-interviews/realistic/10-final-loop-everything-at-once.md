# Realistic Mock 10 — Final Loop: Everything At Once

**Format:** Client interview, mixed full final round · **Duration:** 120 min
**Use as:** interviewer script or self-practice. Everything from mocks
1–9 (now extended through 17) shows up once, out of order, the way a real
2-hour final round actually unfolds — technical, then a live coding moment
with no warning, then behavioral, then back to technical. Keep
[story-bank.md](story-bank.md) and [cheat-sheet.md](cheat-sheet.md) in
mind — WSI is Azure, CARB is AWS, don't cross them.

Take a real 5-minute break at the halfway mark if running this solo —
some real final rounds give you one, some don't; either way, notice how
your answer quality holds up afterward.

---

**Ask:** "Walk me through your background and your most recent project —
what was it, and what was your specific role, especially around
architecture and the move to the cloud if that applies?"
- *Cross-question:* "What part of that was entirely yours versus
  reviewed/delegated?"

**Ask:** "How many services did that system end up split into, and was
communication between them point-to-point or event-driven?"

**Ask:** "What's the saga pattern, and did you use it here? Walk through
one specific saga end to end, including compensation."
- *Cross-question:* "What are the ways you'd instead ensure a commit only
  happens once all services succeed — and why didn't you use that
  approach here?"

**Ask (no warning, code this live):** "Write a utility to decode a
run-length string like `'a2b3'` into `'aabbb'`."
- *Cross-question:* "Now handle malformed input — `'a2b'` with no
  trailing count, or an empty string. Does your code still behave
  sensibly?"

**Ask:** "How did you implement OAuth/JWT-based security for this system?
What's actually in the token, and who validates it, where?"
- *Cross-question:* "How do you revoke a token before it expires?"

**Ask:** "Tell me about a production incident — a consumer running slow
with the producer's queue backing up. What did you actually do?"

**Ask:** "Describe a real disagreement with a team member over an
architecture choice. How did it resolve, and what did the other person
have right that you didn't want to admit at first?"

**Ask:** "What's the difference between L1 and L2 cache in Hibernate, and
what's the scope of each?"

**Ask:** "How do you migrate a `NOT NULL` column onto a massive production
table with zero downtime?"
- *Cross-question:* "Walk through the exact phases — what ships first,
  second, third."

**Ask (live system design, take 15-20 min):** "Design a REST API for
finding nearby parking garages and reserving a specific spot, handling two
users trying to reserve the same spot at the same time."

**Ask:** "How do you manage state in React so a UI updates in real time —
say, spot availability changing as other users reserve? Have you used
WebSockets or SSE for this?"
- *Cross-question:* "Does that approach hold up with 500 people watching
  the same garage page at once?"

**Ask:** "What's a materialized view, and where have you actually used
one?"

**Ask:** "Share a real example where you personally introduced a bug into
production. What happened, and how did you fix it?"

**Ask:** "How large have the teams you've led been, and how do you manage
a distributed or offshore team day to day?"

**Ask:** "How do you find whether a vulnerable dependency — say Log4j —
exists in a large Maven project without relying on a scanner like Veracode
or Qualys?"

**Ask (no warning, code this live):** "Given two linked lists, determine
whether they intersect and return the intersection node."
- *Cross-question:* "Can you do it in O(1) extra space instead of using a
  visited-set?"

**Ask:** "What's your approach to Java performance optimization end to
end, and how did you actually measure an improvement on a real project,
with real numbers?"

**Candidate questions (last 5 min)**

---

## Debrief (for self-practice)

**This is the round where fatigue management is itself a skill.** Notice
where your answer quality dropped — usually somewhere in the second
hour — and treat that as data, not just "I got tired."

**Strong signals:** technical answer quality in the second half held up
to the same bar as the first half; the unannounced coding questions got
real attempted code, not a freeze; the live system-design question,
dropped mid-call, still got a properly structured answer (clarify
requirements first) instead of rushing because time felt tight.

**Weak signals:** visibly shorter, less structured answers in the back
half; the unannounced coding interruptions broke flow for the rest of the
call instead of being absorbed and moved past.

**Self-grade:** grade the call holistically first (pass/fail as a whole),
then go back and tag individual weak spots — that mirrors how a real
panel actually debriefs afterward.
