# JVM Internals — Notes

> My own words. Tag: `#shaky` `#review` `#solid`.

## G1 vs ZGC vs Shenandoah `#shaky`
_(when I'd choose each, in my words)_

## LSM-tree vs B-tree (storage) `#shaky`
LSM: writes go to an in-memory memtable → flushed to immutable SSTables → background compaction. Write-optimized; reads check multiple files (read amplification). B-tree: in-place, point/range reads fast, random writes. _Why I'd pick one over the other → write this until I can say it cold._
