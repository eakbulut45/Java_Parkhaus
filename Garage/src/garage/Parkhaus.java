package garage;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus {

    // Attribute
    private int counter;
    private final List<List<String>> etage = new ArrayList<>();

    // Konstruktor
    public Parkhaus() {
    }

    // Methoden
    public void addParkplätze(int parkplatz) {
        etage.add(new ArrayList<>());
        for (int j = 0; j < parkplatz; j++) {
            etage.get(etage.size() - 1).add("frei");
        }

    }

    public void befahren(Fahrzeug fahrzeug) {
        for (int i = 0; i < etage.size(); i++) {
            for (int j = 0; j < etage.get(i).size(); j++) {
                if (etage.get(i).get(j).equals(fahrzeug.getNummernschild())) {
                    System.err.println(fahrzeug.getNummernschild() + " ist schon in der Garage!");
                    return;
                } else if (etage.get(i).get(j).equals("frei")) {
                    etage.get(i).remove(j);
                    etage.get(i).add(j, fahrzeug.getNummernschild());
                    System.out.println("Sie sind eingefahren!");
                    System.out.println(fahrzeug.getNummernschild() + " : Etage " + (i + 1) + " & Parkplatz " + (j + 1));
                    return;
                }
            }
        }
        System.err.println("Unsere Garage ist leider voll!");
    }
    public void verlassen(String fahrzeug) {
        for (int i = 0; i < etage.size(); i++) {
            for (int j = 0; j < etage.get(i).size(); j++) {
                if (etage.get(i).get(j).equals(fahrzeug) && !etage.get(i).get(j).equals("frei")) {
                    etage.get(i).remove(j);
                    etage.get(i).add(j, "frei");
                    System.out.println("Sie sind ausgefahren!");
                    return;
                }
            }
        }
        System.err.println("Es gibt kein Fahrzeug für: " + fahrzeug);
    }

    boolean abfrage(String abfrage) {
        for (int i = 0; i < etage.size(); i++) {
            for (int j = 0; j < etage.get(i).size(); j++) {
                if (etage.get(i).get(j).equals(abfrage) && !etage.get(i).get(j).equals("frei")) {
                    System.out.println(abfrage + " : Etage " + (i + 1) + " & Parkplatz " + (j + 1));
                    System.out.println("------------------------------------------------");
                    return true;
                }
            }
        }
        System.err.println("Es gibt kein Fahrzeug für: " + abfrage);
        System.out.println("------------------------------------------------");
        return false;
    }

    int freiParkplätze() {
        counter = 0;
        for (int i = 0; i < etage.size(); i++) {
            for (int j = 0; j < etage.get(i).size(); j++) {
                if (etage.get(i).get(j).equals("frei")) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
   // Getter
    public List<List<String>> getEtage() {
        return etage;
    }

}
