/* P1: Create a Queue class and perform given operation:
 
a. To check queue is full or not.
 
b. To display the element of Queue.
 
c. To insert the element into Queue.
 
d. To remove element from the Queue.
 
  */

import java.util.Scanner;

class Queue {
    int arr[], front, rear, size, capacity;

    Queue(int c) {
        capacity = c;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void insert(int x) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
        System.out.println("Inserted: " + x);
    }

    void remove() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.println("Removed: " + arr[front]);
        front = (front + 1) % capacity;
        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue capacity: ");
        int n = sc.nextInt();
        Queue q = new Queue(n);

        while (true) {
            System.out.println("\n1. Insert\n2. Remove\n3. Display\n4. Check Full\n5. Check Empty\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    q.insert(val);
                }
                case 2 -> q.remove();
                case 3 -> q.display();
                case 4 -> System.out.println("Full? " + q.isFull());
                case 5 -> System.out.println("Empty? " + q.isEmpty());
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}