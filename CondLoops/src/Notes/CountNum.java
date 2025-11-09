package Notes;

import java.util.*;
public class CountNum {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        long n = sc.nextLong();
        int a = sc.nextInt();
        int count = 0;
        while (n>0){
            long rem = n%10;
            if (rem == a){
                count++;
            }
            n = n/10;

        }
        System.out.println(count);
    }
}

