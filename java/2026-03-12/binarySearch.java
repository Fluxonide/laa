// WAP in java to perform binarySearch


import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = input.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " sorted numbers:");
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter number to search: ");
        int target = input.nextInt();

        int left = 0;
        int right = n - 1;
        int pos = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                pos = mid;
                break;
            }
            else if(target < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if(pos != -1)
            System.out.println("Element found at index: " + pos);
        else
            System.out.println("Element not found");
    }
}