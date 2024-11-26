package pracownicy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DanepracownikaTest {

    private DanePracownika danePracownika;
    private DanePracownika danePracownika1;

    @Before
    public void setUp() {
        danePracownika = new DanePracownika();
        danePracownika1 = new DanePracownika();
        danePracownika1.setHandlowiec("Krzysztof", "Zieliński", 1978, 20, 
                                          "Ulica A", "10", "1", "00-100", "Warszawa", 500, "SREDNIA");
        }


    @Test
    public void testSetHandlowiec() {
        danePracownika.setHandlowiec("Krzysztof", "Zieliński", 1978, 20, 
                                    "Ulica A", "10", "1", "00-100", "Warszawa", 500, "SREDNIA");
        assertEquals("Krzysztof", danePracownika.getImie());
    }


    @Test
    public void testSetFizyczny() {
        danePracownika.setFizyczny("Tomasz", "Wójcik", 1980, 15, 
                                   "Ulica B", "20", "2", "01-200", "Kraków", 85);
        assertEquals("Wójcik", danePracownika.getNazwisko());
    }

    @Test
    public void testBiurowy() {
        danePracownika.setBiurowy("Anna", "Nowak", 1990, 10, 
                                  "Ulica C", "30", "3", "02-300", "Gdańsk", 130);
        assertEquals("Anna", danePracownika.getImie());
    }

    @Test
    public void testGetImie() {
        assertEquals("Krzysztof", danePracownika1.getImie());
    }

    @Test
    public void testGetNazwisko() {
        assertEquals("Zieliński", danePracownika1.getNazwisko());
    }

    @Test
    public void testGetRokUrodzenia() {
        assertEquals(1978, danePracownika1.getRokUrodzenia());
    }

    @Test
    public void testGetDoswiadczenie() {
        assertEquals(20, danePracownika1.getDoswiadczenie());
    }

    @Test
    public void testGetUlica() {
        assertEquals("Ulica A", danePracownika1.getUlica());
    }

    @Test
    public void testGetNumerDomu() {
        assertEquals("10", danePracownika1.getNumerDomu());
    }

    @Test
    public void testGetNumerMieszkania() {
        assertEquals("1", danePracownika1.getNumerMieszkania());
    }

    @Test
    public void testGetKodPocztowy() {
        assertEquals("00-100", danePracownika1.getKodPocztowy());
    }

    @Test
    public void testGetMiasto() {
        assertEquals("Warszawa", danePracownika1.getMiasto());
    }

    @Test
    public void testGetProwizja() {
        assertEquals(500, danePracownika1.getProwizja());
    }

    @Test
    public void testGetSkutecznosc() {
        assertEquals("SREDNIA", danePracownika1.getSkutecznosc());
    }
}