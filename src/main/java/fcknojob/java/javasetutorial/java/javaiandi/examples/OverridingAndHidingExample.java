package fcknojob.java.javasetutorial.java.javaiandi.examples;

class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}


public class OverridingAndHidingExample {

    public static void main(String[] args) {
        Cat myCat = new Cat();
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
    }
}
