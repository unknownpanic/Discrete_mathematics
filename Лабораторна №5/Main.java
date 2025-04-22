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
                case 1 -> {
                    System.out.print("Введіть інфіксну форму: ");
                    String infix = scanner.nextLine();
                    System.out.println("Постфіксна форма: " + Converter.infixToPostfix(infix));
                }
                case 2 -> {
                    System.out.print("Введіть інфіксну форму: ");
                    String infix = scanner.nextLine();
                    System.out.println("Префіксна форма: " + Converter.infixToPrefix(infix));
                }
                case 3 -> {
                    System.out.print("Введіть постфіксну форму: ");
                    String postfix = scanner.nextLine();
                    System.out.println("Інфіксна форма: " + Converter.postfixToInfix(postfix));
                }
                case 4 -> {
                    System.out.print("Введіть префіксну форму: ");
                    String prefix = scanner.nextLine();
                    System.out.println("Інфіксна форма: " + Converter.prefixToInfix(prefix));
                }
                case 5 -> {
                    System.out.print("Введіть постфіксну форму: ");
                    String postfix = scanner.nextLine();
                    String variables = extractVariables(postfix);
                    char[] variableArray = variables.toCharArray();
                    double[] values = new double[variableArray.length];

                    for (int i = 0; i < variableArray.length; i++) {
                        System.out.print("Введіть значення для " + variableArray[i] + ": ");
                        values[i] = scanner.nextDouble();
                    }

                    System.out.println("Результат: " + Converter.evaluatePostfix(postfix, variableArray, values));
                }
                case 6 -> {
                    System.out.print("Введіть префіксну форму: ");
                    String prefix = scanner.nextLine();
                    String variables = extractVariables(prefix);
                    char[] variableArray = variables.toCharArray();
                    double[] values = new double[variableArray.length];

                    for (int i = 0; i < variableArray.length; i++) {
                        System.out.print("Введіть значення для " + variableArray[i] + ": ");
                        values[i] = scanner.nextDouble();
                    }

                    System.out.println("Результат: " + Converter.evaluatePrefix(prefix, variableArray, values));
                }
                case 7 -> {
                    System.out.println("Вихід...");
                    return;
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static String extractVariables(String expression) {
        StringBuilder uniqueVariables = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c) && uniqueVariables.indexOf(String.valueOf(c)) == -1) {
                uniqueVariables.append(c);
            }
        }
        return uniqueVariables.toString();
    }
}