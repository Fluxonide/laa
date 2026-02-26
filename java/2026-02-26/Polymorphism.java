// P2: Write a program to demonstrate how static time and dynamic time polymorphism is achieved.



class Calculator {
    double multiply(double a, double b) {
        return a * b;
    }

    double multiply(double a, double b, double c) {
        return a * b * c;
    }
}

class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with key");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println("Multiplication of two numbers: " + calc.multiply(4, 5));
        System.out.println("Multiplication of three numbers: " + calc.multiply(2, 3, 4));

        Vehicle v = new Car();   
        v.start();               
    }
}