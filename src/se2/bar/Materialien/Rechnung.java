package se2.bar.Materialien;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import se2.bar.Fachwerte.Geldbetrag;

public class Rechnung
{
    private Map<Produkt, Integer> _gebuchteProdukte;
    private Tisch _tisch;
    private Preisliste _preisliste;

    public Rechnung(Tisch tisch, Preisliste preisliste)
    {
        _preisliste = preisliste;
        _gebuchteProdukte = new HashMap<>();
        _tisch = tisch;
    }

    public void fuegeBestellungHinzu(Bestellung bestellung)
    {
        HashMap<Produkt, Integer> produktMengen = bestellung.gibProduktMengen();
        for (Entry<Produkt, Integer> bestellPosition : produktMengen.entrySet())
        {
            if (_gebuchteProdukte.containsKey(bestellPosition.getKey()))
            {
                int korrekteAnzahl = _gebuchteProdukte
                    .get(bestellPosition.getKey());
                korrekteAnzahl += bestellPosition.getValue();
                _gebuchteProdukte.put(bestellPosition.getKey(), korrekteAnzahl);
            }
            else
            {
                _gebuchteProdukte.put(bestellPosition.getKey(),
                        bestellPosition.getValue());
            }
        }

    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(_tisch+"\nAnzahl\tProdukt\t\tPreis");
        for (Entry<Produkt, Integer> produktMenge : _gebuchteProdukte
            .entrySet())
        {
            Produkt produkt = produktMenge.getKey();
            Integer menge = produktMenge.getValue();
            sb.append("\n"+menge + "\t" + produkt + "\t\t" + gibPreis(produkt, menge));
        }
        sb.append("\nSumme" + "\t\t\t" + gibSumme());
        return sb.toString();

    }

    private Geldbetrag gibSumme()
    {
        Geldbetrag summe= new Geldbetrag(0);
        for (Entry<Produkt, Integer> produktMenge : _gebuchteProdukte.entrySet())
        {
            summe=summe.addiere(gibPreis(produktMenge.getKey(),produktMenge.getValue()));
        }
        return summe;
    }

    private Geldbetrag gibPreis(Produkt produkt, Integer menge)
    {
       return  _preisliste.gibPreis(produkt).multipliziere(menge);
    }

}
