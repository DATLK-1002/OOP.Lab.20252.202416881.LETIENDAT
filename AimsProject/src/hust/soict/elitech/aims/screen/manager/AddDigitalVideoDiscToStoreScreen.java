package hust.soict.elitech.aims.screen.manager;

import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen parentScreen) {
        super(store, parentScreen);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add DVD to Store");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel heading = new JLabel("Add Digital Video Disc", SwingConstants.CENTER);
        heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        center.add(heading, gbc);
        gbc.gridwidth = 1;

        tfTitle    = addRow(center, gbc, "Title:",    1);
        tfCategory = addRow(center, gbc, "Category:", 2);
        tfDirector = addRow(center, gbc, "Director:", 3);
        tfLength   = addRow(center, gbc, "Length (min):", 4);
        tfCost     = addRow(center, gbc, "Cost ($):", 5);

        JButton btnAdd = new JButton("Add DVD");
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        center.add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            try {
                String title    = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length      = Integer.parseInt(tfLength.getText().trim());
                float cost      = Float.parseFloat(tfCost.getText().trim());

                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(this, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Refresh parent store screen and go back
                dispose();
                parentScreen.refreshCenter();
                parentScreen.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
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
