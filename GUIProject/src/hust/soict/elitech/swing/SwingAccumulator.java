package hust.soict.elitech.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an integer: "));
        tfInput = new JTextField(10);
        tfInput.addActionListener(new InputListener());
        cp.add(tfInput);

        cp.add(new JLabel("The accumulated sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(400, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
        new SwingAccumulator();
    }
}
