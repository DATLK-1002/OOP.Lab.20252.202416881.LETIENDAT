import javax.swing.JOptionPane;

public class Exercise_2_5 {
    public static void main(String[] args) {

        // Nhập 2 số từ hộp thoại
        String strNum1 = JOptionPane.showInputDialog(null, "Nhập số thứ nhất:");
        String strNum2 = JOptionPane.showInputDialog(null, "Nhập số thứ hai:");

        // Convert String -> double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Tính toán
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;

        String quotient;
        if (num2 == 0) {
            quotient = "Không thể chia cho 0";
        } else {
            quotient = String.valueOf(num1 / num2);
        }

        // Hiển thị kết quả
        String message =
            "Tổng = " + sum +
            "\nHiệu = " + diff +
            "\nTích = " + prod +
            "\nThương = " + quotient;

        JOptionPane.showMessageDialog(null, message);
    }
}