package hust.soict.elitech.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an integer: "));
        tfInput = new TextField(10);
        tfInput.addActionListener(new InputListener());
        add(tfInput);

        add(new Label("The accumulated sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(400, 120);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int value = Integer.parseInt(tfInput.getText().trim());
                sum += value;
                tfOutput.setText(String.valueOf(sum));
                tfInput.setText("");
            } catch (NumberFormatException ex) {
                tfInput.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
