package Classwork;
//
//public class lec2 {
//    public static void main(String[] args) {
//        Animal a1 = new Dog();
//    }
//}
//abstract class Animal{
//
//    Animal(){
//        System.out.println("Animal Constructor");
//    }
//    abstract void eat();
//    abstract void move();
//}
//
//class Dog extends Animal{
//    void eat(){
//        System.out.println("Dog Eat");
//    }
//    void move(){
//        System.out.println("Dog Move");
//    }
//}

interface Animal {
    void move();
    void eat();
}

class Dog implements Animal {
    public void move() {
        System.out.println("The dog moves");
    }

    public void eat() {
        System.out.println("The dog eats food");
    }
}

public class lec2 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.move();
        myDog.eat();
    }
}
