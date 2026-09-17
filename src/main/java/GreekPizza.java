public class GreekPizza implements Pizza {

    private PizzaType pizzaType;

    public GreekPizza() {
        this.pizzaType = PizzaType.GREEK;
    }

    public void prepare(){
        System.out.println("Preparing a GREEK " + TranslatePizzaType.fromPizzaTypeEnumToString(pizzaType));
    }

    public void bake(){
        System.out.println("Baking a GREEK PIZZA");
    }

    public void cut() {
        System.out.println("Cutting the GREEK PIZZA into slices");
    }

    public void box(){
        System.out.println("Boxing the GREEK PIZZA");
    }
}