# Naming & Placement Rules

Keep this consistent and the repo stays navigable. Drift and it becomes a folder of mystery files.

## Folders

- Track work mirrors the tracks: `track1-near-term/week1/day05-cache/`, `track2-senior-mastery/week01-solid/`.
- **Create-as-you-go.** Only make a unit folder when I actually have something for it. The track README lists every unit regardless, so nothing looks missing.
- Bigger standalone builds go in `projects/<project-name>/`, not inside a day folder.

## Files

- Lowercase, hyphenated, self-describing: `topic-subtopic-type.ext`.
  - `strings-anagram.java`, `strings-anagram-notes.md`, `strings-anagram-handwritten.png`
- Java solution files keep their class name (`Day01Strings.java`) — Java requires the file to match the public class.
- Notes are always `notes.md`; the folder name already gives the topic.

## Images (handwritten notes, drawings)

- **Rename on import.** `IMG_6733.png` → `arrays-two-pointer-handwritten.png` the moment it lands, or it's lost in a month.
- Store the image **in the same folder** as the topic it belongs to (not a central dump).
- Link it from that folder's `README.md`: `![two pointer](arrays-two-pointer-handwritten.png)`.

## Confidence tags (use in notes)

`#shaky` (can't yet) · `#review` (close) · `#solid` (automatic). GitHub-search a tag to filter, e.g. before an interview search `#shaky`.

## The one rule that matters

Notes are in **my own words**. If I copied it from the track PDF, it doesn't count — rewrite until I can say it cold. Recognizing ≠ being able to deliver.
