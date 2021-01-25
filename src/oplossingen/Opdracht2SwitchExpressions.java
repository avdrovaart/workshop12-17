package oplossingen;

public class Opdracht2SwitchExpressions {
    enum Person {
        Mozart, Picasso, Goethe, Dostoevsky, Prokofiev, Dali, Gaudi, Bach, Einstein
    }

    public static void main(String[] args) {
        printProfession(Person.Mozart);
        printProfession(Person.Dali);
        printProfession(Person.Dostoevsky);
        printProfession(Person.Einstein);
    }

    static void printProfession(Person person) {
        String title = switch (person) {
            case Dali, Picasso      -> "painter";
            case Mozart, Prokofiev  -> "composer";
            case Goethe, Dostoevsky -> "writer";
            default                 -> {
                System.out.println("I don't know this person " + person);
                // Yield retourneert een waarde voor deze case van het switch statement.
                yield "...";
            }
        };
        
        System.out.println(person + " was a " + title);
    }
}