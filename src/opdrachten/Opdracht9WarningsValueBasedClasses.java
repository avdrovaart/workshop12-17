package opdrachten;

import java.time.Instant;

public class Opdracht9WarningsValueBasedClasses {
    private static final Instant tijd  = Instant.now();

    public static void main(String[] args) {
        // FIXME: Dit mag niet meer, maar hoe dan wel....
        Integer myint = new Integer(1);

        // FIXME: Dit mag niet meer, maar hoe dan wel....
        synchronized (tijd) {
            System.out.println("Vanuit een synchronized context: " + tijd);
        }
    }
}
