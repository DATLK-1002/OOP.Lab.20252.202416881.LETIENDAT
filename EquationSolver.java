import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String aStr = JOptionPane.showInputDialog("Enter a:");
        String bStr = JOptionPane.showInputDialog("Enter b:");
        String cStr = JOptionPane.showInputDialog("Enter c:");

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double c = Double.parseDouble(cStr);

        String result;

        if (a == 0) {
            if (b == 0) {
                result = (c == 0) ? "Infinite solutions" : "No solution";
            } else {
                double x = -c / b;
                result = "Linear solution x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Two solutions: x1 = " + x1 + ", x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Double root x = " + x;
            } else {
                result = "No real solution";
            }
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}