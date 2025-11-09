//Leetcode:1342 Number of Steps to Reduce a Number to Zero

package easy;

public class CountSteps {
    public static int numberOfSteps(int num) {
        return helper(num,0);
    }
    public static int helper(int num, int steps){
        if(num == 0) return steps;
        if(num % 2 == 0) return helper(num/2, steps + 1);
        return helper(num-1, steps + 1);
    }
    public static void main(String[] args) {
        int num = 14;
        System.out.println(helper(num,0));
    }
}

