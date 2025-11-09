import java.util.Scanner;

public class pract {
    static int rev = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countSet(n));
    }

    public static int sumDigit(int number){

        int primeSum = 0;
        while(number > 0){
            int newNum = number % 10;
            if(isPrime(newNum)){
                primeSum += newNum;
            }
            number /= 10;
        }
        return primeSum;
    }
    public static void reverse(int number){
        if(number <= 0){
            return;
        }
        int rem = number % 10;
        rev = (rev * 10) + rem;
        reverse(number/10);
    }
    public static boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static int countSet(int n){
        int count = 0;
        while(n > 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


}
