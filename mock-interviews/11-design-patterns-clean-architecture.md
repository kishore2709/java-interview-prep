# Mock 11 — Design Patterns, SOLID & Clean Architecture Critique

**Format:** Technical + live code critique · **Duration:** 60 min
**KB tiers:** 6 (Design Patterns, SOLID), Track2 week01-solid / week03 / week04

---

## Interviewer opening (0:00)

> "Half discussion, half I-hand-you-code-and-you-critique-it. This is about
> judgment — knowing a pattern's name matters less than knowing when NOT to
> use it."

Timer: 60 minutes.

## Part 1 — SOLID with real scars (0:00–0:15)

1. "Give me a real SOLID violation you found in a legacy codebase — which
   principle, what was the actual code smell, and what did you change?"
2. "When does strictly following SOLID over-engineer a simple problem? Give
   me an example where you deliberately didn't apply it."

## Part 2 — Pattern selection (0:15–0:30)

3. "You need to support 5 different payment providers behind one interface,
   each instantiated differently based on config. Strategy, Factory, or
   both? Walk through your design."
4. "Builder pattern — when does a class actually need it vs just being
   over-engineered for a 3-field DTO?"
5. "Tell me about a pattern you used that turned out to be the wrong call
   in hindsight. What would you do differently now?"

## Part 3 — Live code critique (0:30–0:50)

> I'm handing you this class. Find every problem, then propose a redesign.
> ```java
> public class OrderProcessor {
>     public void process(Order order) {
>         if (order.getType().equals("STANDARD")) {
>             // 40 lines of standard processing logic
>             double tax = order.getAmount() * 0.08;
>             order.setTax(tax);
>             emailService.send(order.getCustomerEmail(), "Order processed");
>             db.save(order);
>         } else if (order.getType().equals("EXPRESS")) {
>             // another 40 lines, mostly duplicated
>             double tax = order.getAmount() * 0.08;
>             order.setTax(tax);
>             smsService.send(order.getCustomerPhone(), "Order processed");
>             db.save(order);
>             priorityQueue.add(order);
>         } else if (order.getType().equals("INTERNATIONAL")) {
>             // another 40 lines
>             double tax = order.getAmount() * 0.15;
>             order.setTax(tax);
>             db.save(order);
>             customsService.fileDoc(order);
>         }
>     }
> }
> ```
> Identify: OCP violation, duplication, mixed concerns (tax calc / notify /
> persist / customs all in one method), stringly-typed branching. Then
> redesign — Strategy pattern keyed by order type is the expected shape,
> but push for: where does notification dispatch live, how do you avoid a
> god-interface, how do you unit test each strategy in isolation.

## Part 4 — Wrap-up (0:50–0:58)

6. "How do you teach a team of mixed-seniority engineers to recognize this
   kind of violation before it ships, not after?"

## Candidate questions (0:58–1:00)

---

## Debrief

**Strong signals:** redesign separates tax calculation, notification, and
persistence into distinct collaborators (not just splitting the if/else
into a Strategy that still does all 4 things internally); names the
testability win explicitly.

**Weak signals:** renames the if/else to a switch and calls it done; can't
name a real SOLID violation from actual experience.
