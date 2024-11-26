package pracownicy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdresTest {

    private Adres adres;

    @Before
    public void setUp() {
        adres = new Adres("Ulica A", "10", "1", "00-100", "Warszawa");
    }

    @Test
    public void testGetUlica() {
        assertEquals("Ulica A", adres.getUlica());
    }

    @Test
    public void testGetNumerDomu() {
        assertEquals("10", adres.getNumerDomu());
    }

    @Test
    public void testGetNumerMieszkania() {
        assertEquals("1", adres.getNumerMieszkania());
    }

    @Test
    public void testGetKodPocztowy() {
        assertEquals("00-100", adres.getKodPocztowy());
    }

    @Test
    public void testGetMiasto() {
        assertEquals("Warszawa", adres.getMiasto());
    }

    @Test
    public void testSetUlica() {
        adres.setUlica("Ulica B");
        assertEquals("Ulica B", adres.getUlica());
    }

    @Test
    public void testSetNumerDomu() {
        adres.setNumerDomu("20");
        assertEquals("20", adres.getNumerDomu());
    }

    @Test
    public void testSetNumerMieszkania() {
        adres.setNumerMieszkania("2");
        assertEquals("2", adres.getNumerMieszkania());
    }

    @Test
    public void testSetKodPocztowy() {
        adres.setKodPocztowy("01-200");
        assertEquals("01-200", adres.getKodPocztowy());
    }

    @Test
    public void testSetMiasto() {
        adres.setMiasto("Kraków");
        assertEquals("Kraków", adres.getMiasto());
    }

    @Test
    public void testGetCalyAdres() {
        String oczekiwanyAdres = "Adres: Ulica A 10/1, 00-100 Warszawa";
        assertEquals(oczekiwanyAdres, adres.getCalyAdres());
    }
}