import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
//        int[] arr = {9, 4, 2, 1, 6, 3, 7, 8, 5};
        int[] arr = {4,8,3,1,2,1,1,1,9,7};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycle(int[] arr){

        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if (arr[i]!= arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
