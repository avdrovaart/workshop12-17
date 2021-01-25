package opdrachten;

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
        // FIXME - Deze methode compileert niet. Begrijp waarom, en verbeter vervolgens de compilatiefout.
        String title = switch (person) {
            case Dali, Picasso      -> "painter";
            case Mozart, Prokofiev  -> "composer";
            case Goethe, Dostoevsky -> "writer";
        };
        
        System.out.printf("%s was a %s%n", person, title);
    }

    static String determineProfession(Person person) {
        // FIXME - Deze methode compileert niet. Begrijp waarom, en verbeter vervolgens de compilatiefout.
        String result = switch (person) {
            case Dali, Picasso      -> { return String.format("%s was a painter", person); }
            case Mozart, Prokofiev  -> { return String.format("%s was a composer", person); }
            case Goethe, Dostoevsky -> { return String.format("%s was a writer", person); }
            default                 -> { return String.format("I don't know this person %s", person); }
        };

        return result;
    }
}