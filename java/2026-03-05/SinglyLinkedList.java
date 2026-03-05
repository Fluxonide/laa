// P1: Create a SinglyLinkedList class and perform various linked list operation that stores number: 

// 1. Creating linked list
 
// 2. Add the node in the begining
 
// 3. Traverse the node in the linked list
 
// 4. Display the maximum number in the list.



import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

public class SinglyLinkedList {
    static Node head;

    static void addFirst(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
    }

    static void traverse() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }

    static void max() {
        Node t = head;
        int m = t.data;
        while (t != null) {
            if (t.data > m) m = t.data;
            t = t.next;
        }
        System.out.println("Max = " + m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1.Add  2.Traverse  3.Max  4.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter number: ");
                    addFirst(sc.nextInt());
                }
                case 2 -> traverse();
                case 3 -> max();
                case 4 -> System.out.println("Exit");
                default -> System.out.println("Invalid");
            }

        } while (ch != 4);
    }
}