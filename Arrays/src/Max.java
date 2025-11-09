import java.util.*;
public class Max {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,6};

        System.out.println(max(arr));
        System.out.println(maxRange(arr,0,3));
    }
    static int max(int[] arr){
        int maxi = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }

    static int maxRange(int[] arr, int start, int end){
        int maxi = arr[0];
        for (int i = start; i <= end; i++){
            if (arr[i] > maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }
}
