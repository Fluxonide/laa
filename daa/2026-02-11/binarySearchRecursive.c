#include <stdio.h>

int linearCount = 0;
int binaryCount = 0;

int binarySearch(int arr[], int low, int high, int key)
{
    if (low > high)
        return -1;

    binaryCount++; // count comparison

    int mid = (low + high) / 2;

    if (arr[mid] == key)
        return mid;
    else if (key < arr[mid])
        return binarySearch(arr, low, mid - 1, key);
    else
        return binarySearch(arr, mid + 1, high, key);
}

// Linear Search
int linearSearch(int arr[], int n, int key)
{
    int i;
    for (i = 0; i < n; i++)
    {
        linearCount++; // count comparison
        if (arr[i] == key)
            return i;
    }
    return -1;
}

int main()
{
    int arr[100], n, key, i;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter elements (sorted): ");
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter element to search: ");
    scanf("%d", &key);

    int result1 = linearSearch(arr, n, key);

    if (result1 != -1)
        printf("Linear Search: Found at position %d\n", result1 + 1);
    else
        printf("Linear Search: Not Found\n");

    printf("Linear Comparisons = %d\n", linearCount);

    int result2 = binarySearch(arr, 0, n - 1, key);

    if (result2 != -1)
        printf("Binary Search: Found at position %d\n", result2 + 1);
    else
        printf("Binary Search: Not Found\n");

    printf("Binary Comparisons = %d\n", binaryCount);

    return 0;
}
