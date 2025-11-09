import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>(10);

//        list.add(32); //adds in array
//        list.add(43);
//        System.out.println(list.contains(55)); //checks whether the list contain the number
//        list.set(0, 99); //sets 0 index value to 99
//
//        list.remove(2); //removes 2nd index

        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i)); //pass index here

        }
    }
}
