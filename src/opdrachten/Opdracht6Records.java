package opdrachten;

import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.List;

// java --source 17 --enable-preview Opdracht6Records.java
// FIXME: Convert to Record change extends to interface because records can not inherit
public class Opdracht6Records {
    public static void main(String[] args) {
        List<Voertuig> voertuigen = getVoertuigen();
        for (Voertuig voertuig : voertuigen) {
            if (voertuig instanceof Auto auto) {
                printAuto(auto);
            } else if (voertuig instanceof Fiets fiets) {
                printFiets(fiets);
            }
        }
    }

    private static void printAuto(Auto auto) {
        System.out.println("Auto: " + auto.id() + " heeft " + auto.pk() + "pk" + " isRecord " + auto.getClass().isRecord());
        RecordComponent[] cs = Auto.class.getRecordComponents();
        for (RecordComponent c : cs) {
            System.out.println(" >> " + c);
        }
    }

    private static void printFiets(Fiets fiets) {
        System.out.println(
                "Fiets: " + fiets.id() + " is " + (fiets.eBike() ? "wel" : "geen") + " E-bike" + " isRecord " + fiets.getClass()
                        .isRecord());
        RecordComponent[] cs = Fiets.class.getRecordComponents();
        for (RecordComponent c : cs) {
            System.out.println(" >> " + c);
        }
    }

    private static List<Voertuig> getVoertuigen() {
        List<Voertuig> voertuigen = new ArrayList<>();
        voertuigen.add(new Auto("a5", 19));
        voertuigen.add(new Fiets("f1", true));
        return voertuigen;
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
}

