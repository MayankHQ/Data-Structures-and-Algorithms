package Notes;

import java.util.*;

public class Temp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Temperature in celsius: ");
        float C = sc.nextFloat();
        float F = (C * 1.8f) + 32;
        System.out.println("Temperature in Fahrenheit: " + F);

    }
}

