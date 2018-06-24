package fcknojob.java.javasetutorial.java.javaoo.examples;

public class NestedClassExample {
    static final int i = 0;
    int k = 1;

    static class InnerClass {
        final int j = 1;
        public InnerClass() {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new InnerClass().j);
    }
}
