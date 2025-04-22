import java.util.Stack;

public class Converter {

    public static double evaluatePostfix(String postfix, char[] variables, double[] values) {
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = findVariableIndex(c, variables);
                if (index != -1) {
                    stack.push(values[index]);
                } else {
                    throw new IllegalArgumentException("Не задано значення для змінної: " + c);
                }
            } else if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (c) {
                    case '+': stack.push(operand1 + operand2); break;
                    case '-': stack.push(operand1 - operand2); break;
                    case '*': stack.push(operand1 * operand2); break;
                    case '/': stack.push(operand1 / operand2); break;
                    default: throw new IllegalArgumentException("Невідомий оператор: " + c);
                }
            }
        }

        return stack.pop();
    }

    public static double evaluatePrefix(String prefix, char[] variables, double[] values) {
        Stack<Double> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (Character.isLetter(c)) {
                int index = findVariableIndex(c, variables);
                if (index != -1) {
                    stack.push(values[index]);
                } else {
                    throw new IllegalArgumentException("Не задано значення для змінної: " + c);
                }
            } else if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                switch (c) {
                    case '+': stack.push(operand1 + operand2); break;
                    case '-': stack.push(operand1 - operand2); break;
                    case '*': stack.push(operand1 * operand2); break;
                    case '/': stack.push(operand1 / operand2); break;
                    default: throw new IllegalArgumentException("Невідомий оператор: " + c);
                }
            }
        }

        return stack.pop();
    }

    private static int findVariableIndex(char variable, char[] variables) {
        for (int i = 0; i < variables.length; i++) {
            if (variables[i] == variable) {
                return i;
            }
        }
        return -1;
    }

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static String infixToPrefix(String infix) {
        StringBuilder reversed = new StringBuilder(infix).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        String postfix = infixToPostfix(reversed.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression);
            }
        }

        return stack.peek();
    }

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression);
            }
        }

        return stack.peek();
    }

    private static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}