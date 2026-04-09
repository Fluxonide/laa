
/* 
Write a Java program that stores a set of numbers in an array. For each number, calculate its factorial and write the result to a file using a BufferedOutputStream.
After writing the data, read the contents of the file using a FileInputStream and display the results on the console.

Example:
If the array is [2, 3, 5], the file should contain:
2 factorial is 2
3 factorial is 6
5 factorial is 120 
*/
import java.io.*;

class factorial {
    public static void main(String[] args) throws Exception {

        int[] arr = { 2, 3, 5 };

        FileOutputStream os = new FileOutputStream("file.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);

        for (int n : arr) {
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            String s = n + " factorial is " + fact + "\n";
            bos.write(s.getBytes());
        }

        bos.close();
        os.close();

        FileInputStream is = new FileInputStream("file.txt");

        int text;
        while ((text = is.read()) != -1) {
            System.out.print((char) text);
        }

        is.close();
    }
}