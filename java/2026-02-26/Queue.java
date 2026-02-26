/* P1: Create a Queue class and perform given operation:
 
a. To check queue is full or not.
 
b. To display the element of Queue.
 
c. To insert the element into Queue.
 
d. To remove element from the Queue.
 
P2: Write a program to demonstrate how static time and dynamic time polymorphism is achieved.
 
P3: Write a program to demonstrate the use of Abstract Class.
 */

class Queue {
    int arr[];
    int front, rear, size, capacity;

    Queue(int c) {
        capacity = c;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
        System.out.println(x + " inserted");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(arr[front] + " removed");
        front = (front + 1) % capacity;
        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Is Full? " + q.isFull());
    }
}