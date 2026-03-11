#include <stdio.h>

#define SIZE 50

int adj[SIZE][SIZE];
int seen[SIZE];
int q[SIZE];

void bfs_component(int startNode, int totalVertices)
{
    int head = 0, tail = 0;
    int current, i;

    q[tail++] = startNode;
    seen[startNode] = 1;

    while (head < tail)
    {
        current = q[head++];
        printf("%d ", current);

        for (i = 0; i < totalVertices; i++)
        {
            if (adj[current][i] == 1 && seen[i] == 0)
            {
                seen[i] = 1;
                q[tail++] = i;
            }
        }
    }
}

void dfs_component(int node, int totalVertices)
{
    int i;
    printf("%d ", node);
    seen[node] = 1;

    for (i = 0; i < totalVertices; i++)
    {
        if (adj[node][i] == 1 && seen[i] == 0)
        {
            dfs_component(i, totalVertices);
        }
    }
}

int main()
{
    int vertices;
    int i, j;

    printf("Total vertices: ");
    scanf("%d", &vertices);

    printf("Enter adjacency matrix (%d x %d):\n", vertices, vertices);
    for (i = 0; i < vertices; i++)
        for (j = 0; j < vertices; j++)
            scanf("%d", &adj[i][j]);

    for (i = 0; i < vertices; i++)
        seen[i] = 0;

    printf("BFS Traversal: ");
    for (i = 0; i < vertices; i++)
        if (seen[i] == 0)
            bfs_component(i, vertices);

    for (i = 0; i < vertices; i++)
        seen[i] = 0;

    printf("\nDFS Traversal: ");
    for (i = 0; i < vertices; i++)
        if (seen[i] == 0)
            dfs_component(i, vertices);

    return 0;
}

/*

0 1 1 0 0
1 0 0 1 0
1 0 0 0 1
0 1 0 0 0
0 0 1 0 0



      0
     / \
    1   2
    |   |
    3   4

| Vertex | 0 | 1 | 2 | 3 | 4 |
| ------ | - | - | - | - | - |
|   0    | 0 | 1 | 1 | 0 | 0 |
|   1    | 1 | 0 | 0 | 1 | 0 |
|   2    | 1 | 0 | 0 | 0 | 1 |
|   3    | 0 | 1 | 0 | 0 | 0 |
|   4    | 0 | 0 | 1 | 0 | 0 |

 */