package fcknojob.java.javasetutorial.examples.java;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class UsingPeriod {

    public static void main(String[] args) {
        LocalDate manufacturingDate = LocalDate.of(2016, Month.DECEMBER, 19);
        LocalDate expiryDate =LocalDate.of(2015, Month.FEBRUARY, 20);

        Period expiry = Period.between(manufacturingDate, expiryDate);
        System.out.printf("Medicine will expire in: %d years, %d months, and %d days. (%s)\n",
                expiry.getYears(), expiry.getMonths(), expiry.getDays(), expiry);
    }
}
