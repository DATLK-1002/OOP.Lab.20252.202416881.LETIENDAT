package hust.soict.elitech.aims.screen.manager;

import hust.soict.elitech.aims.media.*;
import hust.soict.elitech.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel centerPanel;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);

        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            refreshCenter();
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD   = new JMenuItem("Add CD");
        JMenuItem addDVD  = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> {
            setVisible(false);
            new AddBookToStoreScreen(store, this);
        });
        addCD.addActionListener(e -> {
            setVisible(false);
            new AddCompactDiscToStoreScreen(store, this);
        });
        addDVD.addActionListener(e -> {
            setVisible(false);
            new AddDigitalVideoDiscToStoreScreen(store, this);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int count = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < count; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        // Fill remaining cells with empty panels if fewer than 9 items
        for (int i = count; i < 9; i++) {
            JPanel empty = new JPanel();
            empty.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            center.add(empty);
        }

        return center;
    }

    /**
     * Refreshes the center panel to reflect the current state of the store.
     * Called after adding a new media item.
     */
    public void refreshCenter() {
        Container cp = getContentPane();
        cp.remove(centerPanel);
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);
        cp.revalidate();
        cp.repaint();
    }

    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 22.50f);

        Book book1 = new Book("Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");
        Book book2 = new Book("The Pragmatic Programmer", "Technology", 35.00f);
        book2.addAuthor("Andrew Hunt");

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.99f);
        cd1.addTrack(new Track("Thriller", 358));
        cd1.addTrack(new Track("Billie Jean", 294));

        CompactDisc cd2 = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 18.50f);
        cd2.addTrack(new Track("Come Together", 259));
        cd2.addTrack(new Track("Something", 182));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        new StoreManagerScreen(store);
    }
}
