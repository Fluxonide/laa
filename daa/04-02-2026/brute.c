#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

void bruteForceStringMatch(char text[], char pattern[])
{
    int n = strlen(text);
    int m = strlen(pattern);
    int found = 0;

    clock_t start = clock();

    for (int i = 0; i <= n - m; i++)
    {
        int j;
        for (j = 0; j < m; j++)
        {
            if (text[i + j] != pattern[j])
                break;
        }

        if (j == m)
        {
            printf("Pattern found at index %d\n", i);
            found = 1;
        }
    }

    clock_t end = clock();
    double executionTime = (double)(end - start) / CLOCKS_PER_SEC;
    printf("Execution Time: %f seconds\n", executionTime);

    if (!found)
        printf("Pattern not found\n");
}

int main()
{
    int textSize;
    char pattern[1000];

    printf("Enter size of random text: ");
    scanf("%d", &textSize);

    printf("Enter the pattern to search: ");
    scanf("%s", pattern);

    printf("\nPattern to search: %s\n\n", pattern);

    char *text = (char *)malloc((textSize + 1) * sizeof(char));
    if (!text)
    {
        printf("Memory allocation failed!\n");
        return 1;
    }

    srand(time(NULL));

    for (int i = 0; i < textSize; i++)
    {
        text[i] = 'A' + rand() % 26;
    }
    text[textSize] = '\0';

    printf("Random Text:\n%s\n\n", text);

    bruteForceStringMatch(text, pattern);

    free(text);
    return 0;
}