# TCSS 305 – Assignment 1B: Test-Driven Development

**UW Tacoma | Winter 2026**

## Assignment Instructions

Full instructions available at:
https://cfb3.github.io/TCSS305-GUIDES/assignments/a1b/

## Project Structure

```
lib/
└── tcss305-a1b-model.jar   (model classes to test against)

src/edu/uw/tcss/app/
└── StoreItemDemo.java      (demo showing model usage)

test/edu/uw/tcss/model/
├── ItemOrderTest.java      (provided example - study this!)
├── StoreItemTest.java      (create this)
├── StoreBulkItemTest.java  (create this)
└── StoreCartTest.java      (create this)

project root/
├── executive-summary.md    (your submission notes)
└── README.md               (this file)
```

## Getting Started

1. Study the provided `ItemOrderTest.java` for test structure and patterns
2. Read the API specifications in the assignment instructions
3. Create your test classes following TDD methodology

## Running Tests

1. Right-click on the `test` folder in IntelliJ
2. Select **Run 'All Tests'**
3. Or open individual test files and click the green play button

## What to Submit

- Your three test classes: `StoreItemTest`, `StoreBulkItemTest`, `StoreCartTest`
- Updated `executive-summary.md` with your bug reports (if any)