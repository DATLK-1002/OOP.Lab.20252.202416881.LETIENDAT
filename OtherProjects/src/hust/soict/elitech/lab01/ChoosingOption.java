package hust.soict.elitech.lab01;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {

        Object[] options = {"I do", "I don't"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to change to the first class ticket?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        String result = (choice == 0) ? "I do" : "I don't";

        JOptionPane.showMessageDialog(null, "You've chosen: " + result);

        System.exit(0);
    }
}