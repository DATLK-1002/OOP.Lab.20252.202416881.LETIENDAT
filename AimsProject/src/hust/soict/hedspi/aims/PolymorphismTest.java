package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        Book book = new Book("Clean Code", "Technology", 29.99f);
        book.addAuthor("Robert C. Martin");
        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.99f);
        cd.addTrack(new Track("Thriller", 6));
        cd.addTrack(new Track("Billie Jean", 5));

        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        System.out.println("=== Polymorphism with toString() ===");
        for (Media m : mediaList) {
            // Depending on actual type, the corresponding toString() is called
            System.out.println(m.toString());
            System.out.println();
        }
        // Explanation: Even though we iterate over Media references,
        // Java calls the overridden toString() of each actual subclass at runtime.
        // This is runtime polymorphism (dynamic dispatch).
    }
}
