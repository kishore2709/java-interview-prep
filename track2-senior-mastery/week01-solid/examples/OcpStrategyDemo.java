import java.util.*;

/**
 * OCP (Open/Closed) + DIP via Strategy, in my fraud/payment domain.
 * Adding a new rule never modifies FraudEngine — it's CLOSED for modification,
 * OPEN for extension. The engine depends on the FraudRule abstraction (DIP).
 *
 * Run:  java OcpStrategyDemo.java
 */
public class OcpStrategyDemo {

    record Transaction(String id, double amount, String country) {}

    // Abstraction the orchestrator depends on (DIP).
    interface FraudRule {
        boolean flagged(Transaction t);
        String name();
    }

    static class HighAmountRule implements FraudRule {
        public boolean flagged(Transaction t) { return t.amount() > 10_000; }
        public String name() { return "HighAmount"; }
    }

    static class GeoBlockRule implements FraudRule {
        private final Set<String> blocked = Set.of("XX", "YY");
        public boolean flagged(Transaction t) { return blocked.contains(t.country()); }
        public String name() { return "GeoBlock"; }
    }

    // CLOSED for modification: adding a rule never touches this class.
    static class FraudEngine {
        private final List<FraudRule> rules;
        FraudEngine(List<FraudRule> rules) { this.rules = rules; }
        List<String> evaluate(Transaction t) {
            List<String> hits = new ArrayList<>();
            for (FraudRule r : rules) if (r.flagged(t)) hits.add(r.name());
            return hits;
        }
    }

    public static void main(String[] args) {
        // OPEN for extension: drop in a new rule without editing FraudEngine.
        FraudRule microAmount = new FraudRule() {
            public boolean flagged(Transaction t) { return t.amount() < 1.0; }
            public String name() { return "MicroAmount"; }
        };

        var engine = new FraudEngine(List.of(new HighAmountRule(), new GeoBlockRule(), microAmount));

        System.out.println("t1 (25000, US) flags: " + engine.evaluate(new Transaction("t1", 25_000, "US")));
        System.out.println("t2 (50, XX)    flags: " + engine.evaluate(new Transaction("t2", 50, "XX")));
        System.out.println("t3 (0.5, US)   flags: " + engine.evaluate(new Transaction("t3", 0.5, "US")));
    }
}
