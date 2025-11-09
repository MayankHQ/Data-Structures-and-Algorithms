import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,6,2};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - i- 1;
            int maxIndex = getMaxIndex(arr,0,lastIndex);
            swap(arr, maxIndex, lastIndex);
        }

    }
    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}

