package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.*;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        Book book1 = new Book("Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");

        // Test addMedia
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(dvd1); // duplicate test

        store.print();

        // Test removeMedia
        System.out.println("\n--- Remove DVD ---");
        store.removeMedia(dvd2);
        store.print();
    }
}
