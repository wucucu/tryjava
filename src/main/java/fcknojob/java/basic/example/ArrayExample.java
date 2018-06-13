/*
 * Array
 * java basics in official tutorials for JDK 8
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */

package fcknojob.java.basic.example;

class ArrayExample {

    static void tryMultiDimArray() {
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

    static void tryArrayCopy() {
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom,2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }

    static void tryArrayCopyOf() {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));
    }
}
