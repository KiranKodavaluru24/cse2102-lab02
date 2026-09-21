# Lab Report: Lab 2 - Pizza Factory

## 1. Objective

The objective of this lab was to implement the Factory Method design pattern in Java
by building a pizza factory capable of producing several types of pizza (Cheese, Greek,
Pepperoni, Gluten Free, and Vegan). Each pizza must implement `prepare()`, `bake()`,
`cut()`, and `box()`. The factory must be used from a `PizzaStore` class, and the
solution must illustrate the Liskov Substitution Principle. The project also required
JUnit4 unit tests, organized into separate source and test directories.

## 2. Design and Architecture

The solution is built around a `Pizza` interface, which defines the four required
behaviors (`prepare`, `bake`, `cut`, `box`). Five concrete classes implement this
interface: `CheesePizza`, `GreekPizza`, `PepperoniPizza`, `GlutenFreePizza`, and
`VeganPizza`. Each concrete class stores its own `PizzaType` (an enum with values
`CHEESE`, `GREEK`, `PEPPERONI`, `GLUTEN_FREE`, `VEGAN`) and prints pizza-specific
output for each method.

A `PizzaFactory` class centralizes creation logic: given a `PizzaType`, its
`pizzaOrder()` method returns the correct concrete `Pizza` implementation. A
`PizzaStore` class holds a `PizzaFactory` as a field and exposes an `orderPizza()`
method, which requests a pizza from the factory and drives it through its full
lifecycle (prepare, bake, cut, box).

The project is split into two directories, as required:
- `src/main/java/` - all source code
- `src/test/java/` - all JUnit4 test code

A `lib/` directory holds the external JUnit4 and Hamcrest jars needed to compile
and run the tests, since the project does not use a build tool such as Maven or
Gradle.

## 3. Notable Implementation Details

**Factory Method Pattern**: `PizzaFactory.pizzaOrder(PizzaType)` is the single
point of responsibility for deciding which concrete pizza class to instantiate.
This isolates the "which class to create" decision from the rest of the program,
so that adding a new pizza type only requires a new class and one new case
in the factory.

**Liskov Substitution Principle (LSP)**: Both `PizzaStore.orderPizza()` and the
JUnit tests interact with pizzas exclusively through the `Pizza` interface type,
never through the concrete subclasses. For example:

```java
Pizza pizza = factory.pizzaOrder(type);
pizza.prepare();
pizza.bake();
pizza.cut();
pizza.box();
```

This code works correctly regardless of which concrete `Pizza` implementation is
returned, which is the essence of LSP: any subtype can be substituted for its
parent type without altering the correctness of the program. The test
`testAllPizzasAreUsableAsPizzaInterface()` explicitly verifies this by looping
over every `PizzaType`, requesting a pizza, and calling all four interface
methods on it without ever referencing a concrete class.

## 4. Test Strategy and Edge Cases

Testing was done with JUnit4. The test suite (`PizzaFactoryTest.java`) covers:

- **Positive creation tests**: one test per pizza type, verifying the factory
  returns a non-null `Pizza` of the correct concrete class for each `PizzaType`.
- **LSP demonstration test**: iterates over all `PizzaType` values and confirms
  every returned pizza can be used purely through the `Pizza` interface without
  error.
- **Edge case - null input**: `testFactoryReturnsNullForInvalidType()` calls
  `factory.pizzaOrder(null)`. This test initially caught a real bug: Java's
  `switch` on an enum throws a `NullPointerException` when the switch value
  itself is `null`, before ever reaching the `default` case. The bug was fixed
  by adding an explicit `null` check at the start of `pizzaOrder()`, so the
  factory now degrades gracefully instead of crashing.
- **Integration test**: `testPizzaStoreOrdersPizzaSuccessfully()` verifies that
  `PizzaStore`, using a real `PizzaFactory`, can successfully order and process
  a pizza end-to-end.

All 8 tests pass after the null-handling fix.

## 5. Conclusion

This lab reinforced how the Factory Method pattern decouples object creation
from object use, and how the Liskov Substitution Principle allows client code
(here, `PizzaStore` and the test suite) to remain simple and unaware of which
concrete class it is working with. Writing an edge-case test for `null` input
proved valuable in practice, since it uncovered a real crash bug that the
"happy path" tests alone would not have caught. A possible extension of this
design would be to have `PizzaFactory` throw a custom checked exception for
invalid types rather than silently returning `null`, which could make failures
more explicit to callers.
**Prompt:** "ok now write the JUnit4"
**Result:** Set up `lib/` with JUnit4 and Hamcrest jars; wrote
`PizzaFactoryTest.java` with tests for each pizza type and an LSP
demonstration test; provided compile/run commands.

---
AI System: Claude (Anthropic)

Below are the prompts used throughout this project, in chronological order,
with a note on what each prompt produced.

**Prompt:** "Gave all my code and asked Claud for the JUnit4 "
**Result:** Set up `lib/` with JUnit4 and Hamcrest jars; wrote
`PizzaFactoryTest.java` with tests for each pizza type and an LSP
demonstration test; provided compile/run commands.

---

**Prompt:** [compiler errors from JUnit compilation attempts]
**Result:** Diagnosed and removed a broken stray `test.java` file that was
blocking compilation.

---

**Prompt:** "first is this code correct for PizzaFactory-" [pasted
PizzaFactoryTest.java]
**Result:** Confirmed the test file was correct and explained why, method by
method.

---

**Prompt:** "ok i pushed it to git"
**Result:** Verified git status/log; outlined remaining checklist items.

---

**Prompt:** "did that and asked git statuse and this is what i got-"
**Result:** Confirmed `.gitignore` update was staged correctly.

---

**Prompt:** [compile errors after adding edge-case tests]
**Result:** Diagnosed that the test file content had been overwritten
incorrectly; provided the full corrected file.

---

**Prompt:** [test output showing a NullPointerException failure]
**Result:** Diagnosed a real bug in `PizzaFactory.pizzaOrder()` (unhandled
null input crashing on the switch statement); provided the fix.

---

**Prompt:** "ok this is what i have in my read me file-" [pasted README content]
**Result:** Confirmed README completeness against lab requirements.

---

**Prompt:** "do i need to?" (regarding adding a folder-structure diagram to
the README)
**Result:** Confirmed it was optional, not required by the lab.

---

**Prompt:** "no just give me what all prompts i gave you and stuff"
**Result:** This file - a compiled list of all prompts used in the project.