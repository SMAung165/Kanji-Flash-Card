# 🎴 KanjiFlash

A console-based Kanji flashcard quiz app built with Java — because why not combine JLPT prep with Java practice? Study smarter, not harder. 勉強しろ！😄

---

## ✨ Features

- **JLPT Level Selection** — practice N5 through N1
- **Custom card count** — choose how many Kanji to study per session
- **Multiple choice quiz** — 4 randomized choices per card
- **Smart wrong answer generation** — wrong choices come from the same JLPT level, never duplicates the correct answer
- **Score tracking** — see how many you got right at the end
- **Mistake review** — review every card you got wrong with the correct reading
- **JSON-based Kanji database** — clean, maintainable data source per JLPT level

---

## 🛠️ Tech Stack

| | |
|---|---|
| Language | Java 17+ |
| IDE | IntelliJ IDEA |
| Build | Maven |
| JSON Parsing | Google GSON |

---

## 🚀 How To Run

1. Clone the repo
```bash
git clone https://github.com/SMAung165/Kanji-Flash-Card.git
```
2. Open in IntelliJ IDEA
3. Make sure GSON dependency is in `pom.xml`:
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```
4. Run `Main.java`

---

## 💡 Usage

```
Select JLPT Level
-----------------
1. N5
2. N4
3. N3
4. N2
5. N1
> 4

Enter the number of Kanji(s) you want to practice.
----------------------------------------------
> 5

----------------------------------------------
Kanji: 漢
Meaning: Sino-, China
Card Number: 1
1. Kun: {おとこ}, On: {ダン、ナン}
2. Kun: {おとな}, On: {ジン、ニン}
3. Kun: {おとこ、おのこ}, On: {ダン、ナン}  ← correct!
4. Kun: {none}, On: {カン、おとこ}
Your answer: 3
Your answer is correct!
```

---

## 🧠 Concepts Practiced

- Abstract classes — `Flashcard` as base template
- Interfaces — `Reviewable` contract
- OOP — encapsulation, inheritance, polymorphism
- JSON loading — GSON with custom field mapping
- ArrayList — dynamic deck and history management
- Package structure — real-world `com.soemoe.kanjiflashcard` layout
- Input validation — `ValidationUtils` shared utility

---

## 📁 Project Structure

```
src/main/java/com/soemoe/kanjiflash/
├── Main.java
├── models/
│   ├── Flashcard.java       ← abstract
│   ├── KanjiCard.java
│   └── Kanji.java
├── services/
│   ├── QuizService.java
│   └── KanjiDatabase.java
├── contracts/
│   └── Reviewable.java      ← interface
└── utils/
    ├── JsonLoader.java
    └── ValidationUtils.java

src/main/resources/
├── kanji_n1.json
├── kanji_n2.json
├── kanji_n3.json
├── kanji_n4.json
└── kanji_n5.json
```

---

## 🗺️ Future Plans

- [ ] Android app version with proper UI/UX
- [ ] Spaced repetition system (SRS) for smarter review
- [ ] Save progress between sessions with File I/O
- [ ] Meaning-based quiz mode (not just reading)
- [ ] Stroke order diagrams

---

> Built independently as part of a Java learning journey — while simultaneously studying for JLPT N2. Two birds, one stone. 🎯
