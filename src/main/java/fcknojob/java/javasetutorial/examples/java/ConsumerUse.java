package fcknojob.java.javasetutorial.examples.java;

import java.util.function.ObjIntConsumer;

public class ConsumerUse {
    public static void main(String[] args) {
        ObjIntConsumer<String> charAt0 = (str, i) -> str.charAt(i); // the result would be ignored as void
        charAt0.accept("java", 2);

        ObjIntConsumer<String> charAt1 = (str, i) -> System.out.println(str.charAt(i));
        charAt1.accept("java", 2);
    }
}
