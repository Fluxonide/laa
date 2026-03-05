//From a list of numbers in an array find sum of even number


public class num {

    public static void main(String[] args) {
        int[] numbers = {4, 15, 18, 25, 28, 35, 68};

        int sum = 0;

        for (int num : numbers) {
            if (num%2==0) {
                sum+=num;
            }
        }

        System.out.println("Sum of even numbers: " + sum);
    }
}
