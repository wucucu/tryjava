package fcknojob.java.javasetutorial.examples.java;

import java.util.stream.IntStream;

public class Consonants {
    private static boolean removeVowels(int c) {
        switch(c) {
            case 'a': case 'e': case 'i': case 'o': case 'u': return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        "avada kedavra".chars().filter(Consonants::removeVowels).forEach(System.out::println);
        IntStream.range(1, 2).forEach(System.out::println);
    }
}
