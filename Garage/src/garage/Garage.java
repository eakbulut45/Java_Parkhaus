package garage;

import java.util.Scanner;

/**
 *
 * @author Enes Akbulut
 */
public class Garage {

    private static Scanner sc = new Scanner(System.in);
    private static String input;
    static Parkhaus ph = new Parkhaus();

    public static void main(String[] args) {

        //Diese sind die Anzahl der Etagen 
        ph.addParkplätze(8);  // Die Anzahl der Parkplätze für 1.Etage
        ph.addParkplätze(10);  // Die Anzahl der Parkplätze für 2.Etage
        ph.addParkplätze(12);  // Die Anzahl der Parkplätze für 3.Etage
     
        System.out.println("         -----HERZLICH WILKOMMEN-----");
        System.out.println("----------Das Parkhaus der Stadt Vence----------");

        while (true) {
            System.out.println("Ihr Auswahl: \n1- Der Verwalter des Parkhauses\n2- Die Fahrzeuge\n3- Exit");
            System.out.println("------------------------------------------------");

            input = sc.next();
            sc.nextLine();
            switch (input) {
                case "1":
                    verwalter();
                    break;
                case "2":
                    fahrer();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bitte geben Sie richtige Zahl!");
                    break;
            }

        }
    }

    private static void verwalter() {
        System.out.println("1- Die Position eines bestimmten Fahrzeugs\n2- Die Anzahl der noch freien Parkplätze\n3- Zurück");
        System.out.println("------------------------------------------------");
        input = sc.next();
        sc.nextLine();
        switch (input) {
            case "1":
                System.out.println("Geben Sie das Kennzeichen des befragten Fahrzeugs ein: ");
                String abfrage = sc.nextLine();
                ph.abfrage(abfrage);
                break;
            case "2":
                int x = ph.freiParkplätze();
                System.out.println("Die freie Parkplätze: " + x + "\n");
                ph.getEtage().forEach(n -> System.out.println(n));
                System.out.println("------------------------------------------------");
                break;
            case "3":
                break;
            default:
                System.err.println("Bitte geben Sie richtige Zahl!");
                break;
        }
    }

    private static void fahrer() {
        System.out.println("1- Befahren\n2- Verlassen\n3- Zurück");
        System.out.println("------------------------------------------------");
        input = sc.next();
        sc.nextLine();
        switch (input) {
            case "1":
                System.out.println("1- Auto\n2- Motorrad");
                System.out.println("------------------------------------------------");
                input = sc.next();
                sc.nextLine();

                if (input.equals("1")) {
                    System.out.println("Geben Sie das Kennzeichen Ihres Autos ein: ");
                    String kennzeichen = sc.nextLine();
                    ph.befahren(new Autos(kennzeichen));
                    System.out.println("------------------------------------------------");
                    break;
                } else if (input.equals("2")) {
                    System.out.println("Geben Sie das Kennzeichen Ihres Motorrads ein: ");
                    String kennzeichen = sc.nextLine();
                    ph.befahren(new Motorräder(kennzeichen));
                    System.out.println("------------------------------------------------");
                    break;
                }else{
                    System.err.println("Bitte geben Sie richtige Zahl!");
                }
                break;

            case "2":
                System.out.println("Geben Sie Ihr Kennzeichen ein: ");
                String verlassenKenn = sc.nextLine();
                ph.verlassen(verlassenKenn);
                System.out.println("------------------------------------------------");
                break;
            case "3":
                break;
            default:
                System.err.println("Bitte geben Sie richtige Zahl!");
                break;
        }
    }
}
