package intro;

public class Fibonacci {
    public static void main(String[] args) {
        int n = fibonacci(7);
        System.out.println(n);
    }
    static int fibonacci(int n) {
        if (n==0 || n==1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
