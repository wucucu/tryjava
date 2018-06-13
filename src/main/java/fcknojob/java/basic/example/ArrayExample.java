/*
 * Array
 * java basics in official tutorials for JDK 8
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */

package fcknojob.java.basic.example;

class ArrayExample {

    void tryMultiDimArray() {
        // A multidimensional array is an array whose components are themselves arrays.
        // The rows are allowed to vary in length.
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }
}
