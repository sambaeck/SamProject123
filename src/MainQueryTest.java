import model.GebeurtenisType;
import model.Wedstrijd;
import persistence.dao.WedstrijdDAO;

import java.util.List;
import java.util.Scanner;

/**
 * Created by OEM on 5/08/2015.
 */
public class MainQueryTest {

    public static void main(String[] args) {
    	//Speler inlezen
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Speler naam: ");
    	String speler = scanner.nextLine();
    	
    	//Gebeurtenistype inlezen
    	System.out.println("Selecteer gebeurtenistype:");
    	System.out.println("0: " + GebeurtenisType.DOELPUNT);
    	System.out.println("1: " + GebeurtenisType.GELE_KAART);
    	System.out.println("2: " + GebeurtenisType.RODE_KAART);
    	System.out.println("3: " + GebeurtenisType.VERVANGING);
    	int selectedTypeNumber = Integer.parseInt(scanner.nextLine());
    	GebeurtenisType type = null;
    	switch(selectedTypeNumber){
    	case 0: type = GebeurtenisType.DOELPUNT; break;
    	case 1: type = GebeurtenisType.GELE_KAART; break;
    	case 2: type = GebeurtenisType.RODE_KAART; break;
    	case 3: type = GebeurtenisType.VERVANGING; break;
    	}
        
    	scanner.close();
    	
    	//Resultaten afdrukken
        System.out.println("Wedstrijden zoeken voor speler: " + speler + " met gebeurtenis: " + type );
        
        List<Wedstrijd> wedstrijden = new WedstrijdDAO().toonWedstrijden("CTQBEUVP", GebeurtenisType.DOELPUNT);
        System.out.println(wedstrijden.size() + " GEVONDEN!");
    }
}
