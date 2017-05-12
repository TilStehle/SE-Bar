package se2.bar.Materialien;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se2.bar.Fachwerte.Geldbetrag;

public class Preisliste
{
    private Map<Produkt, Geldbetrag> _preiszuordnung;

    public Preisliste()
    {
        _preiszuordnung = new HashMap<>();
    }

    public void fuegeProduktHinzu(Produkt produkt, Geldbetrag preis)
    {
        _preiszuordnung.put(produkt, preis);
    }

    

    public boolean istGelistet(Produkt produkt)
    {
        return _preiszuordnung.containsKey(produkt);
    }

    /**
     * 
     * @require: istGelistet(produkt)
     * @param produkt Produkt für das der Preis nachgeschlagen werden soll
     * @return Preis für das übegebene produkt
     */
    public  Geldbetrag gibPreis(Produkt produkt)
    {
       assert istGelistet(produkt) : "Vorbedingung verletzt: istGelistet(produkt)";
       return _preiszuordnung.get(produkt);
    }

}
