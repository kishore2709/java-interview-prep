# Interview Prep

My complete interview-prep knowledge base for senior / lead Java roles. Two layers:

- **`tracks/`** — the finished reference PDFs. Read these.
- **`track1`–`track4` + `projects/`** — my working notes, code, drawings, and practice builds. I write these as I go.

This README is the index. Open the repo, click through from here — you should never have to hunt.

---

## Reference (read these first)

_Add your track PDFs to [tracks/](tracks/) using the filenames below so these links resolve._

| | Document | What it is |
| --- | --- | --- |
| 0 | [Master Bible](tracks/0-master-bible.pdf) | Operating system & scorecard: philosophy, readiness model, story bank, emergency questions, gold answers, cheat sheet. |
| 1 | [Track 1 — Near-Term Execution](tracks/1-near-term-execution.pdf) | 30-day daily plan + ~195-problem core-Java practice bank. |
| 2 | [Track 2 — Senior / Tech Lead Mastery](tracks/2-senior-tech-lead-mastery.pdf) | 12-week production-readiness & leadership build. |
| 3 | [Track 3 — Java + AI/RAG Differentiator](tracks/3-java-ai-rag-differentiator.pdf) | 6-month AI/RAG positioning roadmap. |
| 4 | [Track 4 — Future Reference / Advanced Gaps](tracks/4-future-reference-advanced.pdf) | Conditional deep-DSA / JVM / K8s / AWS / security roadmap. |
| ★ | [Complete (all-in-one)](tracks/5-complete-all-in-one.pdf) | Everything above merged into one bookmarked file. |

## My work (mirrors each track's structure)

The repo folders follow the tracks 1:1, so the PDF and my work are two views of the same map.

| Folder | Mirrors | Organized by | What's inside |
| --- | --- | --- | --- |
| [track1-near-term/](track1-near-term/) | Track 1 | week → day (`dayNN-topic/`) | coding solutions (`.java`), notes, handwritten scans |
| [track2-senior-mastery/](track2-senior-mastery/) | Track 2 | week (`weekNN-topic/`) | concept notes in my words, small demo code |
| [track3-ai-rag/](track3-ai-rag/) | Track 3 | month / section | AI/RAG notes, mini-project links |
| [track4-advanced/](track4-advanced/) | Track 4 | topic (only what a JD needs) | deep-dive notes |
| [projects/](projects/) | — | one folder per build | standalone Spring Boot / Java practice projects, each self-contained |

## How to navigate

- Everything is reachable from this page or a folder's own `README.md`.
- Each unit folder (a day, a week, a project) has a short `README.md` saying what's inside and my one-line takeaway — so you can skim without opening every file.
- File names are self-describing and lowercase-hyphenated (see [NAMING.md](NAMING.md)).

## The routine

- **Daily:** do the day's work, drop it in the matching folder, write `notes.md` in my own words.
- **Handwritten pages:** scan → rename to `topic-handwritten.png` → drop in the folder → link it from that folder's README.
- **Weekly:** re-read the shaky notes out loud; prune what's automatic.
- **Commit per session** with a message like `day05: cache internals, still shaky on LSM` — the Git history becomes the progress record.

> Note: contains real project references. Keep this repo **private** (or genericize the personal stories) if sharing.
