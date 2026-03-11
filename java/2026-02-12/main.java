/* 
Program 1: Create a Student class, which has given attributes and behaviours

Attributes:

name, instituteName, course, age, coursefee, scholarshipPer

Behaviour:

1. Getting student information

2. Change age

3. calculate the course fee paid after scholarship and return.

4. static method to change the institute name.

Create a non-parameterised, parameterised constructor and private constructor.

For the various operation for class create menu based application.

http://172.25.47.101/ecm/login.aspx

FOR user input:

Scanner input new Scanner(System.in);

String name input.nextLine();

int age input.nextInt();//for taking integer input
 */



import java.util.Scanner;

class Student {

    private String name;
    private static String instituteName = "SMIT";
    private String course;
    private int age;
    private double courseFee;
    private double scholarshipPer;

    // Non-parameterized constructor
    Student() {
        name = "Unknown";
        course = "Not Assigned";
        age = 0;
        courseFee = 0;
        scholarshipPer = 0;
    }

    // Parameterized constructor
    Student(String name, String course, int age, double courseFee, double scholarshipPer) {
        this.name = name;
        this.course = course;
        this.age = age;
        this.courseFee = courseFee;
        this.scholarshipPer = scholarshipPer;
    }

    // Private constructor
    private Student(String name) {
        this.name = name;
        this.course = "Not Assigned";
        this.age = 0;
        this.courseFee = 0;
        this.scholarshipPer = 0;
    }

    // Static method to use private constructor
    static Student createStudentWithName(String name) {
        return new Student(name);
    }

    void showDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Institute: " + instituteName);
        System.out.println("Course: " + course);
        System.out.println("Age: " + age);
        System.out.println("Fee: " + courseFee);
        System.out.println("Scholarship: " + scholarshipPer + "%");
    }

    void changeAge(int newAge) {
        age = newAge;
        System.out.println("Age changed.");
    }

    double finalFee() {
        return courseFee - (courseFee * scholarshipPer / 100);
    }

    static void changeInstitute(String newName) {
        instituteName = newName;
        System.out.println("Institute changed.");
    }

    static void showDetails(Student s) {
        if (s == null) System.out.println("No student yet.");
        else s.showDetails();
    }

    static void changeAge(Student s, int newAge) {
        if (s == null) System.out.println("No student yet.");
        else s.changeAge(newAge);
    }

    static void showFinalFee(Student s) {
        if (s == null) System.out.println("No student yet.");
        else System.out.printf("Final Fee: %,.2f\n", s.finalFee());
    }
}


public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student s = null;
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Create Student (Non-parameterized)");
            System.out.println("2. Create Student (Parameterized)");
            System.out.println("3. Create Student (Private constructor)");
            System.out.println("4. Show Details");
            System.out.println("5. Change Age");
            System.out.println("6. Calculate Final Fee");
            System.out.println("7. Change Institute");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {

                case 1 -> {
                    s = new Student();
                    System.out.println("Student created using non-parameterized constructor.");
                }

                case 2 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    System.out.print("Course Fee: ");
                    double fee = sc.nextDouble();

                    System.out.print("Scholarship %: ");
                    double scholarship = sc.nextDouble();
                    sc.nextLine(); 

                    s = new Student(name, course, age, fee, scholarship);
                    System.out.println("Student created using parameterized constructor.");
                }

                case 3 -> {
                    System.out.print("Name: ");
                    String privateName = sc.nextLine();
                    s = Student.createStudentWithName(privateName);
                    System.out.println("Student created using private constructor (via static method).");
                }

                case 4 -> Student.showDetails(s);

                case 5 -> {
                    System.out.print("New age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    Student.changeAge(s, newAge);
                }

                case 6 -> Student.showFinalFee(s);

                case 7 -> {
                    System.out.print("New Institute Name: ");
                    String newInst = sc.nextLine();
                    Student.changeInstitute(newInst);
                }

                case 8 -> System.out.println("Program ended.");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
