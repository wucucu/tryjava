package fcknojob.java.javasetutorial.examples.java;


import java.util.ArrayList;
import java.util.List;

class Utilities {
    public static <T> void fill(List<T> list, T val) {
        for (int i=0; i < list.size(); i++) {
            list.set(i, val);
        }
    }
}

public class UtilitiesTest {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(20);
        intList.add(40);
        System.out.println(intList);
        Utilities.fill(intList, 100);
        System.out.println(intList);
    }
}
