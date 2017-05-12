package se2.bar;

import java.util.Spliterators.AbstractSpliterator;

import se2.bar.Fachwerte.Geldbetrag;
import se2.bar.Materialien.Bestellung;
import se2.bar.Materialien.Preisliste;
import se2.bar.Materialien.Produkt;
import se2.bar.Materialien.Rechnung;
import se2.bar.Materialien.Tisch;

public class StartUp {

	private static final Produkt COLA=new Produkt("Cola", "Schlecht für die Zähne, aber coffeinhaltig und lecker.");
	private static final Produkt FANTA=new Produkt("Fanta", "Schlecht für die Zähne, aber gelb und lecker.");
	private static final Produkt SPRITE=new Produkt("Sprite", "Schlecht für die Zähne, aber schön durchsichtig.");
	private static final Produkt WASSER=new Produkt("Wasser", "Schmeckt nach nichts, löscht aber den Durst");
	private static final Produkt ASTRA=new Produkt("Astra", "Schlecht fürs Gehirn aber gut für die Stimmung.");
	private static final Tisch tisch1= new Tisch(1);
	
	public static void main(String[] args) {
		Preisliste preisliste = erstellePreisliste();
		Bestellung bestellung= new Bestellung();
		bestellung.fuegeProduktHinzu(FANTA, 1);
		bestellung.fuegeProduktHinzu(COLA, 2);
		bestellung.fuegeProduktHinzu(ASTRA, 1);
		
		
		Rechnung rechnung= new Rechnung(tisch1, preisliste);
		
		
		rechnung.fuegeBestellungHinzu(bestellung);
		System.out.println(rechnung);
		
	}

	private static Preisliste erstellePreisliste() {
		Preisliste preisliste= new Preisliste();
		preisliste.fuegeProduktHinzu(WASSER, new Geldbetrag(200));
		preisliste.fuegeProduktHinzu(COLA,new Geldbetrag(250));
		preisliste.fuegeProduktHinzu(FANTA,new Geldbetrag(250));
		preisliste.fuegeProduktHinzu(SPRITE,new Geldbetrag(250));
		preisliste.fuegeProduktHinzu(ASTRA,new Geldbetrag(320));
		return preisliste;
	}

}
