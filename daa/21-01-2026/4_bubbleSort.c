
// 4. Implement Bubble Sort. Count comparisons and swaps. Analyze best and worst-case behavior.

#include <stdio.h>

int main()
{
    int n, i, j, temp, c = 0, s = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int a[100];
    printf("Enter elements: ");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            c++;
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                s++;
            }
        }
    }

    printf("Sorted array: ");
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);

    printf("\nComparisons = %d, swap = %d\n", c, s);

    return 0;
}
