package pracownicy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PracownikTest {

    private Pracownik pracownik;
    private Biurowy biurowy;
    private Fizyczny fizyczny;
    private Handlowiec handlowiec;


    @Before
    public void setUp() {

        pracownik = new Pracownik("Jan", "Kowalski", 1985, 10, "Ulica A", "10", "1", "00-100", "Warszawa");
        biurowy = new Biurowy("Anna", "Nowak", 1990, 5, "Ulica B", "20", "2", "01-200", "Kraków", 130);
        
        fizyczny = new Fizyczny("Tomasz", "Wójcik", 1980, 15, "Ulica C", "15", "3", "02-300", "Wrocław", 85);
        
        handlowiec = new Handlowiec("Krzysztof", "Zieliński", 1978, 20, "Ulica E", "30", "5", "04-500", "Gdańsk", 150, "WYSOKA");
    }
    @Test
    public void testGetIdPracownika() {    
        assertEquals(12, handlowiec.getIdPracownika());
      
    }

    @Test
    public void testGetImie() {
        assertEquals("Jan", pracownik.getImie());
    }

    @Test
    public void testSetImie() {
        pracownik.setImie("Ewa");
        assertEquals("Ewa", pracownik.getImie());
    }

    @Test
    public void testGetNazwisko() {
        assertEquals("Kowalski", pracownik.getNazwisko());
    }

    @Test
    public void testSetNazwisko() {
        pracownik.setNazwisko("Nowak");
        assertEquals("Nowak", pracownik.getNazwisko());
    }

    @Test
    public void testGetRokUrodzenia() {
        assertEquals(1985, pracownik.getRokUrodzenia());
    }

    @Test
    public void testSetRokUrodzenia() {
        pracownik.setRokUrodzenia(1990);
        assertEquals(1990, pracownik.getRokUrodzenia());
    }

    @Test
    public void testGetDoswiadczenie() {
        assertEquals(10, pracownik.getDoswiadczenie());
    }

    @Test
    public void testSetDoswiadczenie() {
        pracownik.setDoswiadczenie(15);
        assertEquals(15, pracownik.getDoswiadczenie());
    }

    @Test
    public void testGetIntelekt() {
        assertEquals(130, biurowy.getIntelekt());
    }

    @Test
    public void testSetIntelektValid() {
        biurowy.setIntelekt(140);
        assertEquals(140, biurowy.getIntelekt());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIntelektInvalidLow() {
        biurowy.setIntelekt(60); 
        assertEquals(false, false);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetIntelektInvalidHigh() {
        biurowy.setIntelekt(160);
        assertEquals(false, false);
    }

    @Test
    public void testCheckIntelektValid() {
        biurowy.checkIntelekt(100);  // Nie powinno być wyjątku
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIntelektInvalidLow() {
        biurowy.checkIntelekt(60);
        assertEquals(false, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIntelektInvalidHigh() {
        biurowy.checkIntelekt(160);
        assertEquals(false, false);
    }

    @Test
    public void testGetSilaFizyczna() {
        assertEquals(85, fizyczny.getSilaFizyczna());
    }

    @Test
    public void testSetSilaFizyczna() {
        fizyczny.setSilaFizyczna(90);
        assertEquals(90, fizyczny.getSilaFizyczna());
    }

    @Test
    public void testCheckSilaFizycznaValid() {
            fizyczny.checkSilaFizyczna(50);
        }
    

    @Test(expected = IllegalArgumentException.class)
    public void testCheckSilaFizycznaZaniska() {
            fizyczny.checkSilaFizyczna(0);
            assertEquals("Sila fizyczna musi być w zakresie od 1 do 100.", false);
        }

    @Test (expected = IllegalArgumentException.class)
    public void testCheckSilaFizycznaZaWysoka() {
            fizyczny.checkSilaFizyczna(101);
            assertEquals("Sila fizyczna musi być w zakresie od 1 do 100.", false);
        }

        @Test
        public void testGetProwizja() {
            handlowiec.setProwizja(500);
            assertEquals(500, handlowiec.getProwizja());
        }
    
    
        @Test
        public void testSetProwizja() {
            handlowiec.setProwizja(1000);
            assertEquals(1000, handlowiec.getProwizja());
        }
   
}