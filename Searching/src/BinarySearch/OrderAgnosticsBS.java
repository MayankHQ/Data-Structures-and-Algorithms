package BinarySearch;

import java.util.Scanner;

public class OrderAgnosticsBS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        System.out.println(binary(arr, target));
    }
    static int binary(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start)/2;
            if ( arr[mid] == target){
                return mid;
            }
            if (isAsc){
                if (target > arr[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }else {
                if (target < arr[mid]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
