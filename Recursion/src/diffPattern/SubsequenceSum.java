package diffPattern;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 5;
        printS(0, new ArrayList<>(), 0, sum, arr);
    }

    public static void printS(int index, List<Integer> list, int s, int sum, int[] arr) {
        if (index == arr.length) {
            if (s == sum) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return; // Always return at the end of array
        }

        // Include the current element
        list.add(arr[index]);
        s += arr[index];
        printS(index + 1, list, s, sum, arr);

        // Backtrack and exclude the current element
        s -= arr[index];
        list.remove(list.size() - 1);
        printS(index + 1, list, s, sum, arr);
    }
}
