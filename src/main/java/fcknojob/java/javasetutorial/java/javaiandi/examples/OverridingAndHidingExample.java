package fcknojob.java.javasetutorial.java.javaiandi.examples;

class Animal {
    public int size;

    public Animal() {
        size = 0;
    }

    public Animal(int i) {
        size = i;
    }

    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

class Cat extends Animal {
    public int size;

    public Cat() {
        super();
    }
    public Cat(int i) {
        super(i);
    }

    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

}


public class OverridingAndHidingExample {

    public static void main(String[] args) {
        Cat myCat = new Cat(2);
        Animal myAnimal = myCat;

        System.out.println("--Animal--");
        Animal.testClassMethod();

        System.out.println("--myAnimal--");
        myAnimal.testClassMethod();
        myAnimal.testInstanceMethod();

        System.out.println("--Cat--");
        Cat.testClassMethod();

        System.out.println("--myCat--");
        myCat.testClassMethod();
        myCat.testInstanceMethod();

        System.out.println(((Animal)myCat).size);
        System.out.println(((Cat)myAnimal).size);

    }
}
