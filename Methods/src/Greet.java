import java.util.*;
public class Greet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String message = greet(name);
        System.out.println(message);
    }

    static String greet(String name) {
        return "Hello "+ name;
    }

}