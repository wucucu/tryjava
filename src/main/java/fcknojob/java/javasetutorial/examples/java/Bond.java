/* OCA_OCP Practice Book by Selikoff and Boyarsky
 * Chaper 3, Question 20
 */
package fcknojob.java.javasetutorial.examples.java;

public class Bond {
    private static int price =5;
    public boolean sell() {
        if (price<10) {
            price++;
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] cash) {
        new Bond().sell();
        new Bond().sell();
        new Bond().sell();
        System.out.print(price);
    }
}
