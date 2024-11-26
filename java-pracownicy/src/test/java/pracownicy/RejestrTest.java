package pracownicy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RejestrTest {

    private Rejestr rejestr;

    @Before
    public void setUp() {
        rejestr = new Rejestr();    
    }

    @Test
    public void testdodajBiurowy() {
        String imie = "Jan";
        String nazwisko = "Kowalski";
        int rokUrodzenia = 1985;
        int doswiadczenie = 10;
        String ulica = "Ulica A";
        String numerDomu = "12";
        String numerMieszkania = "3";
        String kodPocztowy = "00-100";
        String miasto = "Warszawa";
        int intelekt = 120;

        rejestr.dodajBiurowy(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto, intelekt);
        assertEquals(1, rejestr.getRejestrPracownikow().size());
    }

    @Test
    public void testdodajFizyczny() {
        String imie = "Anna";
        String nazwisko = "Nowak";
        int rokUrodzenia = 1990;
        int doswiadczenie = 15;
        String ulica = "Ulica b";
        String numerDomu = "15";
        String numerMieszkania = "6";
        String kodPocztowy = "00-200";
        String miasto = "Kraków";
        int silaFizyczna = 80;

        rejestr.dodajFizyczny(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto, silaFizyczna);
        assertEquals(1, rejestr.getRejestrPracownikow().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testdodajFizycznyBlad() {
        String imie = "Anna";
        String nazwisko = "Nowak";
        int rokUrodzenia = 1990;
        int doswiadczenie = 15;
        String ulica = "Ulica b";
        String numerDomu = "15";
        String numerMieszkania = "6";
        String kodPocztowy = "00-200";
        String miasto = "Kraków";
        int silaFizyczna = 110;

        rejestr.dodajFizyczny(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto, silaFizyczna);
        assertEquals(false, false);
    }

    @Test
    public void testdodajHandlowiec() {
        String imie = "Marek";
        String nazwisko = "Nowak";
        int rokUrodzenia = 1950;
        int doswiadczenie = 15;
        String ulica = "Ulica b";
        String numerDomu = "15";
        String numerMieszkania = "6";
        String kodPocztowy = "00-200";
        String miasto = "Bystra";
        int prowizja = 10;
        String skutecznosc = "NISKA";

        rejestr.dodajHandlowiec(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto, prowizja, skutecznosc);
        assertEquals(1, rejestr.getRejestrPracownikow().size());
    }
    
    @Test
    public void testSprawdzTypPracownika_PoprawnyTypB() {
        assertEquals(true, rejestr.sprawdzTypPracownika('B'));
    }

    @Test
    public void testSprawdzTypPracownika_PoprawnyTypF() {
        assertEquals(true, rejestr.sprawdzTypPracownika('F'));
    }

    @Test
    public void testSprawdzTypPracownika_PoprawnyTypH() {
        assertEquals(true, rejestr.sprawdzTypPracownika('H'));
    }

    @Test
    public void testSprawdzTypPracownika_PoprawnyTypMaleLitery() {
        assertEquals(true, rejestr.sprawdzTypPracownika('b')); 
    }

    @Test
    public void testSprawdzTypPracownika_NiepoprawnyTyp() {
        assertEquals(false, rejestr.sprawdzTypPracownika('X'));
    }

    @Test
    public void testSprawdzTypPracownika_NiepoprawnyTypCyfra() {
        assertEquals(false, rejestr.sprawdzTypPracownika('1'));
    }

    @Test
    public void testSprawdzTypPracownika_NiepoprawnyTypZnakSpecjalny() {
        assertEquals(false, rejestr.sprawdzTypPracownika('@'));
    }

    @Test
    public void testOkreslTypPracownikow_PoprawnyTypB() {
        rejestr.okreslTypPracownikow('B');
        assertEquals(1, rejestr.getTypyPracownikow().size());
    }

    @Test
    public void testDodajPracownikow_WieleTypow() {
        rejestr.okreslTypPracownikow('B');
        rejestr.okreslTypPracownikow('F');
        rejestr.okreslTypPracownikow('H');
        DanePracownika dane = new DanePracownika();
        dane.setBiurowy("Jan", "Kowalski", 1985, 10, "Ulica A", "12", "3", "00-100", "Warszawa", 120);
        dane.setFizyczny("Anna", "Nowak", 1990, 15, "Ulica B", "15", "6", "00-200", "Kraków", 80);
        dane.setHandlowiec("Marek", "Nowak", 1950, 15, "Ulica b", "15", "6", "00-200", "Bystra", 10, "NISKA");
        rejestr.dodajPracownikow(dane);
        assertEquals(3, rejestr.getRejestrPracownikow().size());
    }

    @Test
    public void testDodajPracownikow_WieleTypow1() {
        rejestr.okreslTypPracownikow('B');
        rejestr.okreslTypPracownikow('F');
        rejestr.okreslTypPracownikow('H');
        DanePracownika dane = new DanePracownika();
        dane.setBiurowy("Jan", "Kowalski", 1985, 10, "Ulica A", "12", "3", "00-100", "Warszawa", 120);
        dane.setFizyczny("Anna", "Nowak", 1990, 15, "Ulica B", "15", "6", "00-200", "Kraków", 80);
        dane.setHandlowiec("Marek", "Nowak", 1950, 15, "Ulica b", "15", "6", "00-200", "Bystra", 10, "NISKA");
        rejestr.dodajPracownikow(dane);
        assertTrue(rejestr.getRejestrPracownikow().get(1) instanceof Fizyczny);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajPracownikow_NiepoprawnyTyp() {
        rejestr.okreslTypPracownikow('X');
        DanePracownika dane = new DanePracownika();
        dane.setHandlowiec("Marek", "Nowak", 1950, 15, "Ulica b", "15", "6", "00-200", "Bystra", 10, "NISKA");
        rejestr.dodajPracownikow(dane);
        assertEquals(false, false);
    }

    @Test
    public void testDodajPracownikow_BrakTypow() {
        DanePracownika dane = new DanePracownika();
        dane.setHandlowiec("Marek", "Nowak", 1950, 15, "Ulica b", "15", "6", "00-200", "Bystra", 10, "NISKA");
        rejestr.dodajPracownikow(dane);
        assertEquals(0, rejestr.getRejestrPracownikow().size());
    }

    @Test
    public void testUsunPracownika_ZPoprawnymId() {

        rejestr.dodajBiurowy("Jan", "Kowalski", 1985, 10, "Ulica A", "12", "3", "00-100", "Warszawa", 120);
        rejestr.dodajFizyczny("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 80);
        rejestr.dodajHandlowiec("Marek", "Kowalski", 1980, 15, "Ulica C", "8", "2", "00-300", "Wrocław", 20, "NISKA");
        int idDoUsuniecia = rejestr.getRejestrPracownikow().get(0).getIdPracownika();
        rejestr.usunPracownika(idDoUsuniecia);
        assertEquals(2, rejestr.getRejestrPracownikow().size());  
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsunPracownika_ZNiepoprawnymId() {
        int nieistniejaceId = 999;
        rejestr.usunPracownika(nieistniejaceId);
        assertEquals(false, false);
    }    

    @Test
    public void testWyswietlPoDoswiadczeniu_Sortowanie() {
        rejestr.dodajBiurowy("Jan", "Kowalski", 1985, 10, "Ulica A", "12", "3", "00-100", "Warszawa", 120);
        rejestr.dodajFizyczny("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 70);
        rejestr.dodajHandlowiec("Marek", "Kowalski", 1980, 15, "Ulica C", "8", "2", "00-300", "Wrocław", 20, "NISKA");
        rejestr.dodajBiurowy("Ewa", "Zielińska", 1995, 2, "Ulica D", "21", "5", "00-400", "Poznań", 140);
        rejestr.dodajFizyczny("Paweł", "Kaczmarek", 1988, 7, "Ulica E", "33", "7", "00-500", "Gdańsk", 90);
        List<String> wynik = rejestr.wyswietlPoDoswiadczeniu();

        assertEquals("Ewa Zielińska - 2", wynik.get(4));
    }

    @Test
    public void testWyswietlPoWieku_Sortowanie() {
        rejestr.dodajBiurowy("Jan", "Kowalski", 1985, 10, "Ulica A", "12", "3", "00-100", "Warszawa", 120);
        rejestr.dodajFizyczny("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 80);
        rejestr.dodajHandlowiec("Marek", "Kowalski", 1980, 15, "Ulica C", "8", "2", "00-300", "Wrocław", 20, "NISKA");
        rejestr.dodajBiurowy("Ewa", "Zielińska", 1995, 2, "Ulica D", "21", "5", "00-400", "Poznań", 140);
        rejestr.dodajFizyczny("Paweł", "Kaczmarek", 1988, 7, "Ulica E", "33", "7", "00-500", "Gdańsk", 90);
        List<String> wynik = rejestr.wyswietlPoWieku();

        int aktualnyRok = LocalDate.now().getYear();  
        assertEquals("Marek Kowalski - " + (aktualnyRok - 1980), wynik.get(4));
    }

    @Test
    public void testWyswietlPoNazwisku_Sortowanie() {
        rejestr.dodajBiurowy("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 120);
        rejestr.dodajFizyczny("Marek", "Kowalski", 1985, 10, "Ulica A", "10", "2", "00-100", "Warszawa", 80);
        rejestr.dodajHandlowiec("Ewa", "Nowak", 1995, 2, "Ulica C", "5", "3", "00-300", "Gdańsk", 30, "NISKA");
        rejestr.dodajBiurowy("Jan", "Kowalski", 1980, 15, "Ulica D", "8", "1", "00-400", "Poznań", 130);
        List<String> wynik = rejestr.wyswietlPoNazwiskuImieniu();
        assertEquals("Nowak Anna", wynik.get(2));
    }

    @Test
    public void testWyswietlPracownikowZmiasta_Poznan() {

        rejestr.dodajBiurowy("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 120);
        rejestr.dodajFizyczny("Marek", "Kowalski", 1985, 10, "Ulica A", "10", "2", "00-100", "Poznań", 80);
        rejestr.dodajHandlowiec("Ewa", "Nowak", 1995, 2, "Ulica C", "5", "3", "00-300", "Gdańsk", 30, "NISKA");
        rejestr.dodajBiurowy("Jan", "Kowalski", 1980, 15, "Ulica D", "8", "1", "00-400", "Poznań", 130);
        List<String> wynik = rejestr.wyswietlPracownikowZmiasta("Poznań");

        List<String> oczekiwanyWynik = new ArrayList<>();
        oczekiwanyWynik.add("Jan Kowalski - Poznań");
        oczekiwanyWynik.add("Marek Kowalski - Poznań");
        assertEquals(oczekiwanyWynik, wynik);
    }

    @Test
    public void testWyswietlPracownikowZmiasta_BrakWynikow() {
        rejestr.dodajBiurowy("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 120);
        rejestr.dodajFizyczny("Marek", "Kowalski", 1985, 10, "Ulica A", "10", "2", "00-100", "Poznań", 80);
        rejestr.dodajHandlowiec("Ewa", "Nowak", 1995, 2, "Ulica C", "5", "3", "00-300", "Gdańsk", 30, "NISKA");
        rejestr.dodajBiurowy("Jan", "Kowalski", 1980, 15, "Ulica D", "8", "1", "00-400", "Poznań", 130);
        List<String> wynik = rejestr.wyswietlPracownikowZmiasta("Toruń");
        List<String> oczekiwanyWynik = new ArrayList<>();
        assertEquals(oczekiwanyWynik, wynik);
    }

    @Test
    public void testWyswietlPracownikowZmiasta_NieznanaWielkoscLiter() {
        rejestr.dodajBiurowy("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 120);
        rejestr.dodajFizyczny("Marek", "Kowalski", 1985, 10, "Ulica A", "10", "2", "00-100", "Poznań", 80);
        rejestr.dodajHandlowiec("Ewa", "Nowak", 1995, 2, "Ulica C", "5", "3", "00-300", "Gdańsk", 30, "NISKA");
        rejestr.dodajBiurowy("Jan", "Kowalski", 1980, 15, "Ulica D", "8", "1", "00-400", "Poznań", 130);
        List<String> wynik = rejestr.wyswietlPracownikowZmiasta("kraków");

        List<String> oczekiwanyWynik = new ArrayList<>();
        oczekiwanyWynik.add("Anna Nowak - Kraków");
        assertEquals(oczekiwanyWynik, wynik);
    }
  
    @Test
    public void testWyswietlPracownikowWrtosc_PoprawneObliczenia() {
        
        rejestr.dodajBiurowy("Anna", "Nowak", 1990, 5, "Ulica B", "15", "6", "00-200", "Kraków", 120);
        rejestr.dodajFizyczny("Marek", "Kowalski", 1985, 10, "Ulica A", "10", "2", "00-100", "Poznań", 80);
        rejestr.dodajHandlowiec("Ewa", "Nowak", 1995, 2, "Ulica C", "5", "3", "00-300", "Gdańsk", 30, "NISKA");
        rejestr.dodajBiurowy("Jan", "Kowalski", 1980, 15, "Ulica D", "8", "1", "00-400", "Poznań", 130);
        List<String> wynik = rejestr.wyswietlPracownikowWrtosc();

        List<String> oczekiwanyWynik = new ArrayList<>();
        oczekiwanyWynik.add("Jan Kowalski - Biurowy 1950");
        oczekiwanyWynik.add("Marek Kowalski - Fizyczny 20");
        oczekiwanyWynik.add("Anna Nowak - Biurowy 600"); 
        oczekiwanyWynik.add("Ewa Nowak - Handlowiec 120");
        
        assertEquals(oczekiwanyWynik, wynik);
    }

}