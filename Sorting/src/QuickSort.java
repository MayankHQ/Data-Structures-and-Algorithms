// Moves smaller elements to left side of a pivot and then recursively divides array in 2 partition

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        int n = arr.length;
        quickSort(arr, 0 , n-1);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(end <= start){
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for(int j = start; j < end; j++){
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // i++;
        //use i then instead of i+1
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }
}
