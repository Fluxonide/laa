#include <stdio.h>

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int knapsack(int W, int wt[], int val[], int n)
{
    int i, w;
    int K[n + 1][W + 1];

    for (i = 0; i <= n; i++)
    {
        for (w = 0; w <= W; w++)
        {
            if (i == 0 || w == 0)
                K[i][w] = 0;
            else if (wt[i - 1] <= w)
                K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]],
                              K[i - 1][w]);
            else
                K[i][w] = K[i - 1][w];
        }
    }

    printf("\nDP Table:\n");
    for (i = 0; i <= n; i++)
    {
        for (w = 0; w <= W; w++)
        {
            printf("%3d ", K[i][w]);
        }
        printf("\n");
    }

    int res = K[n][W];
    printf("\nMaximum Profit = %d\n", res);

    w = W;
    printf("Selected item values: ");

    for (i = n; i > 0 && res > 0; i--)
    {
        if (res != K[i - 1][w])
        {
            printf("%d ", val[i - 1]);
            res = res - val[i - 1];
            w = w - wt[i - 1];
        }
    }

    return K[n][W];
}

int main()
{
    int n, W;

    printf("Enter number of items: ");
    scanf("%d", &n);

    int val[n], wt[n];

    printf("Enter values of items:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &val[i]);
    }

    printf("Enter weights of items:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &wt[i]);
    }

    printf("Enter capacity of knapsack: ");
    scanf("%d", &W);

    knapsack(W, wt, val, n);

    return 0;
}

/*
values 45 5 34 12 8
weights 1 2 3 4 5 6 7
capacity 7
 */