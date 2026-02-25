#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Global variables to count comparisons
int linear_comparisons = 0;
int binary_comparisons = 0;

// Linear Search Algorithm
int linearSearch(int arr[], int n, int target)
{
    linear_comparisons = 0;

    for (int i = 0; i < n; i++)
    {
        linear_comparisons++;
        if (arr[i] == target)
        {
            return i; // Element found at index i
        }
    }
    return -1; // Element not found
}

// Binary Search Algorithm (Iterative)
int binarySearch(int arr[], int n, int target)
{
    binary_comparisons = 0;
    int left = 0;
    int right = n - 1;

    while (left <= right)
    {
        binary_comparisons++;
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
        {
            return mid; // Element found at index mid
        }

        if (arr[mid] < target)
        {
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }
    return -1; // Element not found
}

// Binary Search Algorithm (Recursive)
int binarySearchRecursive(int arr[], int left, int right, int target)
{
    if (left <= right)
    {
        binary_comparisons++;
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
        {
            return mid;
        }

        if (arr[mid] < target)
        {
            return binarySearchRecursive(arr, mid + 1, right, target);
        }
        else
        {
            return binarySearchRecursive(arr, left, mid - 1, target);
        }
    }
    return -1;
}

// Function to print array
void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Function to compare search algorithms
void compareSearchAlgorithms(int arr[], int n, int target)
{
    clock_t start, end;
    double linear_time, binary_time;
    int linear_result, binary_result;

    printf("\n========================================\n");
    printf("Searching for: %d\n", target);
    printf("========================================\n\n");

    // Linear Search
    start = clock();
    linear_result = linearSearch(arr, n, target);
    end = clock();
    linear_time = ((double)(end - start)) / CLOCKS_PER_SEC * 1000000; // in microseconds

    printf("LINEAR SEARCH:\n");
    if (linear_result != -1)
    {
        printf("  Element found at index: %d\n", linear_result);
    }
    else
    {
        printf("  Element not found\n");
    }
    printf("  Number of comparisons: %d\n", linear_comparisons);
    printf("  Execution time: %.6f microseconds\n\n", linear_time);

    // Binary Search
    start = clock();
    binary_result = binarySearch(arr, n, target);
    end = clock();
    binary_time = ((double)(end - start)) / CLOCKS_PER_SEC * 1000000; // in microseconds

    printf("BINARY SEARCH:\n");
    if (binary_result != -1)
    {
        printf("  Element found at index: %d\n", binary_result);
    }
    else
    {
        printf("  Element not found\n");
    }
    printf("  Number of comparisons: %d\n", binary_comparisons);
    printf("  Execution time: %.6f microseconds\n\n", binary_time);

    // Comparison
    printf("COMPARISON:\n");
    printf("  Comparison reduction: %.2f%%\n",
           (1.0 - (double)binary_comparisons / linear_comparisons) * 100);
    printf("  Binary search is %dx faster in comparisons\n",
           linear_comparisons / (binary_comparisons > 0 ? binary_comparisons : 1));

    if (linear_time > 0)
    {
        printf("  Time improvement: %.2fx\n", linear_time / (binary_time > 0 ? binary_time : 0.001));
    }
}

int main()
{
    int choice;

    printf("╔════════════════════════════════════════════════╗\n");
    printf("║   BINARY SEARCH vs LINEAR SEARCH COMPARISON   ║\n");
    printf("╚════════════════════════════════════════════════╝\n\n");

    printf("Choose a test case:\n");
    printf("1. Small array (10 elements)\n");
    printf("2. Medium array (100 elements)\n");
    printf("3. Large array (1000 elements)\n");
    printf("4. Custom array\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    int *arr = NULL;
    int n, target;

    switch (choice)
    {
    case 1:
        n = 10;
        arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++)
            arr[i] = (i + 1) * 10;
        printf("\nArray: ");
        printArray(arr, n);

        compareSearchAlgorithms(arr, n, 50);  // Middle element
        compareSearchAlgorithms(arr, n, 10);  // First element
        compareSearchAlgorithms(arr, n, 100); // Last element
        compareSearchAlgorithms(arr, n, 55);  // Not found
        break;

    case 2:
        n = 100;
        arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++)
            arr[i] = (i + 1) * 2;
        printf("\nArray size: %d elements (2, 4, 6, ..., 200)\n", n);

        compareSearchAlgorithms(arr, n, 100); // Middle element
        compareSearchAlgorithms(arr, n, 2);   // First element
        compareSearchAlgorithms(arr, n, 200); // Last element
        compareSearchAlgorithms(arr, n, 99);  // Not found
        break;

    case 3:
        n = 1000;
        arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        printf("\nArray size: %d elements (1, 2, 3, ..., 1000)\n", n);

        compareSearchAlgorithms(arr, n, 500);  // Middle element
        compareSearchAlgorithms(arr, n, 1);    // First element
        compareSearchAlgorithms(arr, n, 1000); // Last element
        compareSearchAlgorithms(arr, n, 1001); // Not found
        break;

    case 4:
        printf("Enter the size of array: ");
        scanf("%d", &n);
        arr = (int *)malloc(n * sizeof(int));

        printf("Enter %d sorted elements:\n", n);
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }

        printf("\nArray: ");
        printArray(arr, n);

        printf("Enter element to search: ");
        scanf("%d", &target);

        compareSearchAlgorithms(arr, n, target);
        break;

    default:
        printf("Invalid choice!\n");
        return 1;
    }

    // Time Complexity Summary
    printf("\n╔════════════════════════════════════════════════╗\n");
    printf("║          TIME COMPLEXITY ANALYSIS              ║\n");
    printf("╠════════════════════════════════════════════════╣\n");
    printf("║ LINEAR SEARCH:                                 ║\n");
    printf("║   Best Case:    O(1)   - First element        ║\n");
    printf("║   Average Case: O(n)   - Middle element       ║\n");
    printf("║   Worst Case:   O(n)   - Last/Not found       ║\n");
    printf("║                                                ║\n");
    printf("║ BINARY SEARCH:                                 ║\n");
    printf("║   Best Case:    O(1)   - Middle element       ║\n");
    printf("║   Average Case: O(log n) - Typical search     ║\n");
    printf("║   Worst Case:   O(log n) - Not found          ║\n");
    printf("║                                                ║\n");
    printf("║ NOTE: Binary search requires sorted array     ║\n");
    printf("╚════════════════════════════════════════════════╝\n");

    free(arr);
    return 0;
}