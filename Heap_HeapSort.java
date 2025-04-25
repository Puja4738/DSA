// import java.util.*;
public class Heap_HeapSort {
    public static void heapify(int[] arr, int i, int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            // Swap the current node with the largest child node
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int[] arr){
        // step 1: Build max-heap
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step 2: Put largest at the end and reduce the heap size
        for(int i = n - 1; i > 0; i--) {
            // Swap first element (largest) with the current last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap (excluding the sorted part)
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);

        // Print the sorted array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
