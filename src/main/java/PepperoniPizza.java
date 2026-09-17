public class PepperoniPizza implements Pizza {

    private PizzaType pizzaType;

    public PepperoniPizza() {
        this.pizzaType = PizzaType.PEPPERONI;
    }

    public void prepare(){
        System.out.println("Preparing a PEPPERONI " + TranslatePizzaType.fromPizzaTypeEnumToString(pizzaType));
    }

    public void bake(){
        System.out.println("Baking a PEPPERONI PIZZA");
    }

    public void cut() {
        System.out.println("Cutting the PEPPERONI PIZZA into slices");
    }

    public void box(){
        System.out.println("Boxing the PEPPERONI PIZZA");
    }
}