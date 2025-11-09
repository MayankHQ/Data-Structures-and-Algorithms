package Lecture1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] A  = new Student[5];

        Student student1 = new Student("Manu", 21, 92.6f);
//        student1.age = 15;
//        System.out.println(student1.age);

        System.out.println(student1.age);
        System.out.println(student1.name);
        System.out.println(student1.score);

//        student1.changeName("Manu");
//        student1.greeting();

    }
}
//create a class
class Student{
    String name;
    int age;
    float score;

    void greeting(){
        System.out.println("Hello World my name is "+name);
    }

    void changeName(String newName){
        this.name = newName;
    }
    //if i pass nothing in 19th line below data will p
    Student(){
        this.name = "Mayank";
        this.age = 21;
        this.score = 92.5f;
    }
    // if i pas argument in 19th line below will print
    Student(String naam, int age, float score){
        this.name = naam;
        this.age = age;
        this.score = score;
    }
}
