public class TranslatePizzaType {
    public static String fromPizzaTypeEnumToString(PizzaType theTypeofPizza) {
        switch (theTypeofPizza) {
            case CHEESE:
                return "Cheese";
            case GREEK:
                return "Greek";
            case PEPPERONI:
                return "Pepperoni";
            case GLUTEN_FREE:
                return "Gluten Free";
            case VEGAN:
                return "Vegan";
            default:
                return "Unknown";
        }
    }
}