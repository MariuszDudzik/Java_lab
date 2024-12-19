package grywojenne;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class RozgrywkaTest {

    private Rozgrywka rozgrywka;

    @Before
    public void setUp() {
        rozgrywka = new Rozgrywka();
    }

    @Test
    public void testDodajGracza() {
        rozgrywka.dodajGracza("Gracz1");
        assertEquals("Gracz1", rozgrywka.getGracze().get(0).getNazwa());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDodajGraczaDuplicate() {
        rozgrywka.dodajGracza("Gracz1");
        rozgrywka.dodajGracza("Gracz1");
        assertEquals(false,false);
    }

    @Test
    public void testSetFaza() {
        rozgrywka.setFaza();
        assertEquals(1, rozgrywka.getFaza());
    }

    @Test
    public void testZerujFaza() {
        rozgrywka.setFaza();
        rozgrywka.zerujFaza();
        assertEquals(0, rozgrywka.getFaza());
    }


    @Test
    public void testFaza3() {
        General gracz1 = new General("Gracz1");
        General gracz2 = new General("Gracz2");

        rozgrywka.getGracze().add(gracz1);
        rozgrywka.getGracze().add(gracz2);

        rozgrywka.faza_3();
        assertEquals(0, rozgrywka.getFaza());
    }


    
    @Test
    public void testFaza0UstawiaFazeNa1() {
        General gracz1 = new General("Gracz1");
        rozgrywka.getGracze().add(gracz1);
        rozgrywka.faza_0();
        assertEquals("Faza powinna być ustawiona na 1", 1, rozgrywka.getFaza());
    }
    
    @Test
    public void testFaza0ZapisujeStanGry() {
        General gracz1 = new General("Gracz1");
        Zolnierz zolnierz = gracz1.stworzZolnierz('s');
        gracz1.getArmia().add(zolnierz);
        rozgrywka.getGracze().add(gracz1);
        rozgrywka.setEtap(20);
        rozgrywka.setFaza(0);
    
        rozgrywka.faza_0();
    
        File plik = new File("20-0_Gracz1.txt");
        assertTrue("Plik powinien zostać zapisany po zakończeniu fazy 0", plik.exists());
        plik.delete();
    }

    @Test
public void testFaza0ZawieraZolnierza() {
    General gracz1 = new General("Gracz1");
    Zolnierz zolnierz = gracz1.stworzZolnierz('s');
    gracz1.getArmia().add(zolnierz);
    rozgrywka.getGracze().add(gracz1);
    rozgrywka.setEtap(20);
    rozgrywka.setFaza(0);

    rozgrywka.faza_0();

    File plik = new File("20-0_Gracz1.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
        String linia;
        boolean zolnierzZnaleziony = false;
        while ((linia = reader.readLine()) != null) {
            if (linia.contains("SZEREGOWY")) { 
                zolnierzZnaleziony = true;
                break;
            }
        }
        assertTrue("Plik powinien zawierać zapisany żołnierza", zolnierzZnaleziony);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        plik.delete();
    }
}
    
}