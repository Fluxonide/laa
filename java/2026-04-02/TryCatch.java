/* 
1. Write a program to demonstrate the use of try-catch-finally-throw for handling abnormal situation.
*/

class TryCatch {

    static void check(String word) {
        if (word.equalsIgnoreCase("bad")) 
            throw new RuntimeException("bad word not allowed");
        System.out.println("world is " + word);
    }

    public static void main(String[] args) {
        String w = "bad"; 
        try {
            check(w);
            System.out.println("all good");
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}