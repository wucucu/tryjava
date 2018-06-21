package fcknojob.java.javasetutorial.java.javaoo.examples;


class Superclass {
    static void doSomething() {
        System.out.println("Inside Superclass.");
    }
}

class Subclass extends Superclass {

//    @Override
    static void doSomething() {
        System.out.println("Inside Subclass.");
    }

}



public class StaticFinalMethodExample {
    public static void main(String[] args) {
        Superclass.doSomething();
        Subclass.doSomething();

        Superclass superclass = new Subclass();
        superclass.doSomething();
    }
}
