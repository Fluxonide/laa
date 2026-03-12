// wap in java to extract vowel from the given word

import java.util.Scanner;

public class VowelExtract {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("give a word.: ");
        String word = sc.nextLine();

        System.out.print("vowels found are.: ");
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
               ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
                System.out.print(ch + " ");
            }
        }
        sc.close();
    }
}
