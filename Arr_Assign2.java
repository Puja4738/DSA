import java.util.Scanner;

public class Arr_Assign2 {
    public static int printIdxOfTarget(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } 
             // Check if the left half is sorted
             if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Otherwise, the right half must be sorted
            else {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1; // If target is not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arr_size = sc.nextInt();
        int arr[] = new int[arr_size];
        System.out.println("Enter the elements of the array in sorted order: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target element: ");
        int target = sc.nextInt();
        int idx = printIdxOfTarget(arr, target);
        if (idx != -1) {
            System.out.println("Element present at index " + idx);
        } else {
            System.out.println("Element not present");
        }
        sc.close();
    }
}