//divides array into two parts and then solve for each element

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        mergeSort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if(n < 2) return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        int j = 0; int i = 0;
        for(; i < n; i++){
            if(i < mid) left[i] = arr[i];
            else{
                right[j] = arr[i];
                j++;
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    private static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = arr.length/2;
        int rightSize = arr.length - leftSize;
        int l = 0; int r = 0; int i = 0;
        while(l < leftSize && r < rightSize){
            if(left[l] <= right[r]){
                arr[i] = left[l];
                i++;
                l++;
            }
            else{
                arr[i] = right[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            arr[i] = left[l];
            i++;
            l++;
        }
        while(r < rightSize){
            arr[i] = right[r];
            i++;
            r++;
        }

    }
}
