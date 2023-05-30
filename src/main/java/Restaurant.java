import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
6. Restaurant: A class that represents a restaurant. It should have the following attributes and methods:
    * name (string)
    * tables (map where key is table number and value is Order object)
    * addOrder(tableNumber, order): Adds an order to a table.
    * removeOrder(tableNumber): Removes the order from a table.
    * getOrders(): Returns a dictionary of all orders in the restaurant.
    * toStringe(): Returns a string representation of the restaurant object in the format ""Restaurant: [name],
    Tables: [list of table numbers]"".
 */
public class Restaurant {

    private static String name;

    public static String getName() {
        return name;
    }


    Map<Integer, MenuItem> tables = new HashMap<>();


    public void addOrder(Integer tableNumber, MenuItem order) {
        tables.put(tableNumber, order);
    }

    public void removeOrder(Integer tableNumber) {
        tables.remove(tableNumber);
    }

    public void getOrders() {
        System.out.println(tables);
    }

    public String toString() {
        return "Restaurant: " + getName() + ", Tables: " + tables.get(tables);
    }

    // Create an instance of the Restaurant class and add a few orders with multiple items each.
    //Do the task in separate branch, create a PR and assign toleksyn as reviewer."

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        Order order1 = new Order();
        order1.setTableNumber(1);

        Appetizer salad = new Appetizer();
        salad.setName("CHICKEN SALAD");
        salad.setPrice(20);
        salad.setDescription("Chicken salad is any salad with chicken as a main ingredient.");
        salad.setVegetarian(false);
        salad.setSpicy(true);
        order1.addItem(salad);


        Entree garlicBread = new Entree();
        garlicBread.setName("GARLIC BREAD");
        garlicBread.setPrice(15);
        garlicBread.setDescription("Garlic bread consists of bread, topped with garlic and olive oil or butter and may " +
                "include additional herbs, such as oregano or chives.");
        garlicBread.setVegetarian(true);
        garlicBread.setGlutenFree(true);
        order1.addItem(garlicBread);

        Drink beer = new Drink();
        beer.setName("BUD LIGHT");
        beer.setPrice(10);
        beer.setDescription("Bud Light's crisp, smooth taste and delicate malt sweetness always provide endless " +
                "refreshment and superior drinkability.");
        beer.setSize(0.33);
        beer.setRefillable(false);
        order1.addItem(beer);

        Order order2 = new Order();
        order2.setTableNumber(2);

        Drink vine = new Drink();
        vine.setName("CHARDONNAY WINE");
        vine.setPrice(50);
        vine.setDescription("Chardonnay varies in flavor, depending on how ripe the grapes get, the flavor ranges from " +
                "citrus and green apple, to overripe peach and canned pineapple.");
        vine.setSize(0.5);
        vine.setRefillable(true);
        order2.addItem(vine);

        System.out.println(order1);

        System.out.println("");
        System.out.println("");

        System.out.println(order2);

        // придумав таку конструкцію, щоб вивести текст більш схожий на реальний рахунок:

//        System.out.println("Table 1:");
//        for(int i = 0; i < order1.items.size(); i++) {
//            System.out.println(i+1 + ". " + order1.items.get(i).getName() + " - $" + order1.items.get(i).getPrice());
//        }
//        System.out.println("Total: $" + order1.getTotal());
//
//        System.out.println("");
//        System.out.println("");
//
//        System.out.println("Table 2:");
//        for(int i = 0; i < order2.items.size(); i++) {
//            System.out.println(i+1 + ". " + order2.items.get(i).getName() + " - $" + order2.items.get(i).getPrice());
//        }
//        System.out.println("Total: $" + order2.getTotal());
    }
}
