import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Інфіксна -> Постфіксна");
            System.out.println("2. Інфіксна -> Префіксна");
            System.out.println("3. Постфіксна -> Інфіксна");
            System.out.println("4. Префіксна -> Інфіксна");
            System.out.println("5. Обчислити постфіксну форму");
            System.out.println("6. Обчислити префіксну форму");
            System.out.println("7. Вихід");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть інфіксну форму: ");
                    String infix = scanner.nextLine();
                    System.out.println("Постфіксна форма: " + Converter.infixToPostfix(infix));
                    break;
                case 2:
                    System.out.print("Введіть інфіксну форму: ");
                    infix = scanner.nextLine();
                    System.out.println("Префіксна форма: " + Converter.infixToPrefix(infix));
                    break;
                case 3:
                    System.out.print("Введіть постфіксну форму: ");
                    String postfix = scanner.nextLine();
                    System.out.println("Інфіксна форма: " + Converter.postfixToInfix(postfix));
                    break;
                case 4:
                    System.out.print("Введіть префіксну форму: ");
                    String prefix = scanner.nextLine();
                    System.out.println("Інфіксна форма: " + Converter.prefixToInfix(prefix));
                    break;
                case 5:
                    System.out.print("Введіть постфіксну форму: ");
                    postfix = scanner.nextLine();
                    System.out.println("Результат: " + Converter.evaluatePostfix(postfix));
                    break;
                case 6:
                    System.out.print("Введіть префіксну форму: ");
                    prefix = scanner.nextLine();
                    System.out.println("Результат: " + Converter.evaluatePrefix(prefix));
                    break;
                case 7:
                    System.out.println("Вихід...");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}