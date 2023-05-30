/*
2. Appetizer: A subclass of MenuItem that represents an appetizer. It should have the following attributes and methods:
    * isSpicy (boolean)
    * getSpiciness(): Returns whether the appetizer is spicy or not.
    * toString(): Returns a string representation of the appetizer object in the format ""[name] - $[price]:
    [description] (Vegetarian: [True/False], Spicy: [True/False])"".
 */
public class Appetizer extends MenuItem {

    private boolean isSpicy;

    public boolean getSpiciness() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public String toString() {
        return "\n" + getName() + " - " + "$" + getPrice() + ": \nDescription: " + getDescription() +
                ("\nVegetarian: " + isVegetarian() + ", Spicy: " + getSpiciness());
    }
}