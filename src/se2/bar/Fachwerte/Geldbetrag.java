package se2.bar.Fachwerte;


/**
 * Ein Geldbetrag enthält, am Beispiel des Euros, Werte für ganze Euro- und
 * ganze Cent-Beträge. Die toString()-Methode gibt den internen zustand in der
 * Form "10,21" aus.
 * 
 * @author SE2-Team
 * @version März 2010
 */
public class Geldbetrag
{

    private int _euroBetrag;
    private int _centBetrag;

    /**
     * 
     * @param eurocent
     * @require eurocent >= 0;
     */
    public Geldbetrag(int eurocent)
    {
        assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >= 0";
        _euroBetrag = eurocent / 100;
        _centBetrag = eurocent % 100;
    }
    
    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
        int cents=summand1.gibCentSumme()+summand2.gibCentSumme();
        return new Geldbetrag(cents);
        
    }
    public  Geldbetrag multipliziere(int faktor)
    {
        
        return new Geldbetrag(this.gibCentSumme()*faktor);
        
    }
    
    private int gibCentSumme()
    {
        return this._euroBetrag*100+this._centBetrag;
        
    }

    /**
     * Gibt den Eurobetrag ohne Cent zurück.
     * 
     * @return
     */
    public int gibEurobetrag()
    {
        return _euroBetrag;
    }

    /**
     * Gibt den Centbetrag ohne Eurobetrag zurück.
     */
    public int gibCentbetrag()
    {
        return _centBetrag;
    }

    /**
     * Liefert einen formatierten String des Geldbatrags in der Form "10,23"
     * zurück.
     * 
     * @return eine String-Repräsentation.
     */
    public String gibFormatiertenString()
    {
        return _euroBetrag + "," + gibFormatiertenCentbetrag();
    }

    /**
     * Liefert einen zweistelligen Centbetrag zurück.
     * 
     * @return eine String-Repräsentation des Centbetrags.
     */
    private String gibFormatiertenCentbetrag()
    {
        StringBuilder ergebnis = new StringBuilder();
        if (_centBetrag < 10)
        {
            ergebnis.append(0);
        }
        ergebnis.append(_centBetrag);
        return ergebnis.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime + _centBetrag;
        result = prime * result + _euroBetrag;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if ((obj != null) && (obj instanceof Geldbetrag))
        {
            Geldbetrag other = (Geldbetrag) obj;
            result = (_centBetrag == other._centBetrag)
                    && (_euroBetrag == other._euroBetrag);
        }
        return result;
    }

    @Override
    public String toString()
    {
        return gibFormatiertenString();
    }

	public Geldbetrag addiere(Geldbetrag summand) {
	    int cents=this.gibCentSumme()+summand.gibCentSumme();
        return new Geldbetrag(cents);
      
	}
}
