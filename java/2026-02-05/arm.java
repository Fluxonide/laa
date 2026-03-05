// 3³ + 7³ + 0³
// = 27 + 343 + 0
// = 370


// 1634:

// 1^4 = 1 × 1 × 1 × 1 = 1
// 6^4 = 6 × 6 × 6 × 6 = 1296
// 3^4 = 3 × 3 × 3 × 3 = 81
// 4^4 = 4 × 4 × 4 × 4 = 256

// Sum = 1 + 1296 + 81 + 256 = 1634 


public class arm {
    public static void main(String[] args) {
        int number = 54748;
        int temp = number;
        int sum = 0;

        int digits = 0;
        int t = number;
        while (t != 0) { 
            t /= 10;
            digits++;
        }

        while (temp != 0) {
            int digit = temp % 10;
            int power = 1;
            for (int i = 0; i < digits; i++) {
                power *= digit;
            }
            sum += power;
            temp /= 10;
        }

        if (sum == number)
            System.out.println(number + " is an Armstrong number");
        else
            System.out.println(number + " is not an Armstrong number");
    }
}
