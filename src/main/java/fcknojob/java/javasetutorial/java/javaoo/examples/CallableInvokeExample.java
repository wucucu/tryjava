package fcknojob.java.javasetutorial.java.javaoo.examples;

import java.util.concurrent.Callable;

public class CallableInvokeExample {
    void invoke(Runnable r) {
        r.run();
    }

    <T> T invoke(Callable<T> c) {
        try {
            return c.call();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String s = new CallableInvokeExample().invoke(() -> "done");
        System.out.println(s);
    }
}
