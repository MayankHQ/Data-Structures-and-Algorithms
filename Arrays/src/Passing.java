import java.util.*;
public class Passing {
    public static void main(String[] args) {
        int[] nums = {5,3,2,1,7};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void change(int[] arr){
        arr[1]= 0;
    }
}
