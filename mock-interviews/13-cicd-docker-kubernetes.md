# Mock 13 — CI/CD, Docker & Kubernetes

**Format:** Technical, no coding · **Duration:** 60 min
**KB tiers:** 14, 17 (Docker, CI-CD, Kubernetes, Helm), Track2 week08

---

## Interviewer opening (0:00)

> "Platform/delivery round. I want to see if you've actually operated these
> tools in anger, not just read about them."

Timer: 60 minutes.

## Part 1 — Docker (0:00–0:15)

1. "Walk me through a multi-stage Dockerfile for a Spring Boot app — why
   multi-stage, and what's actually in each stage?"
2. "Your image is 1.2GB and should be 200MB. Where do you look first?"
3. "Layer caching — design your Dockerfile's instruction order to maximize
   cache hits across CI builds. Why does order matter?"

## Part 2 — CI/CD pipeline (0:15–0:30)

4. "Design a CI/CD pipeline for this service: build, test, scan, deploy,
   rollback. What gates block promotion to prod, and what's automatic vs
   manual approval?"
5. "A bad deploy just went to prod. Walk through your rollback — is it a
   redeploy of the previous image, a feature flag, or something else?
   Defend the choice for this specific failure."
6. "How do you handle database migrations in the same pipeline as app
   deploys without an outage window?"

## Part 3 — Kubernetes (0:30–0:50)

7. "Readiness vs liveness probes for a Spring Boot app with a slow startup
   (loading a large cache) — what goes wrong if you configure these
   incorrectly, specifically?"
8. "Pod keeps getting OOMKilled under load. Walk through your diagnosis —
   resource requests/limits, JVM heap flags, the works."
9. "Design a rolling deployment strategy that's safe for a stateful
   connection (e.g. WebSocket) — what's your approach to draining
   connections gracefully?"
10. "ConfigMaps/Secrets vs externalized config service (Vault, Spring
    Cloud Config) — when do you reach for which?"

## Part 4 — Helm & wrap-up (0:50–0:58)

11. "Why Helm over raw manifests for a team running 40 microservices?
    What's the actual pain it solves and the new pain it introduces?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:** OOMKilled diagnosis connects k8s resource limits to JVM
heap/metaspace flags explicitly (a JVM defaulting to 25% of detected
memory inside a container with a tight limit is the classic real bug);
readiness probe answer explains the load-balancer-routes-to-not-ready-pod
failure mode concretely.

**Weak signals:** "we just increased the memory limit" with no root-cause
diagnosis; can't explain why liveness-probe misconfiguration causes
crash-loop death spirals under load.
