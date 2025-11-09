package Notes;

import java.util.*;

public class Reverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int ans = 0;
        while(n>0){
            int a = n%10;
            n = n/10;
            //ans = ans *10 + a;
            System.out.print(a);
        }
        //System.out.print(ans);
    }
}
