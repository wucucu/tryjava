package fcknojob.java.basic.example;

import org.junit.jupiter.api.Test;

class PrimitiveDataTypeExampleTest {

    @Test
    void testFieldsDefauldValue() {
        new PrimitiveDataTypeExample().printFields();
    }

    @Test
    void testLiterals() {
        new PrimitiveDataTypeExample().printLiterals();
    }

    @Test
    void testIntergerLiterals() {
        new PrimitiveDataTypeExample().printIntegerLiterals();
    }

    @Test
    void testFloatingLiterals() {
        new PrimitiveDataTypeExample().printFloatingLiterals();
    }

    @Test
    void testUnderscoredLiterals() {
        new PrimitiveDataTypeExample().printUnderscoredLiterals();
    }

    @Test
    void testInvalidUsage() {
        new PrimitiveDataTypeExample().tryInvalidUsage();
    }
}
