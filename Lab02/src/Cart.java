import java.util.ArrayList;

/**
 * Cart class represents a shopping cart for DVDs
 */
public class Cart {
    private int qtyOrdered;
    private ArrayList<DigitalVideoDisc> items;

    /**
     * Constructor for Cart
     */
    public Cart() {
        this.qtyOrdered = 0;
        this.items = new ArrayList<DigitalVideoDisc>();
    }

    /**
     * Add a DVD to the cart
     */
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc != null && this.qtyOrdered < 20) {
            this.items.add(disc);
            this.qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added.");
        } else if (this.qtyOrdered >= 20) {
            System.out.println("The cart is full. Cannot add more DVDs.");
        } else {
            System.out.println("Invalid DVD. Cannot add to cart.");
        }
    }

    /**
     * Remove a DVD from the cart
     */
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.items.remove(disc)) {
            this.qtyOrdered--;
            System.out.println("The disc " + disc.getTitle() + " has been removed.");
        } else {
            System.out.println("The disc " + disc.getTitle() + " is not in the cart.");
        }
    }

    /**
     * Get the total cost of items in the cart
     */
    public float getTotalCost() {
        float total = 0.0f;
        for (DigitalVideoDisc disc : this.items) {
            total += disc.getCost();
        }
        return total;
    }

    /**
     * Get the quantity of items in the cart
     */
    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    /**
     * Get all items in the cart
     */
    public ArrayList<DigitalVideoDisc> getItems() {
        return this.items;
    }

    /**
     * Display cart contents
     */
    public void printCart() {
        System.out.println("***********************Cart***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.items.size(); i++) {
            DigitalVideoDisc disc = this.items.get(i);
            System.out.println((i + 1) + ". " + disc.getTitle() + " - $" + disc.getCost());
        }
        System.out.println("Total Cost: $" + this.getTotalCost());
        System.out.println("***************************************************");
    }

    /**
     * Search for a DVD by title
     */
    public DigitalVideoDisc searchByTitle(String title) {
        for (DigitalVideoDisc disc : this.items) {
            if (disc.getTitle().equalsIgnoreCase(title)) {
                return disc;
            }
        }
        return null;
    }

    /**
     * Search for DVDs by category
     */
    public ArrayList<DigitalVideoDisc> searchByCategory(String category) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<DigitalVideoDisc>();
        for (DigitalVideoDisc disc : this.items) {
            if (disc.getCategory().equalsIgnoreCase(category)) {
                result.add(disc);
            }
        }
        return result;
    }
}
