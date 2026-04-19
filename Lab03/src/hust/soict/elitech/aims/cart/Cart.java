package hust.soict.elitech.aims.cart;

import hust.soict.elitech.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("Media " + media.getTitle() + " is already in cart!");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart!");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) return m;
        }
        System.out.println("No media found with id: " + id);
        return null;
    }

    public ArrayList<Media> searchByTitle(String title) {
        ArrayList<Media> result = new ArrayList<Media>();
        for (Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(m);
            }
        }
        if (result.isEmpty()) System.out.println("No media found with title: " + title);
        return result;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public ArrayList<Media> getItemsOrdered() { return itemsOrdered; }
}
