package fcknojob.java.javasetutorial.examples.java;


import java.util.concurrent.*;

class Factorial implements Callable<Long> {
    long n;
    public Factorial(long n) {
        this.n = n;
    }
    public Long call() throws Exception {
        if (n <= 0) {
            throw new Exception("for finding factorial, N should be > 0");
        }
        long fact = 1;
        for(long longVal = 1; longVal <= n; longVal++) {
            fact *= longVal;
        }
        return fact;
    }
}



public class CallableTest {
    public static void main(String[] args) throws Exception {
        long N = 20;
        Callable<Long> task = new Factorial(N);
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Long> future = es.submit(task);
        System.out.println(future.isDone());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(future.isDone());
        System.out.println(future.get());
        es.shutdown();
    }
}
