# LRU Cache (plain Java practice)

Standalone LRU cache built two ways: the easy `LinkedHashMap(accessOrder=true)` version and a manual `HashMap + doubly linked list` version, plus a TTL variant.

## Run
```bash
java LruCache.java
```

## What I'm practicing
- [ ] Manual doubly-linked-list eviction (O(1) get/put)
- [ ] Generics
- [ ] equals/hashCode for keys
- [ ] TTL / expiry
