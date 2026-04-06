# KanjiFlash
> A console-based Kanji flashcard quiz application built with Java — combining JLPT exam preparation with real-world software engineering practices.

---

## Overview

KanjiFlash is a Java console application that quizzes users on Kanji readings through a multiple-choice format. The application supports all JLPT levels (N1–N5), loads Kanji data dynamically from JSON files, and provides a mistake review session at the end of each quiz.

This project was built as part of a Java learning journey, deliberately applying software engineering principles including SOLID, OOP, and clean architecture patterns.

---

## Features

- **JLPT Level Selection** — practice Kanji from N5 through N1
- **Custom Session Length** — choose how many Kanji cards to study per session
- **Multiple Choice Quiz** — 4 randomized answer choices per card
- **Smart Answer Generation** — wrong choices are pulled from the same JLPT level, never duplicating the correct answer
- **Score Tracking** — correct and incorrect counts displayed at the end
- **Mistake Review** — full review of every incorrectly answered card with correct readings shown
- **Input Validation** — handles all invalid inputs gracefully

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17+ |
| Build Tool | Maven |
| JSON Parsing | Google GSON |
| IDE | IntelliJ IDEA |

---

## Project Structure

```
src/main/java/com/soemoe/kanjiflashcard/
├── Main.java                          # Entry point and quiz orchestrator
├── models/
│   ├── Flashcard.java                 # Abstract base class for all flashcard types
│   ├── KanjiCard.java                 # Kanji-specific flashcard model
│   └── Kanji.java                     # GSON data model for JSON deserialization
├── services/
│   ├── QuizService.java               # Core quiz logic — answer checking, scoring, deck management
│   ├── QuizUI.java                    # All user input and console output
│   └── KanjiDatabase.java             # Loads and provides Kanji data by JLPT level
├── contracts/
│   └── Reviewable.java                # Interface defining the quiz service contract
└── utils/
    ├── JsonLoader.java                # GSON-based JSON file loader
    └── ValidationUtils.java           # Shared input validation utilities

src/main/resources/
├── kanji_n1.json
├── kanji_n2.json
├── kanji_n3.json
├── kanji_n4.json
└── kanji_n5.json
```

---

## Getting Started

### Prerequisites
- Java 17 or above
- Maven

### Installation

1. Clone the repository
```bash
git clone https://github.com/SMAung165/Kanji-Flash-Card.git
cd Kanji-Flash-Card
```

2. Verify GSON dependency in `pom.xml`
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

3. Build and run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.soemoe.kanjiflashcard.Main"
```

Or simply open in IntelliJ IDEA and run `Main.java`.

---

## Usage

```
Select JLPT Level
-----------------
1. N5
2. N4
3. N3
4. N2
5. N1
> 2
Enter the number Kanji(s) you want to practice.
----------------------------------------------
> 3
----------------------------------------------
Kanji: 体
Meaning: body, counter for images, object, reality, substance
Card Number: 1
1. Kun: {とり}, On: {チョウ} 
2. Kun: {かたち, からだ}, On: {タイ, テイ} 
3. Kun: {むろ}, On: {シツ} 
4. Kun: {くろ, くろ.い, くろ.ずむ}, On: {コク} 
Your answer: 2
Your answer is correct!
```

---

## Architecture & Design Decisions

### Single Responsibility Principle
Each class has one clearly defined responsibility:
- `QuizService` — pure business logic only
- `QuizUI` — all console I/O only
- `Main` — orchestrates the two, owns the quiz loop
- `ValidationUtils` — shared validation logic

### Separation of UI and Logic
`QuizService` contains zero console output. All display logic lives in `QuizUI`. This makes the core logic reusable for future interfaces such as a desktop or Android application without modifying the service layer.

### Interface-Driven Design
`QuizService` implements `Reviewable`, defining a clear contract for quiz behavior. This allows alternative quiz implementations to be swapped in without changing `Main` or `QuizUI`.

### Abstract Flashcard Model
`Flashcard` serves as an abstract base class for all card types. `KanjiCard` extends it with Kanji-specific attributes. Future card types such as `VocabCard` or `GrammarCard` can be added without modifying existing code.

---

## Roadmap

- [ ] Android application with JavaFX or Android SDK UI
- [ ] Spaced Repetition System (SRS) for smarter card scheduling
- [ ] Persistent progress tracking with File I/O
- [ ] Meaning-based quiz mode in addition to reading-based
- [ ] Configurable number of answer choices

---

## Author

**Soe Moe** — Japanese Studies student, Van Lang University, Vietnam  
GitHub: [@SMAung165](https://github.com/SMAung165)

---

> Built as part of a Java learning journey toward employment in Japan.  
> Designed, architected, and implemented independently — no generated code.
