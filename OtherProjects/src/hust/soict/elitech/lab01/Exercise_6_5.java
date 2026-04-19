package hust.soict.elitech.lab01;
import java.util.Scanner;
import java.util.Arrays;

public class Exercise_6_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers: ");
        String input = scanner.nextLine();

        // tách chuỗi thành mảng string
        String[] parts = input.trim().split("\\s+");

        // chuyển sang mảng số
        double[] arr = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Double.parseDouble(parts[i]);
        }

        // sort
        Arrays.sort(arr);

        // sum
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }

        double avg = sum / arr.length;

        System.out.println("Sorted: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);

        scanner.close();
    }
}