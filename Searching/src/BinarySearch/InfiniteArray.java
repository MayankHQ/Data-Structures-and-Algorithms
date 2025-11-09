package BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
        int target = 170;
        System.out.println(ans(arr, target));
    }

    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // Expand the end index exponentially until we find a range where target might lie
        while (target > arr[end]) {

            start = end + 1;
            end = (end + 1) * 2;
        }
        // Perform binary search in the determined range
        return binary(arr, target, start, end);
    }

    static int binary(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return the index
            } else if (arr[mid] < target) {
                start = mid + 1; // Target is in the right half
            } else {
                end = mid - 1; // Target is in the left half
            }
        }
        return -1; // Target not found
    }
}
