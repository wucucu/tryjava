package fcknojob.java.javasetutorial.examples.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Only when 4 players are all ready, the run() method should be called.
class MixedDoubleTennisGame extends Thread {
    public void run() {
        System.out.println("All 4 players ready, game starts ...");
    }
}

// This thread simulates arrival of players. Once a player arrives, he or she would wait for others to arrive.
class Player extends Thread {
    CyclicBarrier waitPoint;

    public Player(CyclicBarrier barrier, String name) {
        this.setName(name);
        waitPoint = barrier;
        this.start();
    }

    public void run() {
        System.out.println("Player " + getName() + " is ready ");
        try {
            waitPoint.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println("An exception occurred while wating... " + e);
        }
    }
}

// Creates a CyclicBarrier object by passing the number of threads and the thread to run when all the threads reach the barrier.
public class CyclicBarrierTest {
    public static void main(String[] args ) {
        // 4 players in mixed-double tennis game
        System.out.println("Reserving tennis court \n Once 4 players arrive, game will start");
        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
        new Player(barrier, "Player A");
        new Player(barrier, "Player B");
        new Player(barrier, "Player C");
        new Player(barrier, "Player D");
    }
}
