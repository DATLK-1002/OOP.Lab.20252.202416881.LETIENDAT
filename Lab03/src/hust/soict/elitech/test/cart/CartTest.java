package hust.soict.elitech.test.cart;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.*;

import java.util.ArrayList;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 121, 29.95f);
        Book book1 = new Book("Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.99f);
        cd1.addTrack(new Track("Thriller", 6));
        cd1.addTrack(new Track("Billie Jean", 5));

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(cd1);
        cart.addMedia(dvd1);

        cart.print();

        System.out.println("\n--- Search by ID ---");
        Media found = cart.searchById(dvd2.getId());
        if (found != null) System.out.println("Found: " + found.toString());

        System.out.println("\n--- Search by Title 'Sci' ---");
        ArrayList<Media> results = cart.searchByTitle("Sci");
        for (Media m : results) System.out.println(m.toString());

        System.out.println("\n--- Sort by Title ---");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("\n--- Sort by Cost ---");
        cart.sortByCostTitle();
        cart.print();

        System.out.println("\n--- Remove DVD ---");
        cart.removeMedia(dvd3);
        cart.print();
    }
}
