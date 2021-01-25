package oplossingen;

public class Opdracht3SwitchExpressions {
    enum Person {
        Mozart, Picasso, Goethe, Dostoevsky, Prokofiev, Dali, Gaudi, Bach, Einstein
    }

    public static void main(String[] args) {
        printProfession(Person.Mozart);
        printProfession(Person.Dali);
        printProfession(Person.Dostoevsky);
        printProfession(Person.Einstein);

        System.out.println(determineProfession(Person.Mozart));
        System.out.println(determineProfession(Person.Dali));
        System.out.println(determineProfession(Person.Dostoevsky));
        System.out.println(determineProfession(Person.Einstein));
    }

    static void printProfession(Person person) {
        // Oplossing 1 - Voeg een default statement toe.
        String title = switch (person) {
            case Dali, Picasso      -> "painter";
            case Mozart, Prokofiev  -> "composer";
            case Goethe, Dostoevsky -> "writer";
            default                 -> {
                System.out.println("I don't know this person " + person);
                yield "...";
            }
        };

        System.out.println(person + " was a " + title);
    }

    static void printProfession2(Person person) {
        // Oplossing 2 - Maak de switch statement exhaustive.
        String title = switch (person) {
            case Dali, Picasso      -> "painter";
            case Mozart, Prokofiev  -> "composer";
            case Goethe, Dostoevsky, Bach -> "writer";
            case Gaudi -> "architect";
            case Einstein -> "scientist";
        };

        System.out.println(person + " was a " + title);
    }

    static String determineProfession(Person person) {
        // Oplossing 1 - Haal de assignment van het switch statmement weg.
        switch (person) {
            case Dali, Picasso      -> { return String.format("%s was a painter", person); }
            case Mozart, Prokofiev  -> { return String.format("%s was a composer", person); }
            case Goethe, Dostoevsky -> { return String.format("%s was a writer", person); }
            default                 -> { return String.format("I don't know this person %s", person); }
        }
    }

    static String determineProfession2(Person person) {
        // Oplossing 2 - Verander return in de expressie door een yield.
        String result = switch (person) {
            case Dali, Picasso      -> { yield String.format("%s was a painter", person); }
            case Mozart, Prokofiev  -> { yield String.format("%s was a composer", person); }
            case Goethe, Dostoevsky -> { yield String.format("%s was a writer", person); }
            default                 -> { yield String.format("I don't know this person %s", person); }
        };
        
        return result;
    }
}