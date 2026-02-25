// Implement selection sort. count comparison and swaps. analyze best and worst case scenario

#include <stdio.h>

int main()
{
    int n, i, j, min, temp, c = 0, s = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int a[100];
    printf("Enter elements: ");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    for (i = 0; i < n - 1; i++)
    {
        min = i;
        for (j = i + 1; j < n; j++)
        {
            c++;
            if (a[j] < a[min])
                min = j;
        }
        if (min != i)
        {
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            s++;
        }
    }

    printf("Sorted array: ");
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);
    printf("\nComparisons = %d, swap = %d\n", c, s);

    return 0;
}
