#include <stdio.h>

int cmp_count = 0, swap_count = 0;

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
    swap_count++;
}

void maxHeapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if (l < n) { cmp_count++; if (arr[l] > arr[largest]) largest = l; }
    if (r < n) { cmp_count++; if (arr[r] > arr[largest]) largest = r; }

    if (largest != i) {
        swap(&arr[i], &arr[largest]);
        maxHeapify(arr, n, largest);
    }
}

void minHeapify(int arr[], int n, int i) {
    int smallest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if (l < n) { cmp_count++; if (arr[l] < arr[smallest]) smallest = l; }
    if (r < n) { cmp_count++; if (arr[r] < arr[smallest]) smallest = r; }

    if (smallest != i) {
        swap(&arr[i], &arr[smallest]);
        minHeapify(arr, n, smallest);
    }
}

void buildMaxHeap(int arr[], int n) {
    for (int i = n/2 - 1; i >= 0; i--)
        maxHeapify(arr, n, i);
}

void buildMinHeap(int arr[], int n) {
    for (int i = n/2 - 1; i >= 0; i--)
        minHeapify(arr, n, i);
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n], arr2[n];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        arr2[i] = arr[i];
    }

    cmp_count = swap_count = 0;
    buildMaxHeap(arr, n);
    printf("Max Heap: ");
    printArray(arr, n);
    printf("Comparisons: %d, Swaps: %d\n", cmp_count, swap_count);

    cmp_count = swap_count = 0;
    buildMinHeap(arr2, n);
    printf("Min Heap: ");
    printArray(arr2, n);
    printf("Comparisons: %d, Swaps: %d\n", cmp_count, swap_count);

    return 0;
}