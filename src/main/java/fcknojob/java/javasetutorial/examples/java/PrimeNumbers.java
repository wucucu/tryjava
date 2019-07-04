package fcknojob.java.javasetutorial.examples.java;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class PrimeNumbers {
    private static boolean isPrime(long val) {
        for (long i = 2; i <= val/2; i++) {
            if ((val % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Instant t0, t1;
        t0 = Instant.now();
        long numOfPrimes0, numOfPrimes1;
        numOfPrimes0 = LongStream.rangeClosed(2, 100_000)
                .filter(PrimeNumbers::isPrime)
                .count();
        t1 = Instant.now();
        System.out.println(Duration.between(t0, t1));

        t0 = Instant.now();
        numOfPrimes1 = LongStream.rangeClosed(2, 100_000)
                .parallel()
                .filter(PrimeNumbers::isPrime)
                .count();
        t1 = Instant.now();
        System.out.println(Duration.between(t0, t1));

        assert numOfPrimes0 == numOfPrimes1;
        System.out.println(numOfPrimes0);
    }
}
