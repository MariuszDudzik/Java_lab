package pracownicy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SkutecznoscTest {

    private Skutecznosc skutecznoscNiska;
    private Skutecznosc skutecznoscSrednia;

    @Before
    public void setUp() {
        skutecznoscNiska = new SNiska();
        skutecznoscSrednia = new SSrednia();
    }


    @Test
    public void testGetNazwaNiska() {
        assertEquals("NISKA", skutecznoscNiska.getNazwa());
    }

    @Test
    public void testGetSLiczbowoNiska() {
        assertEquals(60, skutecznoscNiska.getSLiczbowo());
    }

    @Test
    public void testGetNazwaSrednia() {
        assertEquals("SREDNIA", skutecznoscSrednia.getNazwa());
    }

    @Test
    public void testGetSLiczbowoSrednia() {
        assertEquals(90, skutecznoscSrednia.getSLiczbowo());
    }


    @Test
    public void testSetNazwa() {
        skutecznoscNiska.setNazwa("WYSOKA");
        assertEquals("WYSOKA", skutecznoscNiska.getNazwa());
    }

    @Test
    public void testSetSLiczbowo() {
        skutecznoscSrednia.setSLiczbowo(95);
        assertEquals(95, skutecznoscSrednia.getSLiczbowo());
    }

    
    @Test
    public void testSetNazwaForSNiska() {
        SNiska niska = new SNiska();
        niska.setNazwa("ŚREDNIA");
        assertEquals("ŚREDNIA", niska.getNazwa());
    }

    @Test
    public void testSetSLiczbowoForSNiska() {
        SNiska niska = new SNiska();
        niska.setSLiczbowo(50);
        assertEquals(50, niska.getSLiczbowo());
    }

    @Test
    public void testSetNazwaForSSrednia() {
        SSrednia srednia = new SSrednia();
        srednia.setNazwa("NISKA");
        assertEquals("NISKA", srednia.getNazwa());
    }

    @Test
    public void testSetSLiczbowoForSSrednia() {
        SSrednia srednia = new SSrednia();
        srednia.setSLiczbowo(85);
        assertEquals(85, srednia.getSLiczbowo());
    }
}