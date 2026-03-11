#include <stdio.h>
int graph[10][10];
int visited[10];
int queue[10];
int n;
void bfs(int start)
{
    int front = 0, rear = 0;
    int i;
    queue[rear++] = start;
    visited[start] = 1;
    while (front < rear)
    {
        int node = queue[front++];
        printf("%d ", node);
        for (i = 0; i < n; i++)
        {
            if (graph[node][i] == 1 && visited[i] == 0)
            {
                visited[i] = 1;
                queue[rear++] = i;
            }
        }
    }
}
int main()
{
    int i, j, start;
    printf("Enter number of vertices: ");
    scanf("%d", &n);
    printf("Enter adj matrix:\n");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }
    for (i = 0; i < n; i++)
        visited[i] = 0;
    printf("Enter starting vertex: ");
    scanf("%d", &start);
    printf("BFS Traversal: ");
    bfs(start);
    return 0;
}
