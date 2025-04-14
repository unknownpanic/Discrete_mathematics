import java.util.LinkedList;

public class List {
    private LinkedList<String> stack;

    public List() {
        stack = new LinkedList<>();
    }

    public void push(String value) {
        stack.push(value);
    }

    public String pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public String peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}