package fcknojob.java.javasetutorial.examples.java;

public class RunnableImpl implements Runnable {
    public void run() {
        System.out.println("In run(); thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception{
        Thread myThread = new Thread(new RunnableImpl());
        myThread.start();
        System.out.println("In main(); thread name is: " + Thread.currentThread().getName());
    }
}
