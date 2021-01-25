package oplossingen;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.RecordComponent;

// java --source 17 --enable-preview Opdracht6Records.java
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
        System.out.println("Fiets: " + fiets.id() + " is " + (fiets.eBike() ? "wel" : "geen") + " E-bike" + " isRecord " + fiets.getClass().isRecord());
	RecordComponent[] cs = Fiets.class.getRecordComponents();
        for (RecordComponent c : cs) {
            System.out.println(" >> " + c);
	}
    }

    private interface Voertuig {
        Id id();
    }
    
    private static record Id(String id){}

    private static record Auto(Id id,int pk) implements Voertuig { }

    private static record Fiets(Id id, boolean eBike) implements Voertuig { }

    private static List<Voertuig> getVoertuigen() {
        List<Voertuig> voertuigen = new ArrayList<>();
        voertuigen.add(new Auto(new Id("a5"), 19));
        voertuigen.add(new Fiets(new Id("f1"), true));
        return voertuigen;
    }
}
