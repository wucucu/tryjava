/* OCA_OCP Practice Book by Selikoff and Boyarsky
 * Chaper 3, Question 4
 */
package fcknojob.java.oca;

public class ThePlan {
    public static void main(String[] args) {
       int plan = 10;
       plan = plan++ + --plan;
       System.out.println(plan);
    }
}
