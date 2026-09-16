public class GlutenFreePizza implements Pizza {

    private PizzaType pizzaType;

    public CheesePizza() {
        this.pizzaType = PizzaType.GLUTEN_FREE;
    }

    public void prepare(){
        System.out.println("Preparing a GLUTEN FREE " + TranslatePizzaType.fromPizzaTypeEnumToString(pizzaType));
    }

    public void bake(){
        System.out.println("Baking a GLUTEN FREE PIZZA");
    }

    public void cut() {
        System.out.println("Cutting the GLUTEN FREE PIZZA into slices");
    }

    public void box(){
        System.out.println("Boxing the GLUTEN FREE PIZZA");
    }
}