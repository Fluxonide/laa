// wap in java to extract vowel from the given word

import java.util.Scanner;

class FindVowels {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter word: ");
        String word = sc.next();

        String vowels = "aeiouAEIOU";
        boolean found = false;

        System.out.print("vowels present: ");

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(vowels.indexOf(ch) != -1) {
                System.out.print(ch + " ");
                found = true;
            }
        }

        if(!found) {
            System.out.print("None");
        }

        sc.close();
    }
}