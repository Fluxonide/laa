// P2. Write a program to demonstrate the use of some common method available in the String class.


import java.util.Scanner;

public class estring {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Length: " + s.length());
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Lowercase: " + s.toLowerCase());
        System.out.println("Character at index 0: " + s.charAt(0));
        System.out.println("Substring(0,3): " + s.substring(0,3));
        System.out.println("Replace a with x: " + s.replace('a','x'));
        System.out.println("Contains 'java': " + s.contains("java"));
    }
}