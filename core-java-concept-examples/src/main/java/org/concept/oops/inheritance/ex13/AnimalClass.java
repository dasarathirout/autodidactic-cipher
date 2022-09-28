package org.concept.oops.inheritance.ex13;

public class AnimalClass {

    class Animal {

    }
    class Dog extends Animal{

    }
    class PetDog extends Dog{
    }

    public static void show(Animal X) {
        System.out.println("ANIMAL");
    }

    public static void show(Dog X) {
        System.out.println("DOG");
    }
    public static void show(PetDog X) {
        System.out.println("PET DOG");
    }

    public static void show(Object X) {
        System.out.println("OBJECT");
    }

    public static void main(String[] worlds) {
        PetDog dog = new AnimalClass().new PetDog();
        show(dog);
    }
}
