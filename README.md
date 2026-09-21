# CSE 2102 - Lab 2: Pizza Factory

A Java implementation of the Factory Method design pattern, modeling a pizza store
that produces different types of pizzas (Cheese, Greek, Pepperoni, Gluten Free, Vegan)
through a central `PizzaFactory`.

## Requirements

- Java JDK 21 (or compatible)
- JUnit 4.13.2 and Hamcrest 1.3 (already included in `lib/`)

## Build

Compile all source and test files:

```bash
javac -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" -d out src/main/java/*.java src/test/java/*.java
```

## Run

Run the main program, which orders and processes one of every pizza type:

```bash
java -cp out PizzaStore
```

## Test

Run the JUnit4 test suite:

```bash
java -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore PizzaFactoryTest
```

Expected result: `OK (8 tests)`

## Design Notes

- **Factory Method pattern**: `PizzaFactory.pizzaOrder(PizzaType)` encapsulates the logic
  of deciding which concrete `Pizza` subclass to instantiate.
- **Liskov Substitution Principle**: `PizzaStore` and the test suite interact with pizzas
  exclusively through the `Pizza` interface, never a concrete subclass. Any `Pizza`
  implementation can be substituted without changing behavior.

See `LAB_REPORT.md` for full design discussion, test strategy, and AI usage disclosure.