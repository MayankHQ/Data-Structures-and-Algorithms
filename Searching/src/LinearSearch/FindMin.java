package LinearSearch;

public class FindMin {
    public static void main(String[] args) {
        int[] arr = {4,7,2,13,5,1};
        System.out.println(min(arr));

    }
    static int min(int[] arr){
        int ans = arr[0];
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] < ans){
                ans = arr[i];
            }
        }
        return ans;
    }
}
