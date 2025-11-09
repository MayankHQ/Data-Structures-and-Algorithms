package arrays;

import java.util.ArrayList;
import java.util.Arrays;


public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr,0);
    }
    public static void permute(int[] arr, int index) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr,i,index);
            permute(arr,index+1);
            swap(arr,i,index);
        }

    }

    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
