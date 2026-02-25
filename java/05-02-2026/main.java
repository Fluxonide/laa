// 210

// 2              1            0
// 2*(8*8)       1*(8)         0*8

// add = 128+8 = 136 (decimal)


public class main {
    public static void main(String[] args) {

        int octal = 210;
        int temp = octal;
        int decimal = 0;
        int power = 1;

        while (temp > 0) {
            int digit = temp % 10;
            if (digit > 7) {
                System.out.println("Invalid octal number");
                return;
            }
            temp /= 10;
        }

        temp = octal;
        while (temp > 0) {
            int digit = temp % 10;
            decimal += digit * power;
            power *= 8;
            temp /= 10;
        }

        System.out.println(decimal);
    }
}
