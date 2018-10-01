/* OCA_OCP Practice Book by Selikoff and Boyarsky
 * Chaper 3, Question 20
 */
package fcknojob.java.oca;

public class Dancing {
    public static void main(String[] vars) {
        int leaders = 10 * (2 + 2 / 5);
        int flowers = leaders * 2;
        System.out.println(leaders);
        System.out.println(flowers);
        System.out.println(leaders + flowers < 10 ? "Too few" : "Too many");
    }
}
