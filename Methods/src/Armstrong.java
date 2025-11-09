import java.util.*;
public class Armstrong {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        boolean ans = isArmstrong(a);
        System.out.println(ans);

    }
    static boolean isArmstrong(int n){
        int original = n;
        int sum = 0;

        while (n > 0){
            int rem = n % 10;
            n/=10;

            sum = sum + rem*rem*rem;
        }
        return sum==original;
    }
}
