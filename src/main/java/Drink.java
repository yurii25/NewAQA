/*
4. Drink: A subclass of MenuItem that represents a drink. It should have the following attributes and methods:
    * size (string)
    * isRefillable (boolean)
    * getSize(): Returns the size of the drink.
    * isRefillable(): Returns whether the drink is refillable or not.
    * toString(): Returns a string representation of the drink object in the format ""[name] -
    $[price]: [description] ([size], Refillable: [True/False])"".
 */
public class Drink extends MenuItem {
    private double size;
    private boolean isRefillable;

    public void setSize(double size) {
        this.size = size;
    }

    public void setRefillable(boolean refillable) {
        isRefillable = refillable;
    }

    public double getSize() {
        return size;
    }

    public boolean isRefillable() {
        return isRefillable;
    }


    public String toString() {
        return "\n" +  getName() + " - " + "$" + getPrice() + ": \nDescription: " + getDescription() + "\nSize: " +
                (getSize() + ", Refillable: " + isRefillable);
    }


}
