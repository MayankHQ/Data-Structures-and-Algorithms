package LinearSearch;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int ans = linearSearch(arr,target);
        System.out.println(ans);


    }
    static int linearSearch(int[] arr, int target){
        if(arr.length==0){
            return -1;
        }
        for (int index=0;index<arr.length;index++){
            if(arr[index]==target){
                return index;
            }
        }
        return -1;
    }
}
