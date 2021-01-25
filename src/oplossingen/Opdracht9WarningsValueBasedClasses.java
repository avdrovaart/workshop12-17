package oplossingen;

import java.time.Instant;

public class Opdracht9WarningsValueBasedClasses {
    private static final Instant tijd  = Instant.now();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // Gebruik de valueOf
        Integer myint = Integer.valueOf(1);

        // Gebruik een apart object voor de lock
        synchronized (lock) {
            System.out.println("Vanuit een synchronized context: " + tijd);
        }
    }

}
