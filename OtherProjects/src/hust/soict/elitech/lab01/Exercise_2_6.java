package hust.soict.elitech.lab01;
import java.util.Scanner;

public class Exercise_2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MENU =====");
        System.out.println("1. Solve first-degree equation (ax + b = 0)");
        System.out.println("2. Solve system of linear equations (2 variables)");
        System.out.println("3. Solve second-degree equation (ax^2 + bx + c = 0)");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(sc);
                break;

            case 2:
                solveLinearSystem(sc);
                break;

            case 3:
                solveQuadraticEquation(sc);
                break;

            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }

    // ========== 1. Linear equation ax + b = 0 ==========
    public static void solveLinearEquation(Scanner sc) {
        System.out.println("Solve ax + b = 0");
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0) System.out.println("Infinite solutions.");
            else System.out.println("No solution.");
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    // ========== 2. System of linear equations ==========
    public static void solveLinearSystem(Scanner sc) {
        System.out.println("Solve system:");
        System.out.println("a11*x1 + a12*x2 = b1");
        System.out.println("a21*x1 + a22*x2 = b2");

        System.out.print("a11 = "); double a11 = sc.nextDouble();
        System.out.print("a12 = "); double a12 = sc.nextDouble();
        System.out.print("b1 = "); double b1 = sc.nextDouble();
        System.out.print("a21 = "); double a21 = sc.nextDouble();
        System.out.print("a22 = "); double a22 = sc.nextDouble();
        System.out.print("b2 = "); double b2 = sc.nextDouble();

        double D  = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            System.out.println("Unique solution:");
            System.out.println("x1 = " + (D1 / D));
            System.out.println("x2 = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0)
                System.out.println("Infinite solutions.");
            else
                System.out.println("No solution.");
        }
    }

    // ========== 3. Quadratic equation ax^2 + bx + c = 0 ==========
    public static void solveQuadraticEquation(Scanner sc) {
        System.out.println("Solve ax^2 + bx + c = 0");

        System.out.print("a = "); double a = sc.nextDouble();
        System.out.print("b = "); double b = sc.nextDouble();
        System.out.print("c = "); double c = sc.nextDouble();

        if (a == 0) {
            // becomes linear equation
            System.out.println("a = 0 → becomes linear equation bx + c = 0");
            if (b == 0) {
                if (c == 0) System.out.println("Infinite solutions.");
                else System.out.println("No solution.");
            } else {
                System.out.println("x = " + (-c / b));
            }
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two solutions:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Double root: x = " + x);
        } else {
            System.out.println("No real root.");
        }
    }
}