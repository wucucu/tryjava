package fcknojob.java.javasetutorial.examples.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Race {
    static ExecutorService service = Executors.newFixedThreadPool(8);
    public static int sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return 1;
    }
    public static void hare() {
        try {
            Callable c = () -> sleep();
            final Collection<Callable<Integer>> r = Arrays.asList(c,c,c);
            List<Future<Integer>> results;
            results = service.invokeAll(r);
            System.out.println("Hare won the race!");
        } catch (Exception e) {e.printStackTrace();}
    }
    public static void tortoise() {
        try {
            Callable c = () -> sleep();
            final Collection<Callable<Integer>> r = Arrays.asList(c,c,c);
            Integer result = service.invokeAny(r);
            System.out.println("Tortoise won the race!");
        } catch (Exception e) {e.printStackTrace();}
    }
    public static void main(String[] p) throws Exception {
        service.execute(() -> hare());
        service.execute(() -> tortoise());
        Thread.sleep(2000);
        service.shutdownNow();
    }
}
