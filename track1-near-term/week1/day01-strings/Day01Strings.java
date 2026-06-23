import java.util.*;

/**
 * Day 1 - Strings / HashMap
 * Each problem is solved several ways, from a beginner brute force to the
 * optimal approach, so you can see WHY the better version wins.
 *
 * Run:  java src/week1/Day01Strings.java
 */
public class Day01Strings {

    // ============================================================
    // 1. First non-repeating character
    // ============================================================

    // Brute force (beginner): for each char, scan the rest. O(n^2) time, O(1) space.
    static char firstNonRepeatingBrute(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) { repeated = true; break; }
            }
            if (!repeated) return s.charAt(i);
        }
        return '_';
    }

    // Frequency array, no built-in DS (the plain-loop way). O(n) time, O(1) space (256 ASCII).
    static char firstNonRepeatingArray(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++) if (freq[s.charAt(i)] == 1) return s.charAt(i);
        return '_';
    }

    // LinkedHashMap keeps insertion order so a single pass over the map works. O(n).
    static char firstNonRepeatingMap(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : s.toCharArray()) count.merge(c, 1, Integer::sum);
        for (var e : count.entrySet()) if (e.getValue() == 1) return e.getKey();
        return '_';
    }

    // ============================================================
    // 2. Duplicate characters
    // ============================================================

    // Brute force (beginner). O(n^2).
    static List<Character> duplicatesBrute(String s) {
        List<Character> out = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && !out.contains(s.charAt(i))) {
                    out.add(s.charAt(i));
                    break;
                }
            }
        }
        return out;
    }

    // Frequency array, no DS. O(n).
    static List<Character> duplicatesArray(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        List<Character> out = new ArrayList<>();
        for (int c = 0; c < 256; c++) if (freq[c] > 1) out.add((char) c);
        return out;
    }

    // HashSet of seen chars. O(n).
    static Set<Character> duplicatesSet(String s) {
        Set<Character> seen = new HashSet<>(), dup = new LinkedHashSet<>();
        for (char c : s.toCharArray()) if (!seen.add(c)) dup.add(c);
        return dup;
    }

    // ============================================================
    // 3. Character frequency
    // ============================================================

    // Frequency array, no DS. O(n).
    static int[] frequencyArray(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        return freq;
    }

    // HashMap (handles any Unicode / key range cleanly). O(n).
    static Map<Character, Integer> frequencyMap(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) m.merge(c, 1, Integer::sum);
        return m;
    }

    // ============================================================
    // 4. Anagram check
    // ============================================================

    // Sorting approach (intermediate). O(n log n).
    static boolean isAnagramSort(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] x = a.toCharArray(), y = b.toCharArray();
        Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    // Frequency array int[26] for lowercase, no DS. O(n) - the optimal one.
    static boolean isAnagramCount(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < a.length(); i++) { freq[a.charAt(i) - 'a']++; freq[b.charAt(i) - 'a']--; }
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    // HashMap version (works for any charset). O(n).
    static boolean isAnagramMap(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> m = new HashMap<>();
        for (char c : a.toCharArray()) m.merge(c, 1, Integer::sum);
        for (char c : b.toCharArray()) {
            if (m.merge(c, -1, Integer::sum) < 0) return false;
        }
        return true;
    }

    // ============================================================
    // 5. String rotation  (is b a rotation of a?)
    // ============================================================

    // Concatenation trick (optimal/clean): b is a rotation of a iff b is a substring of a+a.
    static boolean isRotationConcat(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }

    // Manual check, no library substring: try every rotation offset. O(n^2).
    static boolean isRotationManual(String a, String b) {
        int n = a.length();
        if (n != b.length()) return false;
        for (int shift = 0; shift < n; shift++) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (a.charAt((i + shift) % n) != b.charAt(i)) { ok = false; break; }
            }
            if (ok) return true;
        }
        return false;
    }

    // ============================================================
    public static void main(String[] args) {
        System.out.println("1. First non-repeating ('swiss' -> w)");
        System.out.println("   brute=" + firstNonRepeatingBrute("swiss")
                + "  array=" + firstNonRepeatingArray("swiss")
                + "  map=" + firstNonRepeatingMap("swiss"));

        System.out.println("\n2. Duplicate characters ('programming')");
        System.out.println("   brute=" + duplicatesBrute("programming")
                + "  array=" + duplicatesArray("programming")
                + "  set=" + duplicatesSet("programming"));

        System.out.println("\n3. Character frequency ('apple')");
        Map<Character, Integer> f = frequencyMap("apple");
        System.out.println("   map=" + f + "  a-count(array)=" + frequencyArray("apple")['a']);

        System.out.println("\n4. Anagram ('listen','silent')");
        System.out.println("   sort=" + isAnagramSort("listen", "silent")
                + "  count=" + isAnagramCount("listen", "silent")
                + "  map=" + isAnagramMap("listen", "silent"));

        System.out.println("\n5. String rotation ('abcde','cdeab')");
        System.out.println("   concat=" + isRotationConcat("abcde", "cdeab")
                + "  manual=" + isRotationManual("abcde", "cdeab")
                + "  negative=" + isRotationConcat("abcde", "abced"));
    }
}
