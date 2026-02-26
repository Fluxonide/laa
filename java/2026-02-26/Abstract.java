// P3: Write a program to demonstrate the use of Abstract Class.

abstract class Shape {

    abstract void draw();

    void message() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {

    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Abstract {
    public static void main(String[] args) {

        Shape s = new Circle();  
        s.message();             
        s.draw();               
    }
}