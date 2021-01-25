package opdrachten;

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
        // FIXME - Schrijf mij om naar een Switch Expression. Probeer ook het 'yield' statement te gebruiken.
        switch (person) {
            case Dali:
            case Picasso:
                System.out.println(person + " was a painter");
                break;
            case Mozart:
            case Prokofiev:
                System.out.println(person + " was a composer");
                break;
            case Goethe:
            case Dostoevsky:
                System.out.println(person + " was a writer");
                break;
            default:
                System.out.println("I don't know this person " + person);
        }
    }
}