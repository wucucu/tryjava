package fcknojob.java.javasetutorial.examples.java;

import java.io.Console;

public class ConsoleTest {
    public static void main(String []args) {
    // get the System console object
        Console console = System.console();
        System.out.println(console);
        if(console == null) {
            System.err.println("Cannot retrieve console object - are you running your application from an IDE? Exiting the application ... ");
            System.exit(-1); // terminate the application
        }
        // read a line and print it through printf
        console.printf(console.readLine());
    }
}
