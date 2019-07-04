package fcknojob.java.javasetutorial.examples.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatchUse {
    public static void main(String[] args) {
        int[] intArray = {-56, -57,-55, -52, -48, -51, -49};
        boolean anyMatch = Arrays.stream(intArray).anyMatch(temp -> temp > 0);
        System.out.println("anyMatch(temp -> temp > 0): " + anyMatch);
    }
}
