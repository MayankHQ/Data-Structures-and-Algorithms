import java.util.*;
public class Prime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String ans = isPrime(a);
        System.out.println(ans);

    }
    static String isPrime(int n) {
        if (n <= 1) {
            return "Not a Prime";
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return "Not a Prime";
            }
        }
        return "Prime";
    }

}
