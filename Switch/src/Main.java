import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String fruit = sc.nextLine();

        switch (fruit) {
            case "Mango" -> System.out.println("King of fruits");
            case "Apple" -> System.out.println("Keeps doctor away");
            case "Banana" -> System.out.println("Oye papaji");
            default -> System.out.println("Lassi punjabi");
        }
    }
}