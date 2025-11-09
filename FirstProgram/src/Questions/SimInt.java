package Questions;

import java.util.Scanner;

public class SimInt {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        double P = sc.nextInt();
        double R = sc.nextInt();
        double T = sc.nextInt();
        double SI = (P*R*T)/100;

        System.out.println("Simple Interest is: "+ SI);
    }
}
