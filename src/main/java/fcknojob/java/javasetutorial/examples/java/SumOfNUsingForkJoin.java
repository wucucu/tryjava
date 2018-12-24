package fcknojob.java.javasetutorial.examples.java;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumOfNUsingForkJoin {
        private static long N = 1_000_000;

        private static final int NUM_THREAD = 10;

        static class RecursiveSumOfN extends RecursiveTask<Long> {
            long from, to;
            int depth;
            public RecursiveSumOfN(long from, long to, int depth) {
                this.from = from;
                this.to = to;
                this.depth = depth;
            }

            public Long compute() {
                if ((to - from) <= N/NUM_THREAD) {
                    long localSum = 0;
                    for (long i = from; i <= to; i++) {
                        localSum += i;
                    }
                    System.out.printf("Depth %d \t\tSum of value range %d to %d is %d %n", depth, from, to, localSum);
                    return localSum;
                } else {
                    long mid = (from + to) / 2;
                    System.out.printf("Depth %d \tForking computation into two ranges: " + "%d to %d and %d to %d %n", depth, from, mid, mid, to);
                    RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid, depth+1);
                    firstHalf.fork();
                    RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid + 1, to, depth+1);
                    long resultSecond = secondHalf.compute();

                    return firstHalf.join() + resultSecond;
                }
            }
        }


        public static void main(String[] args) {
            ForkJoinPool pool = new ForkJoinPool(NUM_THREAD);

            long computedSum = pool.invoke(new RecursiveSumOfN(0, N, 0));

            long formulaSum = (N * (N + 1)) / 2;

            System.out.printf("Sum for range 1..%d; computed sum = %d, " + "formula sum = %d %n", N, computedSum, formulaSum);
        }


}
