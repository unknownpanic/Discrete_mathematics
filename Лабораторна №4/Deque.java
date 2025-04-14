import java.util.Scanner;

public class Deque {
    private static class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = front;
        newNode.previous = null;
        if (front != null) {
            front.previous = newNode;
        }
        front = newNode;
        if (rear == null) {
            rear = newNode;
        }
    }

    public void addRear(int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        newNode.previous = rear;
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
    }

    public void delFront() {
        if (front == null) {
            throw new IllegalStateException("Deque is empty");
        }
        front = front.next;
        if (front != null) {
            front.previous = null;
        } else {
            rear = null;
        }
    }

    public void delRear() {
        if (rear == null) {
            throw new IllegalStateException("Deque is empty");
        }
        rear = rear.previous;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
    }

    public void show() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node search(int key) {
        Node current = front;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
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

    public void addMid(int key, int data) {
        Node pkey = search(key);
        if (pkey == null) {
            throw new IllegalStateException("Key not found");
        }
        if (pkey == rear) {
            addRear(data);
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
        if (pkey == front) {
            delFront();
        } else if (pkey == rear) {
            delRear();
        } else {
            pkey.previous.next = pkey.next;
            pkey.next.previous = pkey.previous;
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add to front");
            System.out.println("2. Add to rear");
            System.out.println("3. Delete from front");
            System.out.println("4. Delete from rear");
            System.out.println("5. Show");
            System.out.println("6. Check node");
            System.out.println("7. Exit");
            System.out.println("8. Add after key");
            System.out.println("9. Delete by key");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to add to front: ");
                        int value1 = scanner.nextInt();
                        deque.addFront(value1);
                        break;
                    case 2:
                        System.out.print("Enter value to add to rear: ");
                        int value2 = scanner.nextInt();
                        deque.addRear(value2);
                        break;
                    case 3:
                        deque.delFront();
                        System.out.println("Deleted from front");
                        break;
                    case 4:
                        deque.delRear();
                        System.out.println("Deleted from rear");
                        break;
                    case 5:
                        deque.show();
                        break;
                    case 6:
                        System.out.print("Enter key to check: ");
                        int key = scanner.nextInt();
                        deque.checkNode(key);
                        break;
                    case 7:
                        exit = true;
                        break;
                    case 8:
                        System.out.print("Enter key: ");
                        int key1 = scanner.nextInt();
                        System.out.print("Enter value to add after key: ");
                        int value3 = scanner.nextInt();
                        deque.addMid(key1, value3);
                        break;
                    case 9:
                        System.out.print("Enter key to delete: ");
                        int key2 = scanner.nextInt();
                        deque.delMid(key2);
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