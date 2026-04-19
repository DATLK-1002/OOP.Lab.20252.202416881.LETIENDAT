package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate store with sample data
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        Book book1 = new Book("Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.99f);
        cd1.addTrack(new Track("Thriller", 6));
        cd1.addTrack(new Track("Billie Jean", 5));
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt();
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCart(); break;
                case 0: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void viewStore() {
        store.print();
        boolean inStore = true;
        while (inStore) {
            storeMenu();
            int choice = readInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine().trim();
                    Media found = findInStore(title);
                    if (found != null) {
                        System.out.println(found.toString());
                        mediaDetailsMenu();
                        int opt = readInt();
                        if (opt == 1) cart.addMedia(found);
                        else if (opt == 2) {
                            if (found instanceof Playable) ((Playable) found).play();
                            else System.out.println("This media cannot be played");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter media title to add to cart: ");
                    String title = scanner.nextLine().trim();
                    Media found = findInStore(title);
                    if (found != null) {
                        cart.addMedia(found);
                        System.out.println("Cart now has " + cart.getItemsOrdered().size() + " item(s)");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter media title to play: ");
                    String title = scanner.nextLine().trim();
                    Media found = findInStore(title);
                    if (found instanceof Playable) ((Playable) found).play();
                    else if (found != null) System.out.println("This media cannot be played");
                    break;
                }
                case 4: seeCart(); break;
                case 0: inStore = false; break;
                default: System.out.println("Invalid option");
            }
        }
    }

    private static void updateStore() {
        System.out.println("1. Add media  2. Remove media");
        System.out.print("Choose: ");
        int opt = readInt();
        if (opt == 1) {
            System.out.println("1. DVD  2. Book  3. CD");
            System.out.print("Type: ");
            int type = readInt();
            if (type == 1) {
                System.out.print("Title: "); String t = scanner.nextLine().trim();
                System.out.print("Category: "); String c = scanner.nextLine().trim();
                System.out.print("Director: "); String d = scanner.nextLine().trim();
                System.out.print("Length: "); int l = readInt();
                System.out.print("Cost: "); float cost = readFloat();
                store.addMedia(new DigitalVideoDisc(t, c, d, l, cost));
            } else if (type == 2) {
                System.out.print("Title: "); String t = scanner.nextLine().trim();
                System.out.print("Category: "); String c = scanner.nextLine().trim();
                System.out.print("Cost: "); float cost = readFloat();
                store.addMedia(new Book(t, c, cost));
            } else if (type == 3) {
                System.out.print("Title: "); String t = scanner.nextLine().trim();
                System.out.print("Category: "); String c = scanner.nextLine().trim();
                System.out.print("Artist: "); String a = scanner.nextLine().trim();
                System.out.print("Director: "); String d = scanner.nextLine().trim();
                System.out.print("Cost: "); float cost = readFloat();
                store.addMedia(new CompactDisc(t, c, d, a, cost));
            }
        } else if (opt == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine().trim();
            Media found = findInStore(title);
            if (found != null) store.removeMedia(found);
        }
    }

    private static void seeCart() {
        cart.print();
        boolean inCart = true;
        while (inCart) {
            cartMenu();
            int choice = readInt();
            switch (choice) {
                case 1: {
                    System.out.println("Filter by: 1. ID  2. Title");
                    int opt = readInt();
                    if (opt == 1) {
                        System.out.print("Enter ID: ");
                        int id = readInt();
                        Media m = cart.searchById(id);
                        if (m != null) System.out.println(m.toString());
                    } else {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine().trim();
                        ArrayList<Media> results = cart.searchByTitle(title);
                        for (Media m : results) System.out.println(m.toString());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Sort by: 1. Title  2. Cost");
                    int opt = readInt();
                    if (opt == 1) cart.sortByTitleCost();
                    else cart.sortByCostTitle();
                    cart.print();
                    break;
                }
                case 3: {
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine().trim();
                    ArrayList<Media> results = cart.searchByTitle(title);
                    if (!results.isEmpty()) cart.removeMedia(results.get(0));
                    break;
                }
                case 4: {
                    System.out.print("Enter title to play: ");
                    String title = scanner.nextLine().trim();
                    ArrayList<Media> results = cart.searchByTitle(title);
                    if (!results.isEmpty()) {
                        Media m = results.get(0);
                        if (m instanceof Playable) ((Playable) m).play();
                        else System.out.println("This media cannot be played");
                    }
                    break;
                }
                case 5:
                    System.out.println("Order placed! Cart is now empty.");
                    cart.getItemsOrdered().clear();
                    inCart = false;
                    break;
                case 0: inCart = false; break;
                default: System.out.println("Invalid option");
            }
        }
    }

    private static Media findInStore(String title) {
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) return m;
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    private static int readInt() {
        try {
            String line = scanner.nextLine().trim();
            return Integer.parseInt(line);
        } catch (Exception e) {
            return -1;
        }
    }

    private static float readFloat() {
        try {
            String line = scanner.nextLine().trim();
            return Float.parseFloat(line);
        } catch (Exception e) {
            return 0f;
        }
    }
}
