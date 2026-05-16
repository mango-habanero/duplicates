# Duplicate Finder

A lightweight Java utility that identifies duplicate values in an integer array.

## Requirements

- Java 21
- Maven 3.x

## Running the Program

```bash
mvn compile exec:java -Dexec.mainClass="com.mango.habanero.Main"
```

## Running the Tests

```bash
mvn test
```

## Approach

A single pass over the input using two `LinkedHashSet`s — one to track seen values, one to collect duplicates. Insertion order is preserved, producing deterministic output. Time complexity is O(n).