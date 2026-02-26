// P3: Write a program to demonstrate the use of Abstract Class.


 abstract class Smartphone {

     abstract void camera();
     abstract void battery();

    void brand() {
        System.out.println("This is a smartphone brand");
    }
}

class Samsung extends Smartphone {
    void camera() {
        System.out.println("Samsung has 108MP camera");
    }

    void battery() {
        System.out.println("Samsung has 5000mAh battery");
    }
}

class iPhone extends Smartphone {

    void camera() {
        System.out.println("iPhone has 48MP camera");
    }

    void battery() {
        System.out.println("iPhone has 4000mAh battery");
    }
}

public class Abstract {

    public static void main(String[] args) {

        Smartphone s1 = new Samsung();
        s1.brand();
        s1.camera();
        s1.battery();

        System.out.println();

        Smartphone s2 = new iPhone();
        s2.brand();
        s2.camera();
        s2.battery();
    
    }
}