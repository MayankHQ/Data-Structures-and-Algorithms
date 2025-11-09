package easy;

public class DigitSum {
    public static void main(String[] args) {
        int ans = sum(1235);
        System.out.println(ans);
        System.out.println(prod(123));
    }
    static int sum(int n) {
        if (n == 0){
            return 0;
        }
        return (n%10) + sum(n/10);
    }
    static int prod(int n) {
        if (n%10 == n){
            return n;
        }
        return (n%10) * prod(n/10);
    }

}
