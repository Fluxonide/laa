// 1. Write an algorithm to find the maximum and minimum element in an array.
//  Count the number of comparisons. Express the step count as a growth function f(n).


#include <stdio.h>

int main() {
    int n, i, min, max, c = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int a[100];   

    printf("Enter elements:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    min = max = a[0];

    for (i = 1; i < n; i++) {
        c++;
        if (a[i] < min) min = a[i];
        c++;
        if (a[i] > max) max = a[i];
    }

    printf("Min=%d Max=%d Comparisons=%d\n", min, max, c);
    return 0;
}

