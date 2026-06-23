# Day 1 — Strings — Notes

> My own words only. Tag confidence: `#shaky` `#review` `#solid`.

## First non-repeating character `#review`
Two passes with an `int[256]` frequency array beats a brute O(n²) scan. LinkedHashMap works too because it keeps insertion order. My one-liner: _"count in one pass, then return the first char whose count is 1."_

## Anagram `#solid`
`int[26]` count: `++` for string a, `--` for string b, then all-zero check. O(n) vs the O(n log n) sort approach.

## Trap to remember `#review`
Override **equals() AND hashCode() together** — overriding one alone silently breaks HashMap/HashSet lookups.

## Fumbled / to redo
- [ ] _(log anything I got wrong here)_
