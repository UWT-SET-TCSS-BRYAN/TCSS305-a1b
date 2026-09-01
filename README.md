# TCSS 305 – Assignment 1B: Test-Driven Development

**UW Tacoma | Autumn 2026**

## Assignment Instructions

Full instructions available at:
https://cfb3.github.io/TCSS305-26-AUTUMN/assignments/a1b/

## Project Structure

```
a1b-<your-username>/
├── lib/                          ← Model library to test against
│   └── tcss305-a1b-model.jar
├── src/                          ← Source code
│   └── edu/uw/tcss/app/
│       └── StoreItemDemo.java        (demo showing model usage)
├── test/                         ← Unit tests
│   └── edu/uw/tcss/model/
│       ├── ItemOrderTest.java        (provided example - study this!)
│       ├── StoreItemTest.java        (create this)
│       ├── StoreBulkItemTest.java    (create this)
│       └── StoreCartTest.java        (create this)
├── docs/                         ← Generated API docs for the model library
├── .idea/                        ← Checkstyle + inspection rules (do not edit)
├── .gitignore                    ← Files Git should not track
├── LICENSE                       ← Course license
├── README.md                     ← Links to assignment on course site
└── executive-summary.md          ← Your submission notes
```

## API Documentation

The model classes you are testing are documented here:
https://uwt-set-tcss-bryan.github.io/TCSS305-a1b/edu/uw/tcss/model/package-summary.html

The same Javadoc is in this repository under `docs/` — open `docs/index.html` in a
browser to read it offline.

## Getting Started

1. Study the provided `ItemOrderTest.java` for test structure and patterns
2. Read the API specifications in the assignment instructions
3. Create your test classes following TDD methodology

## Running Tests

1. Right-click on the `test` folder in IntelliJ
2. Select **Run 'All Tests'**
3. Or open individual test files and click the green play button

The provided `ItemOrderTest` should pass as-is. Use it to confirm your project is set
up correctly before you start writing your own tests.

## What to Submit

- Your three test classes: `StoreItemTest`, `StoreBulkItemTest`, `StoreCartTest`
- Updated `executive-summary.md` with your bug reports (if any)
