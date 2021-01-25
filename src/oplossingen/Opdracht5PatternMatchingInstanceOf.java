package oplossingen;

import java.util.ArrayList;
import java.util.List;

public class Opdracht5PatternMatchingInstanceOf {
    public static void main(String[] args) {
        List<Voertuig> voertuigen = getVoertuigen();
        for (Voertuig voertuig : voertuigen) {
            if (voertuig instanceof Auto auto) {
                printAuto(auto);
            } else if (voertuig instanceof Fiets fiets) {
                printFiets(fiets);
            }
        }
        printObject("Hallo wereld!");
        printObject(new Object());
    }

    private static void printObject(Object obj) {
        if (obj instanceof String str && !str.isBlank()) {
            System.out.println(str);
        }
    }

    private static void printAuto(Auto auto) {
        System.out.println("Auto: " + auto.getId() + " heeft " + auto.getPk() + "pk");
    }

    private static void printFiets(Fiets fiets) {
        System.out.println("Fiets: " + fiets.getId() + " is " + (fiets.isEBike() ? "wel" : "geen") + " E-bike");
    }

    private static abstract class Voertuig {
        private final String id;

        public Voertuig(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    private static class Auto extends Voertuig {
        private final int pk;

        public Auto(String id, int pk) {
            super(id);
            this.pk = pk;
        }

        public int getPk() {
            return pk;
        }
    }

    private static class Fiets extends Voertuig {
        private final boolean eBike;

        public Fiets(String id, boolean eBike) {
            super(id);
            this.eBike = eBike;
        }

        public boolean isEBike() {
            return eBike;
        }
    }

    private static List<Voertuig> getVoertuigen() {
        List<Voertuig> voertuigen = new ArrayList<>();
        voertuigen.add(new Auto("a1", 10));
        voertuigen.add(new Auto("a2", 56));
        voertuigen.add(new Auto("a3", 15));
        voertuigen.add(new Auto("a4", 14));
        voertuigen.add(new Auto("a5", 19));
        voertuigen.add(new Fiets("f1", true));
        voertuigen.add(new Fiets("f2", true));
        voertuigen.add(new Fiets("f3", true));
        voertuigen.add(new Fiets("f4", false));
        voertuigen.add(new Fiets("f5", false));
        voertuigen.add(new Fiets("f6", false));
        return voertuigen;
    }
}
