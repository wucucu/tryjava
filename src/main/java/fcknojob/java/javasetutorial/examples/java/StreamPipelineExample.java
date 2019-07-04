package fcknojob.java.javasetutorial.examples.java;

import java.util.Arrays;

public class StreamPipelineExample {
    public static void main(String[] args) {
        Arrays.stream(Arrays.class.getMethods())
                .map(method -> method.getName())
                .distinct()
                .forEach(System.out::println);
    }
}
