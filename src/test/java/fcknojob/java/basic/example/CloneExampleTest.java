package fcknojob.java.basic.example;

import org.junit.jupiter.api.Test;

class CloneExampleTest {

   @Test
   void testCloneMethod() {
       CloneExample e1 = new CloneExample();
       try {
           CloneExample e2 = e1.clone();
           System.out.println("clone succeded");
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
           System.out.println("inside catch");
       }
   }
}
