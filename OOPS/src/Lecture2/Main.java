package Lecture2;

public class Main {
    public static void main(String[] args) {
        Human student1 = new Human(20, "Manraj", 5000, false);
        Human student2 = new Human(15, "Mary", 56000, true);

        System.out.println(student1.population);
        System.out.println(student2.population);
    }
}
