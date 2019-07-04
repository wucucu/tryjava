package fcknojob.java.javasetutorial.examples.java;

public class MyThread extends Thread {
    public void run() {
        try {
            sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("In run(); thread name is: " + getName());
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        System.out.println("In main(); thread name is: " + Thread.currentThread().getName());
    }
}
