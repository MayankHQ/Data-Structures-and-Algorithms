import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
//        for (int i = 0; i < n; i++){
//            System.out.print(arr[i]+" ");
//        }
//        for (int num : arr){//for every element in array print them
//            System.out.print(num+" ");//num represents element of the array
//        }
        System.out.println(Arrays.toString(arr));
    }
}