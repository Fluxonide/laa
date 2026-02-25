// 2. Implement linear search. Measure execution time for different input sizes. Plot input size vs time graph.

#include <stdio.h>
#include <time.h>

int linearSearch(int arr[], int n, int key, double *time)
{
    clock_t start = clock();
    for (int i = 0; i < n; i++)
        if (arr[i] == key)
        {
            *time = (double)(clock() - start) / CLOCKS_PER_SEC;
            return i;
        }
    *time = (double)(clock() - start) / CLOCKS_PER_SEC;
    clock_t end = clock();
    return -1;
}

int main()
{
    int n, key;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter element to search: ");
    scanf("%d", &key);

    double execTime;
    int result = linearSearch(arr, n, key, &execTime);

    if (result != -1)
        printf("Element found at index %d\n", result);
    else
        printf("Element not found\n");

    printf("Execution Time of search = %f seconds\n", execTime);

    return 0;
}
