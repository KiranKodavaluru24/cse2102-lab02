import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaFactoryTest {

    private PizzaFactory factory = new PizzaFactory();

    @Test
    public void testCheesePizzaCreation() {
        Pizza pizza = factory.pizzaOrder(PizzaType.CHEESE);
        assertNotNull("Cheese pizza should not be null", pizza);
        assertTrue("Should be an instance of CheesePizza", pizza instanceof CheesePizza);
    }

    @Test
    public void testGreekPizzaCreation() {
        Pizza pizza = factory.pizzaOrder(PizzaType.GREEK);
        assertNotNull("Greek pizza should not be null", pizza);
        assertTrue("Should be an instance of GreekPizza", pizza instanceof GreekPizza);
    }

    @Test
    public void testPepperoniPizzaCreation() {
        Pizza pizza = factory.pizzaOrder(PizzaType.PEPPERONI);
        assertNotNull("Pepperoni pizza should not be null", pizza);
        assertTrue("Should be an instance of PepperoniPizza", pizza instanceof PepperoniPizza);
    }

    @Test
    public void testGlutenFreePizzaCreation() {
        Pizza pizza = factory.pizzaOrder(PizzaType.GLUTEN_FREE);
        assertNotNull("Gluten free pizza should not be null", pizza);
        assertTrue("Should be an instance of GlutenFreePizza", pizza instanceof GlutenFreePizza);
    }

    @Test
    public void testVeganPizzaCreation() {
        Pizza pizza = factory.pizzaOrder(PizzaType.VEGAN);
        assertNotNull("Vegan pizza should not be null", pizza);
        assertTrue("Should be an instance of VeganPizza", pizza instanceof VeganPizza);
    }

    @Test
    public void testAllPizzasAreUsableAsPizzaInterface() {
        // This test illustrates the Liskov Substitution Principle:
        // every concrete pizza returned by the factory can be treated
        // purely as a Pizza, and every method call succeeds without error,
        // regardless of which concrete subclass was actually returned.
        for (PizzaType type : PizzaType.values()) {
            Pizza pizza = factory.pizzaOrder(type);
            assertNotNull("Pizza should not be null for type " + type, pizza);

            // These calls must not throw for ANY subclass - that's LSP.
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }

    @Test
    public void testFactoryReturnsNullForInvalidType() {
        // Edge case: if the factory is ever called with a null type,
        // it should not throw an exception, but degrade gracefully.
        Pizza pizza = factory.pizzaOrder(null);
        assertNull("Factory should return null for a null PizzaType", pizza);
    }

    @Test
    public void testPizzaStoreOrdersPizzaSuccessfully() {
        // Integration test: PizzaStore should successfully use the
        // factory to produce and process a pizza end-to-end.
        PizzaStore store = new PizzaStore(factory);
        Pizza pizza = store.orderPizza(PizzaType.CHEESE);
        assertNotNull("PizzaStore should successfully order a pizza", pizza);
        assertTrue("Ordered pizza should be a CheesePizza", pizza instanceof CheesePizza);
    }
}