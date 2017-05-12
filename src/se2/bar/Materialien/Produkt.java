package se2.bar.Materialien;

public class Produkt {

    private String _produktbezeichnung;
	private String _beschreibung;

	public Produkt(String produktbezeichnung, String beschreibung) {
		_produktbezeichnung = produktbezeichnung;
		_beschreibung = beschreibung;
	}
	
	

	public String gibBezeichnung() {
		return _produktbezeichnung;
	}



    @Override
    public String toString()
    {
        return _produktbezeichnung;
    }



    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((_beschreibung == null) ? 0 : _beschreibung.hashCode());
        result = prime * result + ((_produktbezeichnung == null) ? 0
                : _produktbezeichnung.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Produkt other = (Produkt) obj;
        if (_beschreibung == null)
        {
            if (other._beschreibung != null) return false;
        }
        else if (!_beschreibung.equals(other._beschreibung)) return false;
        if (_produktbezeichnung == null)
        {
            if (other._produktbezeichnung != null) return false;
        }
        else if (!_produktbezeichnung.equals(other._produktbezeichnung))
            return false;
        return true;
    }


}
