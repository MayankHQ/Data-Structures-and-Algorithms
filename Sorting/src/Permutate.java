import java.util.*;

public class Permutate {
    public static void main(String[] args) {
        int box = 4;
        int nos = 2;

        int ways = factorial(box) / factorial(box - nos);
        System.out.println("Ways to place: " + ways);
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i <= box; i++) {
            available.add(i);
        }

        generatePermutations(available, new ArrayList<>(), nos);
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void generatePermutations(List<Integer> available, List<Integer> current, int nos) {
        if (current.size() == nos) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < available.size(); i++) {
            List<Integer> newAvailable = new ArrayList<>(available);
            List<Integer> newCurrent = new ArrayList<>(current);

            newCurrent.add(newAvailable.remove(i));
            generatePermutations(newAvailable, newCurrent, nos);
        }
    }
}