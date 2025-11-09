package LinearSearch;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {21,324,5432,5,32,566262,1};
        System.out.println(findNumbers(nums));

    }
     static int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
     }

    static boolean even(int num) {
        int numOfDigits = digits(num);
        if (numOfDigits % 2 == 0){
            return true;
        }
        return false;
    }

    static int digits(int num){
        if (num > 0){
            num = num * -1;
        }
//        if (num == 0){
//            return 1;
//        }
//        int cnt =0;
//        while(num>0){
//            cnt++;
//            num /= 10;
//        }
//        return cnt;
        return (int)(Math.log10(num)) + 1;
    }


}
