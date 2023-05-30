/*
"Create a class hierarchy for a restaurant ordering system, with the following classes:
1. MenuItem: A base class that represents a menu item. It should have the following attributes and methods:
    * name (string)
    * price (float)
    * description (string)
    * isVegetarian (boolean)
    * getName(): Returns the name of the menu item.
    * getPrice(): Returns the price of the menu item.
    * getDescription(): Returns the description of the menu item.
    * isVegetarian(): Returns whether the menu item is vegetarian.
    * toString(): Returns a string representation of the menu item object in the format ""[name] - $[price]:
    * [description] (Vegetarian: [true/false])"".
 */
public class MenuItem {

    private String name;
    private float price;
    private String description;
    private boolean isVegetarian;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public String toString() {
        return getName() + " - " + "$" + getPrice() + " : " + getDescription() + ("Vegetarian: " + isVegetarian());
    }
}
