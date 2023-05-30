import java.util.ArrayList;
import java.util.List;

/*
5. Order: A class that represents a customer order. It should have the following attributes and methods:
    * tableNumber (integer)
    * items (list of MenuItem objects)
    * addItem(item): Adds a menu item to the order.
    * removeItem(item): Removes a menu item from the order.
    * getItems(): Returns a list of all items in the order.
    * getTotal(): Returns the total cost of the order.
    * toString(): Returns a string representation of the order object in the format ""Table [table_number]:
    [list of menu item names] - Total: $[total]"".
 */
public class Order {

    private int tableNumber;

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<MenuItem> items = new ArrayList<>();


    public boolean addItem(MenuItem item) {
        return items.add(item);
    }

    public boolean removeItem(MenuItem item) {
        return items.remove(item);
    }

    public List getItems() {
        return items;
    }

    public double getTotal() {

        double total = 0;
        for (int i = 0; i < items.size(); i++) {

            total = total + items.get(i).getPrice();
        }
        return total;
    }

    public String toString() {
        return "Table " + getTableNumber() + ": " + getItems() + "\nTotal: $" + getTotal();
    }
}


