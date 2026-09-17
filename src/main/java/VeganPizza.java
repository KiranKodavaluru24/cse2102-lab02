public class VeganPizza implements Pizza {

    private PizzaType pizzaType;

    public VeganPizza() {
        this.pizzaType = PizzaType.VEGAN;
    }

    public void prepare(){
        System.out.println("Preparing a VEGAN " + TranslatePizzaType.fromPizzaTypeEnumToString(pizzaType));
    }

    public void bake(){
        System.out.println("Baking a VEGAN PIZZA");
    }

    public void cut() {
        System.out.println("Cutting the VEGAN PIZZA into slices");
    }

    public void box(){
        System.out.println("Boxing the VEGAN PIZZA");
    }
}