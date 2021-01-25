package oplossingen;

import java.util.ArrayList;
import java.util.List;

// java --source 17 --enable-preview Opdracht7SealedClasses.java
public class Opdracht7SealedClasses {
   
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
        System.out.println("Auto: " + auto.getId() + " heeft " + auto.getPk() + "pk");
    }

    private static void printFiets(Fiets fiets) {
        System.out.println("Fiets: " + fiets.getId() + " is " + (fiets.isEBike() ? "wel" : "geen") + " E-bike");
    }

    public sealed interface Service permits Auto {
    	int getMaxServiceIntervalInMonths();

    	default int getMaxDistanceBetweenServicesInKilometers() {
    	    return 100000;
    	}
    }

    private static sealed abstract class Voertuig permits Auto, Fiets {
        private final String id;

        public Voertuig(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    
    private static  final class Auto extends Voertuig implements Service {
        private final int pk;

        public Auto(String id, int pk) {
            super(id);
            this.pk = pk;
        }

        public int getPk() {
            return pk;
        }
        
        public int getMaxServiceIntervalInMonths() {
    	    return 200000;
    	}
    }

    private static non-sealed class Fiets extends Voertuig {
        private final boolean eBike;

        public Fiets(String id, boolean eBike) {
            super(id);
            this.eBike = eBike;
        }

        public boolean isEBike() {
            return eBike;
        }
    }
    
    private static final class LigFiets extends Fiets {
        public LigFiets(String id, boolean eBike) {
            super(id, eBike);
        }
    }
    

    private static List<Voertuig> getVoertuigen() {
        List<Voertuig> voertuigen = new ArrayList<>();
        voertuigen.add(new Auto("a1", 10));
        voertuigen.add(new Fiets("f1", true));
        voertuigen.add(new LigFiets("l1", false));
        return voertuigen;
    }
   

}

