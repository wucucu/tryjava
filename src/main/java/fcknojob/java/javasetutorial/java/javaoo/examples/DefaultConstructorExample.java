package fcknojob.java.javasetutorial.java.javaoo.examples;

class GrandparentClass {
    String s = "Initialized in GpC.";
    int i = 0;

}

class ParentClass extends GrandparentClass {

    int i = 1;

    public void doOwnthing() {
        System.out.println(s + " Inside PC " + String.valueOf(i));
    }

    public void doSomething() {
        System.out.println(s + " Inside PC " + String.valueOf(i));
    }

}

class MyClass extends ParentClass{

    @Override
    public void doSomething() {
        System.out.println(s + " Inside MC " + String.valueOf(((GrandparentClass)this).i));
    }

    public void doAnotherthing() {
        System.out.println(s + " Insed MC Another");
    }

}

public class DefaultConstructorExample {
    public static void main (String... arvgs) {
        ParentClass myClassAsParentClass = new MyClass();
        myClassAsParentClass.doSomething(); // Initialized in GpC.Inside MC
        MyClass myClass = (MyClass)myClassAsParentClass;
        myClass.doSomething();
        myClass.doAnotherthing();

        MyClass myClass1 = new MyClass();
        ParentClass myClass1AsParentClass = (ParentClass) myClass1;
        myClass1AsParentClass.doOwnthing();
        myClass1AsParentClass.doSomething();
    }
}

