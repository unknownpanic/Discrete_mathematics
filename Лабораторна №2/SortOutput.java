import java.util.Scanner;

public class SortOutput {
    public static void main(String[] args) {
        int[] array_default = {31, 2, 33, 47, 5, 9, 32, 91, 13};
        int[] arr;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ви бажаєте ввести свій масив?");
        System.out.println("1 - Так");
        System.out.println("2 - Ні, хай буде за замовчуванням");
        int choice_array = scanner.nextInt();

        if (choice_array == 1) {
            System.out.println("Скільки чисел ви хочете ввести?");
            int n = scanner.nextInt();
            arr = new int[n];

            System.out.println("Введіть " + n + " чисел:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("Ваш масив:");
            SortLibrary.show(arr);
        } else if (choice_array == 2) {
            arr = array_default;
            System.out.println("Початковий масив:");
            SortLibrary.show(arr);
        } else {
            System.out.println("Некоректний вибір.");
            return;
        }

        System.out.println("Оберіть метод сортування:");
        System.out.println("1 - Бульбашкою");
        System.out.println("2 - Вставкою");
        System.out.println("3 - Вибором");
        int choice = scanner.nextInt();

        System.out.println("Введіть початковий та кінцевий індекси сортування:");
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println("Бажаєте відсортувати масив у:");
        System.out.println("1 - Зворотньому порядку");
        System.out.println("2 - За зростанням");
        int option = scanner.nextInt();


        if (start < 0 || end >= arr.length || start > end) {
            System.out.println("Некоректні індекси!");
            return;
        }

        switch (choice) {
            case 1:
                SortLibrary.SortBubble(arr, start, end, option);
                break;
            case 2:
                SortLibrary.SortInsertion(arr, start, end, option);
                break;
            case 3:
                SortLibrary.SortSelection(arr, start, end, option);
                break;
            default:
                System.out.println("Неправильний вибір!");
                return;
        }

        System.out.println("Відсортований масив:");
        SortLibrary.show(arr);

        scanner.close();
    }
}
