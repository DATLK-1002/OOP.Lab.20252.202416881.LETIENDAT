/**
 * Aims class - Main entry point for the AIMS (An Internet Media Store) application
 */
public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 19.95f);

        // Add DVDs to cart
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);
        cart.addDigitalVideoDisc(dvd4);

        // Print cart contents
        cart.printCart();

        // Search for a DVD by title
        System.out.println("\n--- Search by Title ---");
        DigitalVideoDisc found = cart.searchByTitle("Inception");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("DVD not found");
        }

        // Search for DVDs by category
        System.out.println("\n--- Search by Category ---");
        java.util.ArrayList<DigitalVideoDisc> animationDVDs = cart.searchByCategory("Animation");
        System.out.println("Animation DVDs found: " + animationDVDs.size());
        for (DigitalVideoDisc dvd : animationDVDs) {
            System.out.println("  - " + dvd.getTitle());
        }

        // Remove a DVD from cart
        System.out.println("\n--- Remove DVD ---");
        cart.removeDigitalVideoDisc(dvd2);

        // Print updated cart
        cart.printCart();
    }
}
