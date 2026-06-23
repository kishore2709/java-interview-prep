# Mock 16 — Fullstack: API Contracts & Frontend Integration

**Format:** Technical, no coding · **Duration:** 60 min
**KB coverage gap:** the knowledge-base has no frontend/JS/TS content — this
interview is original material, not pulled from a tier. Use it to find your
actual frontend gaps, then go self-study those specifically (not covered by
either repo right now).

---

## Interviewer opening (0:00)

> "You're a lead Fullstack title — this round checks the 'full' part. I
> won't go deep into a specific framework's internals, but I expect you to
> reason fluently about the seam between backend and frontend."

Timer: 60 minutes.

## Part 1 — API contract design from the consumer's side (0:00–0:15)

1. "A frontend team consumes your REST API. What do you put in an OpenAPI
   spec beyond the basics, so they can build against it before your
   backend is done?"
2. "How do you handle a breaking API change when you don't control the
   frontend's release cadence?"

## Part 2 — State & data fetching (0:15–0:30)

3. "Where does caching live for a page that needs the same data fetched by
   three components — backend response cache, CDN, or client-side
   (React Query/SWR-style)? Layer them and explain each one's job."
4. "Optimistic UI updates — design the rollback path when the backend
   rejects an action the UI already showed as successful."

## Part 3 — Auth across the seam (0:30–0:40)

5. "Where does the access token live in the browser — cookie, localStorage,
   memory? Defend against XSS/CSRF tradeoffs for your choice."
6. "Token refresh while the user has 5 tabs open — how do you avoid 5
   simultaneous refresh calls racing each other?"

## Part 4 — Performance across the seam (0:40–0:50)

7. "A page is slow. How do you tell, in the first 5 minutes, whether it's a
   backend latency problem, a network/payload-size problem, or a frontend
   rendering problem?"
8. "Design pagination/infinite-scroll for a list backed by your API —
   cursor-based vs offset, and why does it matter more on the frontend
   than people think?"

## Part 5 — Honest gap-finding (0:50–0:58)

9. "What frontend framework/tooling have you used most recently in
   production, and what's the one thing about its current best practices
   you're least confident is still accurate?" — answer this one honestly,
   it's diagnostic for you, not just the interviewer.

## Candidate questions (0:58–1:00)

---

## Debrief

**This interview is partly a self-assessment.** If Part 5 reveals you
haven't touched frontend code in 2+ years, that's the real finding — note
it and go build a small full-stack side project (even a CRUD app) before
your real loop, rather than relying on the KB, which has nothing here.

**Strong signals:** token storage answer names a specific concrete
mitigation (httpOnly cookie + CSRF token, or in-memory token + silent
refresh) rather than just listing the tradeoffs without picking one.
