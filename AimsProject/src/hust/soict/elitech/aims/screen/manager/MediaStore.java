package hust.soict.elitech.aims.screen.manager;

import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing: " + media.getTitle());
                    dialog.setSize(350, 150);
                    dialog.setLocationRelativeTo(null);
                    dialog.setModal(true);

                    JPanel panel = new JPanel(new BorderLayout(10, 10));
                    String info;
                    if (media instanceof hust.soict.elitech.aims.media.Disc) {
                        info = "<html><center>Now playing: <b>" + media.getTitle() + "</b><br/>"
                            + "Length: " + ((hust.soict.elitech.aims.media.Disc) media).getLength() + " min</center></html>";
                    } else {
                        info = "<html><center>Now playing: <b>" + media.getTitle() + "</b></center></html>";
                    }
                    JLabel msg = new JLabel(info, SwingConstants.CENTER);
                    JButton closeBtn = new JButton("Close");
                    closeBtn.addActionListener(ev -> dialog.dispose());

                    panel.add(msg, BorderLayout.CENTER);
                    panel.add(closeBtn, BorderLayout.SOUTH);
                    dialog.add(panel);
                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
