package se2.bar.Materialien;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import se2.bar.Fachwerte.BestellStatus;

public class Bestellung
{
    private Map<Produkt, Integer> _produkte;
    private BestellStatus _status;

    public Bestellung()
    {
        super();
        this._produkte = new HashMap<>();
        _status = BestellStatus.BESTELLT;
    }

    public void fuegeProduktHinzu(Produkt bezeichnung, int anzahl)
    {
        if (_produkte.containsKey(bezeichnung))
        {
            int korrekteAnzahl = _produkte.get(bezeichnung);
            korrekteAnzahl += anzahl;
            _produkte.put(bezeichnung, korrekteAnzahl);
        }
        else
        {
            _produkte.put(bezeichnung, anzahl);
        }
    }

    public HashMap<Produkt, Integer> gibProduktMengen()
    {
        return new HashMap<>(_produkte);
    }

}
