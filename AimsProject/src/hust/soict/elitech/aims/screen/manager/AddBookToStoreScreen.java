package hust.soict.elitech.aims.screen.manager;

import hust.soict.elitech.aims.media.Book;
import hust.soict.elitech.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfAuthors;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store, StoreManagerScreen parentScreen) {
        super(store, parentScreen);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Book to Store");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel heading = new JLabel("Add Book", SwingConstants.CENTER);
        heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        center.add(heading, gbc);
        gbc.gridwidth = 1;

        tfTitle    = addRow(center, gbc, "Title:",    1);
        tfCategory = addRow(center, gbc, "Category:", 2);
        tfAuthors  = addRow(center, gbc, "Authors (comma-separated):", 3);
        tfCost     = addRow(center, gbc, "Cost ($):", 4);

        JButton btnAdd = new JButton("Add Book");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        center.add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            try {
                String title    = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String authors  = tfAuthors.getText().trim();
                float cost      = Float.parseFloat(tfCost.getText().trim());

                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Book book = new Book(title, category, cost);
                if (!authors.isEmpty()) {
                    for (String author : authors.split(",")) {
                        book.addAuthor(author.trim());
                    }
                }
                store.addMedia(book);
                JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                parentScreen.refreshCenter();
                parentScreen.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return center;
    }

    private JTextField addRow(JPanel panel, GridBagConstraints gbc, String labelText, int row) {
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel(labelText), gbc);
        JTextField tf = new JTextField(20);
        gbc.gridx = 1;
        panel.add(tf, gbc);
        return tf;
    }
}
