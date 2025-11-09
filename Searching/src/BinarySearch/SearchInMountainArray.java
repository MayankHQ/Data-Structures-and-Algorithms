package BinarySearch;

public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {2,4,9,8,6};
        int target = 8;
        System.out.println(search(arr, target));
    }
    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstHalf = binary(arr,target,0,peak);
        if (firstHalf!=-1){
            return firstHalf;
        }
        return binary (arr, target, peak+1, arr.length -1);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {

                end = mid;
            } else {

                start = mid + 1;
            }
        }
        return start;
    }

    static int binary(int[] arr, int target,int start,int end){

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
