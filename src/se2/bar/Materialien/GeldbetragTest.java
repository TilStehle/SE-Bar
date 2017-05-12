package se2.bar.Materialien;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se2.bar.Fachwerte.Geldbetrag;


/**
 * @author SE2-Team
 * @version Maerz 2010
 * 
 */
public class GeldbetragTest
{

    @Test
    public final void testGeldbetrag()
    {
        Geldbetrag betrag = new Geldbetrag(100);
        assertEquals(1, betrag.gibEurobetrag());
        assertEquals(0, betrag.gibCentbetrag());
        assertEquals("1,00", betrag.gibFormatiertenString());

        betrag = new Geldbetrag(0);
        assertEquals(0, betrag.gibEurobetrag());
        assertEquals(0, betrag.gibCentbetrag());
        assertEquals("0,00", betrag.gibFormatiertenString());

        betrag = new Geldbetrag(99);
        assertEquals(0, betrag.gibEurobetrag());
        assertEquals(99, betrag.gibCentbetrag());
        assertEquals("0,99", betrag.gibFormatiertenString());

        betrag = new Geldbetrag(101);
        assertEquals(1, betrag.gibEurobetrag());
        assertEquals(1, betrag.gibCentbetrag());
        assertEquals("1,01", betrag.gibFormatiertenString());
    }

    @Test
    public final void testEqualsHashcode()
    {
        Geldbetrag betrag1 = new Geldbetrag(100);
        Geldbetrag betrag2 = new Geldbetrag(100);
        assertTrue(betrag1.equals(betrag2));
        assertTrue(betrag1.hashCode() == betrag2.hashCode());
        
        Geldbetrag betrag3 = new Geldbetrag(101);
        assertFalse(betrag1.equals(betrag3));
        assertFalse(betrag1.hashCode() == betrag3.hashCode());
        
        Geldbetrag betrag4 = new Geldbetrag(1000);
        assertFalse(betrag1.equals(betrag4));
        assertFalse(betrag1.hashCode() == betrag4.hashCode());
    }
}
