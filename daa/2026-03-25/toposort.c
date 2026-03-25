#include <stdio.h>

#define MAX 100

int graph[MAX][MAX];
int visited[MAX];
int stack[MAX];
int top = -1;
int n, e;

void push(int x)
{
    stack[++top] = x;
}

void dfs(int v)
{
    visited[v] = 1;

    for (int i = 0; i < n; i++)
    {
        if (graph[v][i] && !visited[i])
        {
            dfs(i);
        }
    }

    push(v);
}

int main()
{
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            graph[i][j] = 0;

    printf("Enter edges (u v) one by one:\n");
    for (int i = 0; i < e; i++)
    {
        int u, v;
        printf("Edge %d: ", i + 1);
        scanf("%d %d", &u, &v);
        graph[u][v] = 1;
    }

    for (int i = 0; i < n; i++)
        visited[i] = 0;

    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
            dfs(i);
    }

    printf("Topological order:\n");
    while (top != -1)
    {
        printf("%d ", stack[top--]);
    }

    return 0;
}