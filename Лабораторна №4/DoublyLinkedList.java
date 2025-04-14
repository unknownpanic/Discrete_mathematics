import java.util.Scanner;

public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;

    public void addBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = first;
        if (first != null) {
            first.previous = newNode;
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
    }

    public void addEnd(int data) {
        Node newNode = new Node(data);
        newNode.previous = last;
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
    }

    public void delBegin() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }
        first = first.next;
        if (first != null) {
            first.previous = null;
        } else {
            last = null;
        }
    }

    public void delEnd() {
        if (last == null) {
            throw new IllegalStateException("List is empty");
        }
        last = last.previous;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
    }

    public Node search(int key) {
        Node current = first;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addMid(int key, int data) {
        Node pkey = search(key);
        if (pkey == null) {
            throw new IllegalStateException("Key not found");
        }
        if (pkey == last) {
            addEnd(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = pkey.next;
            newNode.previous = pkey;
            pkey.next.previous = newNode;
            pkey.next = newNode;
        }
    }

    public void delMid(int key) {
        Node pkey = search(key);
        if (pkey == null) {
            throw new IllegalStateException("Key not found");
        }
        if (pkey == first) {
            delBegin();
        } else if (pkey == last) {
            delEnd();
        } else {
            pkey.previous.next = pkey.next;
            pkey.next.previous = pkey.previous;
        }
    }

    public void show() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void checkNode(int key) {
        Node node = search(key);
        if (node == null) {
            System.out.println("Node with key " + key + " not found.");
            return;
        }

        System.out.print("Node with key " + key + ": ");
        if (node.previous != null) {
            System.out.print("Previous key: " + node.previous.data + ", ");
        } else {
            System.out.print("Previous key: null, ");
        }

        if (node.next != null) {
            System.out.print("Next key: " + node.next.data);
        } else {
            System.out.print("Next key: null");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add to beginning");
            System.out.println("2. Add to end");
            System.out.println("3. Delete from beginning");
            System.out.println("4. Delete from end");
            System.out.println("5. Add after key");
            System.out.println("6. Delete by key");
            System.out.println("7. Show");
            System.out.println("8. Check");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to add to beginning: ");
                        int value1 = scanner.nextInt();
                        list.addBegin(value1);
                        break;
                    case 2:
                        System.out.print("Enter value to add to end: ");
                        int value2 = scanner.nextInt();
                        list.addEnd(value2);
                        break;
                    case 3:
                        list.delBegin();
                        System.out.println("Deleted from beginning");
                        break;
                    case 4:
                        list.delEnd();
                        System.out.println("Deleted from end");
                        break;
                    case 5:
                        System.out.print("Enter key: ");
                        int key1 = scanner.nextInt();
                        System.out.print("Enter value to add after key: ");
                        int value3 = scanner.nextInt();
                        list.addMid(key1, value3);
                        break;
                    case 6:
                        System.out.print("Enter key to delete: ");
                        int key2 = scanner.nextInt();
                        list.delMid(key2);
                        break;
                    case 7:
                        list.show();
                        break;
                    case 8:
                        System.out.print("Enter key to check: ");
                        int key3 = scanner.nextInt();
                        list.checkNode(key3);
                        break;
                    case 9:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}