package diffPattern;

import java.util.*;

public class Subsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        generateSubsequences(0, arr, new ArrayList<>());

    }
//    public static void generateSubsequences(int index, int arr[], List<Integer>list){
//        if (index == arr.length) {
//            for(int num: list){
//                System.out.print(num + " ");
//            }
//            if (list.size() == 0) {
//                System.out.print("{}");
//            }
//            System.out.println();
//            return;
//        }
//        list.add(arr[index]);
//        generateSubsequences(index+1, arr, list);
//        list.remove(list.size()-1);
//        generateSubsequences(index+1, arr, list);
//
//    }
    public static void generateSubsequences(int index, int[] arr,  List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

    // Include
        current.add(arr[index]);
        generateSubsequences(index + 1, arr,  current);

    // Exclude
        current.removeLast();
        generateSubsequences(index + 1, arr, current);
    }
}
