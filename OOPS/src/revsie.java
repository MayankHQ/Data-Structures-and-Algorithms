class Employee {
    String company = "OpenAI"; // shared by all

    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " works at " + company);
    }
}

public class revsie {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice");
        Employee e2 = new Employee("Bob");

        e1.display(); // Alice works at OpenAI
        e2.display(); // Bob works at OpenAI

        // Change static variable
        Employee.company = "Google";

        e1.display(); // Alice works at Google
        e2.display(); // Bob works at Google
    }
}
