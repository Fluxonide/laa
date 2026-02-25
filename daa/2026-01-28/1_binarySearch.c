// Implement binary search algorithm. Compare it with the linear search algorithm in terms of number of comparisons and executions time. Observe best, average and worst cases.

#include <stdio.h>
#include <time.h>
int main()
{
    int n, key, i;
    int linearComp = 0, binaryComp = 0;
    printf("Enter Number of Elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter Sorted Array: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    printf("Enter element to search: ");
    scanf("%d", &key);
    double linearTime, binaryTime;

    int low = 0, high = n - 1, mid;
    clock_t start = clock();
    while (low <= high)
    {
        binaryComp++;
        mid = (low + high) / 2;
        if (arr[mid] == key)
            break;
        else if (key < arr[mid])
            high = mid - 1;
        else
            low = mid + 1;
    }
    clock_t end = clock();
    binaryTime = (double)(end - start) / CLOCKS_PER_SEC;

    start = clock();
    for (i = 0; i < n; i++)
    {
        linearComp++;
        if (arr[i] == key)
            break;
    }
    end = clock();
    linearTime = (double)(end - start) / CLOCKS_PER_SEC;
    printf("\nBinary Search:");
    printf("\nComparisons: %d", binaryComp + 1);
    printf("\nExecution Time: %f seconds", binaryTime);
    printf("\n\nLinear Search:");
    printf("\nComparisons: %d", linearComp);
    printf("\nExecution Time: %f seconds", linearTime);
    return 0;
}