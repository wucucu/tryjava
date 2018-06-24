package fcknojob.java.javasetutorial.java.javaiandi.examples;


// CharSequenceDemo presents a String value -- backwards.
public class CharSequenceDemo implements CharSequence {
    private String s;

    public CharSequenceDemo(String s) {
        this.s = s;
    }

    @Override
    public int length() {
        return s.length();
    }

    private void isValidIndex(int index) {
        if (index < 0 || index >= s.length()) {
            throw new StringIndexOutOfBoundsException(index);
        }
    }

    private int getReversedIndex(int index) {
        return s.length() - 1 - index;
    }

    @Override
    public char charAt(int index) {
        isValidIndex(index);
        return s.charAt(getReversedIndex(index));
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        isValidIndex(start);
        isValidIndex(end);
        StringBuilder sub =
                new StringBuilder(s.subSequence(getReversedIndex(end), getReversedIndex(start)));
        return sub.reverse();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(this.s);
        return s.reverse().toString();
    }

    //Random int from 0 to max. As random() generates values between 0 and 0.9999
    private static int random(int max) {
        return (int) Math.round(Math.random() * (max+1));
    }


    public static void main(String[] args) {
        CharSequenceDemo s =
                new CharSequenceDemo("Write a class that implements the CharSequence interface found in the java.lang package.");

        //exercise charAt() and length()
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }

        System.out.println("");

        //exercise subSequence() and length();
        int start = random(s.length() - 1);
        int end = random(s.length() - 1 - start) + start;
        System.out.println(s.subSequence(start, end));

        //exercise toString();
        System.out.println(s);

    }
}
