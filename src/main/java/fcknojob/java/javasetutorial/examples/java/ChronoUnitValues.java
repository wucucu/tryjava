package fcknojob.java.javasetutorial.examples.java;

import java.time.temporal.ChronoUnit;

public class ChronoUnitValues {
    public static void main(String[] arts) {
        System.out.println("ChronnoUnit DateBased TimeBased Duration");
        System.out.println("----------------------------------------");
        for(ChronoUnit unit : ChronoUnit.values()) {
            System.out.printf("%10s \t %b \t\t %b \t\t %s %n",
                    unit, unit.isDateBased(), unit.isTimeBased(), unit.getDuration());
        }
    }
}
