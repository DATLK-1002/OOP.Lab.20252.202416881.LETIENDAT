package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName + " already exists!");
        } else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author " + authorName + " not found!");
        } else {
            authors.remove(authorName);
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory()
                + " - " + authors.toString() + ": " + getCost() + " $";
    }
}
