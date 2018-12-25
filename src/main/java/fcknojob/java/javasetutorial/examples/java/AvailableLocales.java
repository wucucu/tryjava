package fcknojob.java.javasetutorial.examples.java;

import java.util.Locale;
import java.util.Arrays ;
class AvailableLocales {
    public static void main(String []args) {
        System.out.println("The default locale is: " + Locale.getDefault());
        Locale [] locales = Locale.getAvailableLocales();
        System.out.printf("No. of other available locales is: %d, and they are: %n",
                locales.length);
        Arrays.stream(locales).forEach(
                locale -> System.out.printf("Locale code: %s and it stands for %s %n",
                        locale, locale.getDisplayName()));
    }
}

class AvailableLocalesEnglish {
    public static void main(String []args) {
        Arrays.stream(Locale.getAvailableLocales())
                .filter(locale -> locale.getLanguage().equals("en"))
                .forEach(locale ->
                        System.out.printf("Locale code: %s and it stands for %s %n",
                                locale, locale.getDisplayName()));
    }
}
