public class PizzaStore {

    private PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = factory.pizzaOrder(type);

        if (pizza == null) {
            System.out.println("Sorry, we don't make that pizza.");
            return null;
        }

        // LSP in action
        // breaking this code.
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        for (PizzaType type : PizzaType.values()) {
            System.out.println("--- Ordering a " + TranslatePizzaType.fromPizzaTypeEnumToString(type) + " pizza ---");
            store.orderPizza(type);
            System.out.println();
        }
    }
}