/*
3. Entree: A subclass of MenuItem that represents an entree. It should have the following attributes and methods:
    * isGlutenGree (boolean)
    * getGlutenFree(): Returns whether the entree is gluten-free or not.
    * toString(): Returns a string representation of the entree object in the format ""[name] - $[price]:
    [description] (Vegetarian: [True/False], Gluten-free: [True/False])"".
 */
public class Entree extends MenuItem {
    private boolean isGlutenFree;

    public boolean getGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public String toString() {
        return "\n" +  getName() + " - " + "$" + getPrice() + ": \nDescription: " + getDescription() +
                ("\nVegetarian: " + isVegetarian() + ", Gluten-free: " + getGlutenFree());
    }
}
