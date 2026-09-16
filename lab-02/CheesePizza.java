public class CheesePizza implements Pizza {

    private PizzaType pizzaType;

    public CheesePizza() {
        this.pizzaType = PizzaType.CHEESE;
    }

    public void prepare(){
        System.out.println("Preparing a CHEESE " + TranslatePizzaType.fromPizzaTypeEnumToString(pizzaType));
    }

    public void bake(){
        System.out.println("Baking a CHEESE PIZZA");
    }

    public void cut() {
        System.out.println("Cutting the CHEESE PIZZA into slices");
    }

    public void box(){
        System.out.println("Boxing the CHEESE PIZZA");
    }
}