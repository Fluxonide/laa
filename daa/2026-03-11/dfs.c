#include <stdio.h>

#define LIMIT 20

int matrix[LIMIT][LIMIT];
int mark[LIMIT];
int totalNodes;

void depthSearch(int current)
{
    int k;

    mark[current] = 1;
    printf("%d ", current);

    for(k = 0; k < totalNodes; k++)
    {
        if(matrix[current][k] == 1 && mark[k] == 0)
        {
            depthSearch(k);
        }
    }
}

int main()
{
    int r, c, begin;

    printf("Number of nodes: ");
    scanf("%d", &totalNodes);

    printf("Enter graph matrix:\n");

    for(r = 0; r < totalNodes; r++)
    {
        for(c = 0; c < totalNodes; c++)
        {
            scanf("%d", &matrix[r][c]);
        }
    }

    for(r = 0; r < totalNodes; r++)
    {
        mark[r] = 0;
    }

    printf("Start node: ");
    scanf("%d", &begin);

    printf("DFS Order: ");
    depthSearch(begin);

    return 0;
}
