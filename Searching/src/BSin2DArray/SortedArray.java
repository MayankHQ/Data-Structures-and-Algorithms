package BSin2DArray;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        int[] ans = binarySearch(arr,17);
        System.out.println(Arrays.toString(ans));
    }
    static int[] binarySearch(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = m*n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (arr[row][col] == target) {
                return new int[]{row,col};
            }
            if (arr[row][col] < target) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return new int[]{-1,-1};
    }
}
