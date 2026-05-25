package hust.soict.elitech.aims.screen.manager;

import hust.soict.elitech.aims.media.CompactDisc;
import hust.soict.elitech.aims.media.Track;
import hust.soict.elitech.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfCost;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;
    private DefaultListModel<String> trackListModel;
    private java.util.List<Track> tracks = new java.util.ArrayList<>();

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen parentScreen) {
        super(store, parentScreen);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Compact Disc to Store");
        setSize(550, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel heading = new JLabel("Add Compact Disc", SwingConstants.CENTER);
        heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        center.add(heading, gbc);
        gbc.gridwidth = 1;

        tfTitle    = addRow(center, gbc, "Title:",    1);
        tfCategory = addRow(center, gbc, "Category:", 2);
        tfDirector = addRow(center, gbc, "Director:", 3);
        tfArtist   = addRow(center, gbc, "Artist:",   4);
        tfCost     = addRow(center, gbc, "Cost ($):", 5);

        // Track section
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 3;
        center.add(new JLabel("Tracks (optional):"), gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 7;
        center.add(new JLabel("Track Title:"), gbc);
        tfTrackTitle = new JTextField(15);
        gbc.gridx = 1;
        center.add(tfTrackTitle, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        center.add(new JLabel("Track Length (sec):"), gbc);
        tfTrackLength = new JTextField(5);
        gbc.gridx = 1;
        center.add(tfTrackLength, gbc);

        JButton btnAddTrack = new JButton("Add Track");
        gbc.gridx = 2; gbc.gridy = 7; gbc.gridheight = 2;
        center.add(btnAddTrack, gbc);
        gbc.gridheight = 1;

        trackListModel = new DefaultListModel<>();
        JList<String> trackList = new JList<>(trackListModel);
        JScrollPane scrollPane = new JScrollPane(trackList);
        scrollPane.setPreferredSize(new Dimension(300, 80));
        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 3;
        center.add(scrollPane, gbc);
        gbc.gridwidth = 1;

        btnAddTrack.addActionListener(e -> {
            String trackTitle = tfTrackTitle.getText().trim();
            if (trackTitle.isEmpty()) return;
            try {
                int len = Integer.parseInt(tfTrackLength.getText().trim());
                Track t = new Track(trackTitle, len);
                tracks.add(t);
                trackListModel.addElement(trackTitle + " (" + len + " sec)");
                tfTrackTitle.setText("");
                tfTrackLength.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid track length!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnAdd = new JButton("Add CD");
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 3;
        center.add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            try {
                String title    = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                String artist   = tfArtist.getText().trim();
                float cost      = Float.parseFloat(tfCost.getText().trim());

                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
                for (Track t : tracks) {
                    cd.addTrack(t);
                }
                store.addMedia(cd);
                JOptionPane.showMessageDialog(this, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

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
        gbc.gridx = 1; gbc.gridwidth = 2;
        panel.add(tf, gbc);
        gbc.gridwidth = 1;
        return tf;
    }
}
