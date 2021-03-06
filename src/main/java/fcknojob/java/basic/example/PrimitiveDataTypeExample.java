/*
 * Primitive Data Types
 * java basics in official tutorials for JDK 8
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */

package fcknojob.java.basic.example;

class PrimitiveDataTypeExample {
    byte byteField;
    short shortField;
    int intField;
    long longField;
    float floatField;
    double doubleField;
    char charField;
    boolean booleanField;


    void printFields() {
        // Fields that are declared but not initialized will be set to a reasonable default by the compiler.
        // The compiler never assigns a default value to an uninitialized local variable.
        System.out.println(byteField);
        System.out.println(shortField);
        System.out.println(intField);
        System.out.println(longField);
        System.out.println(floatField);
        System.out.println(doubleField);
        System.out.println(charField);
        System.out.println(booleanField);
    }


    void printLiterals() {
        // A literal is the source code representation of a fixed value.
        boolean result = true;
        char capitalC = 'C';
        byte b = 100;
        short s = 10000;
        int i = 100000;
        System.out.println(result);
        System.out.println(capitalC);
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
    }
    void printIntegerLiterals() {
        // The number 26, in decimal
        int decVal = 26;
        //  The number 26, in hexadecimal
        int hexVal = 0x1a;
        // The number 26, in binary
        int binVal = 0b11010;
        System.out.println(decVal);
        System.out.println(hexVal);
        System.out.println(binVal);
    }

    void printFloatingLiterals() {
        double d1 = 123.4;
        // same value as d1, but in scientific notation
        double d2 = 1.234e2;
        float f1 = 123.4f;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
    }

    void printUnderscoredLiterals() {
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi =  3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;
        System.out.println(creditCardNumber);
        System.out.println(socialSecurityNumber);
        System.out.println(pi);
        System.out.println(maxLong);
        System.out.println(nybbles);
        System.out.println(bytes);
    }

    void tryInvalidUsage() {
        int intLocalVariable;
        // error: variable intLocalVariable might not have been initialized
        // System.out.println(intLocalVariable);


        // Invalid: cannot put underscores
        // error: illegal underscore
        // adjacent to a decimal point
        // float pi1 = 3_.1415F;
        // Invalid: cannot put underscores
        // adjacent to a decimal point
        // float pi2 = 3._1415F;
        // Invalid: cannot put underscores
        // prior to an L suffix
        // long socialSecurityNumber1 = 999_99_9999_L;

        // OK (decimal literal)
        int x1 = 5_2;
        // Invalid: cannot put underscores
        // At the end of a literal
        // int x2 = 52_;
        // OK (decimal literal)
        int x3 = 5_______2;

        // Invalid: cannot put underscores
        // in the 0x radix prefix
        // int x4 = 0_x52;
        // Invalid: cannot put underscores
        // at the beginning of a number
        // int x5 = 0x_52;
        // OK (hexadecimal literal)
        int x6 = 0x5_2;
        // Invalid: cannot put underscores
        // at the end of a number
        // int x7 = 0x52_;
    }
}
