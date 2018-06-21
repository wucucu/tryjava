package fcknojob.java.javasetutorial.java.javaoo.examples;

class GrandparentClass {
    String s = "Initialized in GpC.";
    int i = 0;

}

class ParentClass extends GrandparentClass {

    int i = 1;

    public void doSomething() {
        System.out.println(s + " Inside PC " + String.valueOf(i));
        ((MyClass)this).doSomething();;
    }

}

class MyClass extends ParentClass{

    @Override
    public void doSomething() {
        System.out.println(s + " Inside MC " + String.valueOf(((GrandparentClass)this).i));
    }

}

public class DefaultConstructorExample {
    public static void main (String... arvgs) {
        ParentClass myClass = new MyClass();
        myClass.doSomething(); // Initialized in GpC.Inside MC
    }
}

