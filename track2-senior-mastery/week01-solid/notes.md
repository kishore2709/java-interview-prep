# Week 1 — SOLID — Notes

> My own words + my project examples. Grounded in Gift Reminders / occasion predictor / eCommerce work.

---

## SRP — Single Responsibility Principle

**Meaning:** One class should have one clear job.

**My project example:** Gift Reminders service doing everything — reading orders, predicting occasion, validating reminder, persisting to Cassandra, publishing events, sending email. Bad design.

**Better design:**
- `GiftOrderReader`
- `OccasionPredictionService`
- `GiftReminderValidator`
- `GiftReminderRepository`
- `GiftReminderEventPublisher`
- `GiftRecommendationService`

Each has one reason to change.

**Interview answer:** "In my Spring Boot batch/API work, I split business logic across focused service classes. In Gift Reminders, reading order data, predicting occasion, validating rules, persisting to Cassandra, and publishing payloads are separate components. That makes code easier to test, debug, and change."

---

## OCP — Open/Closed Principle

**Meaning:** Code should be open for extension but closed for modification.

**My project example:** Different retail brands have different reminder logic (BRAND_A, BRAND_B, BRAND_C, BRAND_D, BRAND_E).

Bad design:
```
if (brand.equals("BRAND_A")) { ... }
else if (brand.equals("BRAND_B")) { ... }
else if (brand.equals("BRAND_C")) { ... }
```
Every new brand requires modifying the same class.

**Better design:**
```
interface GiftReminderRule {
    boolean supports(String brand);
    ReminderConfig getConfig(Order order);
}
```

Then: `BrandAReminderRule`, `BrandBReminderRule`, `BrandCReminderRule` — each a new class.

**Interview answer:** "In eCommerce, brand/market-specific logic changes often. Instead of adding if-else blocks, I use strategy-style classes. Each brand has its own rule implementation. When a new brand comes in, I add a new class instead of modifying tested code."

---

## LSP — Liskov Substitution Principle

**Meaning:** Child classes or implementations should be replaceable without breaking behavior.

**My project example:** Payment/fraud/risk provider integration.

```
interface RiskEvaluationClient {
    RiskResponse evaluateRisk(RiskRequest request);
}
```

Implementations: `AccertifyRiskClient`, `MockRiskClient`, `FutureRiskProviderClient`

Bad design:
- `AccertifyRiskClient` returns null sometimes
- `MockRiskClient` throws random exceptions
- `FutureRiskProviderClient` requires different request fields

Substituting one breaks the service.

**Better design:** Each implementation honors the interface contract — accepts same request, returns valid response, throws expected exceptions, respects timeout/failure behavior.

**Interview answer:** "For provider integrations like Accertify or fraud evaluation, I define a clear interface contract. Any implementation — whether a real provider, mock for tests, or future provider — should be substitutable without the service changing behavior. That is Liskov in practice: interchangeable implementations should not surprise the caller."

---

## ISP — Interface Segregation Principle

**Meaning:** Don't force classes to implement methods they don't need.

**Bad design:**
```
interface NotificationService {
    void sendEmail();
    void sendSms();
    void sendPush();
    void publishKafkaEvent();
    void publishC3Payload();
}
```
A class that only publishes Kafka events is forced to implement email/SMS.

**Better design:**
```
interface EmailPublisher {
    void publishEmailRequest(EmailRequest request);
}

interface EventPublisher {
    void publishEvent(EventPayload payload);
}

interface SmsSender {
    void sendSms(SmsRequest request);
}
```

**Interview answer:** "I avoid large generic interfaces like NotificationService with email, SMS, push, and Kafka together. Not every implementation needs all operations. I prefer smaller focused interfaces like EmailPublisher, EventPublisher, or RiskClient. That keeps implementations clean and avoids empty or unsupported methods."

---

## DIP — Dependency Inversion Principle

**Meaning:** High-level business logic should depend on interfaces, not concrete classes.

**Bad design:**
```java
public class GiftReminderService {
    private CassandraGiftReminderRepository repo = new CassandraGiftReminderRepository();
    private KafkaPublisher publisher = new KafkaPublisher();
}
```
Tightly couples service to Cassandra and Kafka.

**Better design:**
```java
@Service
public class GiftReminderService {
    private final GiftReminderRepository repository;
    private final GiftReminderPublisher publisher;

    public GiftReminderService(GiftReminderRepository repository,
                               GiftReminderPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }
}
```
Spring injects dependencies.

**Interview answer:** "In Spring Boot, I apply dependency inversion by injecting interfaces into services. GiftReminderService depends on GiftReminderRepository and GiftReminderPublisher interfaces, not Cassandra or Kafka directly. This makes business logic easier to unit test with mocks and easier to change if storage or publisher changes."

---

## Strong Interview Summary

"I don't think of SOLID as theory. I apply it mostly when designing Spring Boot services. For example, in Gift Reminder workflows, I separate order reading, occasion prediction, validation, persistence, and event publishing into different components — that is SRP. For brand-specific rules, I use strategy-style implementations instead of if-else blocks — that is Open/Closed. For provider integrations like Accertify or risk evaluation, I define interfaces so implementations can be replaced safely — that is Liskov. I keep interfaces small, like EmailPublisher or EventPublisher, instead of one large interface — that is ISP. And I inject dependencies through interfaces using Spring, so services don't directly depend on Cassandra, Kafka, or external clients — that is Dependency Inversion."

---

## Interview Phrasing Bank

- **SRP:** "I split big service classes into focused components with one reason to change."
- **OCP:** "I add new behavior using new classes, not by modifying existing code."
- **LSP:** "Implementations must be safely replaceable without surprising the caller."
- **ISP:** "I keep interfaces small and focused, not forcing implementations to support unused methods."
- **DIP:** "I inject interfaces, not concrete classes, so business logic depends on abstractions."

---

## Key Traps

- **YAGNI:** Don't abstract before there's a real second case; it's a smell to over-apply patterns early.
- **False SRP:** "One responsibility" ≠ "one method" — it's one *axis of change*.
- **Liskov violations:** When implementations silently differ on behavior (null vs exception, different request format, timeout handling), substitution breaks.
