package Questions;
import java.util.*;

public class Currency {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount in INR: ");
        double a = sc.nextInt();
        double b = (a*83.34);
        System.out.print("Amount in USD: " + b );
    }
}