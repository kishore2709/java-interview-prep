# Mock 4 — Spring Security, OAuth2/JWT & OWASP

**Format:** Technical, no coding · **Duration:** 60 min
**Role context:** Lead Fullstack Engineer, 13+ yrs · panel: security-focused
senior engineer
**KB tiers:** 2 (Security), 12 (Java Cryptography Architecture)

---

## Interviewer opening (0:00)

> "Security round. I'm going to ask about both the framework mechanics and
> the judgment calls — there's often more than one 'correct' answer and I
> want to hear you defend a tradeoff."

Timer: 60 minutes.

## Part 1 — Spring Security mechanics (0:00–0:15)

1. "Walk me through the Spring Security filter chain for a single
   authenticated request, start to finish."
2. "Where does `SecurityContext` live, and what breaks if you're using
   virtual threads or reactive (WebFlux) instead of the classic servlet
   model?"
3. "Method-level security (`@PreAuthorize`) vs URL-level (`HttpSecurity`
   matchers) — when do you use each, and why not just pick one?"

## Part 2 — OAuth2 / OIDC / JWT (0:15–0:35)

4. "Walk through an Authorization Code flow with PKCE end to end — every
   hop, every token."
5. "Your JWT access tokens are stateless — how do you revoke one before it
   expires? Give me your actual design, not 'you can't, that's the
   tradeoff' as a final answer — what do real systems do?"
6. "Key rotation for the signing key used to verify JWTs — how do you do it
   with zero downtime across 15 services validating tokens?"
7. "Refresh token theft — what's your detection and mitigation strategy?"

## Part 3 — RBAC/ABAC & multi-tenancy (0:35–0:45)

8. "Design authorization for a multi-tenant SaaS — RBAC, ABAC, or a hybrid?
   Defend your choice with a concrete scenario where the simpler model
   would fail."

## Part 4 — OWASP / secure coding (0:45–0:55)

9. "Pick three OWASP Top 10 risks you've actually had to defend against in
   a real system, and tell me the specific code-level fix for each — not
   the category name, the actual mitigation."
10. "Deserialization vulnerabilities — why are they particularly dangerous
    in Java specifically, and how do you guard against them?"
11. "Dependency vulnerabilities — walk me through your actual process for
    finding and patching a critical CVE in a transitive dependency across
    30 services."

## Part 5 — Lead judgment (0:55–0:58)

12. "A pentest just came back with a critical finding two days before a
    major release. What's your decision process?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:**
- JWT revocation answer reaches for a short-lived access token + revocable
  refresh token (or a denylist with TTL matching token expiry) rather than
  claiming it's unsolvable.
- Key rotation answer mentions overlapping/multiple valid keys (`kid` in
  JWT header, JWKS endpoint) during the rotation window.
- OWASP answers are specific code-level fixes (parameterized queries,
  output encoding, `ObjectInputFilter` for deserialization) not category
  recitations.

**Weak signals:**
- "We use OAuth2 so it's secure" without explaining what's actually being
  verified at each hop.
- No specific CVE-patching workflow (dependency scanning tool, SLA for
  criticals, how a fix gets fast-tracked through CI).

**Self-grade per part.**
