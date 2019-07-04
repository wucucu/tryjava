package fcknojob.java.javasetutorial.examples.java;

// This class exposes a publicly accessible counter
// to help demonstrate race condition problem
class Counter {
    public static long count = 0;
}
// This class implements Runnable interface
// Its run method increments the counter three times
class UseCounter implements Runnable {
//    public void increment() {
    public synchronized void increment() {
        // increments the counter and prints the value
        // of the counter shared between threads
        Counter.count++;
        System.out.println("in thread: " + Thread.currentThread().getName() + " current count: " + Counter.count);
    }

    public void synchronized_increment() {
        synchronized(this) {
            Counter.count++;
            System.out.println("in thread: " + Thread.currentThread().getName() + " current count: " + Counter.count);
        }
    }

    public void run() {
        synchronized_increment();
        synchronized_increment();
        increment();
        increment();
    }
}
// This class creates three threads
public class RaceCondition {
    public static void main(String[] args) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}
