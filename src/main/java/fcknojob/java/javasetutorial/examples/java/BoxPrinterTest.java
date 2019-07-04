package fcknojob.java.javasetutorial.examples.java;


class BoxPrinter<T> {
    private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "[" + val + "]";
    }
}

public class BoxPrinterTest {
    public static void main(String[] args) {
        BoxPrinter<Integer> value1 = new BoxPrinter<Integer>(new Integer(10));
        System.out.println(value1);

        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello World!");
        System.out.println(value2);
    }
}
