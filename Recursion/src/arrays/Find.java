package arrays;
import java.util.*;
public class Find {
    public static void main(String[] args) {
        int[] arr = {5,3,1,3,7,4};
//        System.out.println(find(arr, 0, 0));
//        System.out.println(find(arr, 0, 1));
        ArrayList<Integer> ans = findAllIndex(arr,3,0, new ArrayList<>());
        System.out.println(ans);
    }
    static boolean find(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || find(arr,target,index+1);
    }
    static int findIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return -1;
        }
        return arr[index] == target ? index : findIndex(arr,target,index+1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr,target,index+1);

        list.addAll(ansFromBelowCalls);

        return list;
    }
}
