import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите x: ");
        double x = sc.nextDouble();

        System.out.print("Введите a: ");
        double a = sc.nextDouble();

        double y1 = firstFunction(x);
        double y2 = secondFunction(x, a);

        System.out.printf("y1 = %.6f%n", y1);
        System.out.printf("y2 = %.6f%n", y2);
    }

    // y1 = (x-2)(x-4)...(x-64) / ((x-1)(x-3)...(x-63))
    private static double firstFunction(double x) {
        double numerator = 1.0;
        for (int i = 2; i <= 64; i += 2) {
            numerator *= x - i;
        }

        double denominator = 1.0;
        for (int i = 1; i <= 63; i += 2) {
            denominator *= x - i;
        }

        return numerator / denominator;
    }

    // y2 = (((((x-a)x-a)x-a)x-a)x-a)x-a
    private static double secondFunction(double x, double a) {
        double y = x - a;
        for (int i = 0; i < 5; i++) {
            y = y * x - a;
        }
        return y;
    }
}