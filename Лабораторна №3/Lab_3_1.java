import java.util.Arrays;
import java.util.Scanner;

public class Lab_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Частина 1: Обчислення кількості розміщень та сполучень
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();

        System.out.print("Введіть k: ");
        int k = scanner.nextInt();

        System.out.println("Факторіал " + n + "! = " + Comb.factorial(n));
        System.out.println("Розміщення без повторень A(" + n + ", " + k + ") = " + Comb.A(n, k));
        System.out.println("Розміщення з повтореннями A_repeated(" + n + ", " + k + ") = " + Comb.A_repeated(n, k));
        System.out.println("Сполучення без повторень C(" + n + ", " + k + ") = " + Comb.C(n, k));
        System.out.println("Сполучення з повтореннями C_repeated(" + n + ", " + k + ") = " + Comb.C_repeated(n, k));

        // Частина 2: Генерування перестановок
        System.out.print("Введіть кількість елементів для перестановок: ");
        n = scanner.nextInt();
        int[] A = new int[n];

        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.print("Введіть k: ");
        k = scanner.nextInt();

        Arrays.sort(A);

        System.out.println("Всі перестановки:");
        do {
            System.out.println(Arrays.toString(Arrays.copyOfRange(A, 0, k)));
        } while (Comb.GenPerm(A, k));

        // Частина 3: Генерування сполучень
        System.out.print("Введіть n для сполучень: ");
        n = scanner.nextInt();

        System.out.print("Введіть k для сполучень: ");
        k = scanner.nextInt();

        int[] combArray = new int[k];
        for (int i = 0; i < k; i++) {
            combArray[i] = i + 1;
        }

        System.out.println("Всі сполучення:");
        do {
            System.out.println(Arrays.toString(combArray));
        } while (Comb.GenComb(combArray, n, k));

        scanner.close();
    }
}