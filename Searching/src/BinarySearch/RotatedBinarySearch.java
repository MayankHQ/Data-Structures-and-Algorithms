package BinarySearch;

import java.util.*;

//public class RotatedBinarySearch {
//    public static void main(String[] args) {
//        int[] arr = {3,4,8,1,2};
//        int ans = search(arr , 8);
//        System.out.println(ans);
//    }
//    static int search(int[] arr, int target){
//        int pivot = findPivot(arr);
//
//        if (pivot == -1){
//            return binarySearch(arr,target,0,arr.length - 1);
//        }
//
//        if (arr[pivot] == target){
//            return pivot;
//        }
//        if (arr[0] >= target){
//            return binarySearch(arr,target,pivot+1,arr.length - 1);
//        }
//        return binarySearch(arr,target,0,pivot -1 );
//    }
//
//    static int findPivot(int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (mid < end && arr[mid] > arr[mid + 1]) {
//                return mid;
//            } else if (mid > start && arr[mid] < arr[mid - 1]) {
//                return mid - 1;
//            } else if (arr[mid] <= arr[start]) {
//                end = mid - 1;
//            } else {
//                start = mid+ 1 ;
//            }
//        }
//        return -1;
//    }
//
//    static int binarySearch(int[] arr, int target, int start, int end) {
//        while (start <= end) {
//            // find the middle element
////            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
//            int mid = start + (end - start) / 2;
//
//            if (target < arr[mid]) {
//                end = mid - 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                // ans found
//                return mid;
//            }
//        }
//        return -1;
//    }
//}

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,4,8,1,2};
        int target = 4;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                System.out.println(mid);
            }
            if(arr[start] < arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }

        }
    }
}
