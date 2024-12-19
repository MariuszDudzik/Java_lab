package grywojenne;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GeneralTest {
    private General general;
    private Zolnierz zolnierz;
   

    @Before
    public void setUp() {
   
        general = new General("GeneralTestowy");
    }

    @Test
    public void testKupZolnierza() {
            general.kupZolnierza('s');
            assertEquals(1, general.getArmia().size());
            assertEquals("SZEREGOWY", general.getArmia().get(0).getStopien().getNazwa());
            assertEquals(990, general.getSkarbiec());
            assertEquals(1, general.getZakupiono());
    }

    @Test
    public void testKupZolnierza1() {
            general.kupZolnierza('s');
            assertEquals("SZEREGOWY", general.getArmia().get(0).getStopien().getNazwa());
    }

    @Test
    public void testKupZolnierza2() {
            general.kupZolnierza('s');
            assertEquals(990, general.getSkarbiec());
    }

    @Test
    public void testKupZolnierza3() {
            general.kupZolnierza('s');
            assertEquals(1, general.getZakupiono());
    }


    @Test(expected = RuntimeException.class)
    public void testKupZolnierzaBrakSrodkow() {
        general.setWartosc(5);
        general.kupZolnierza('s');
        assertEquals(false,false);
    }

    @Test
    public void testStworzZolnierz() {
        zolnierz = general.stworzZolnierz('s');
        assertEquals("SZEREGOWY", zolnierz.getStopien().getNazwa());
    }

    @Test(expected = RuntimeException.class)
    public void testStworzZolnierz1() {
        zolnierz = general.stworzZolnierz('x');
        assertEquals(false, false);
    }

    @Test
    public void testKosztManewrow() {
        general.kupZolnierza('s');
        general.kupZolnierza('k');
        general.stworzListeManewry(general.getArmia().get(0));
        general.stworzListeManewry(general.getArmia().get(1));
        assertEquals(3, general.kosztManewrow());
    }

    @Test
    public void testWyslijNaManewry() {
        general.kupZolnierza('s');
        general.kupZolnierza('k');
        general.setWartosc(1000);
        general.stworzListeManewry(general.getArmia().get(0));
        general.stworzListeManewry(general.getArmia().get(1));
        general.wyslijNaManewry();
        assertEquals(997, general.getSkarbiec());
    }
       
    @Test(expected = RuntimeException.class)
    public void testWyslijNaManewry1() {
        general.setWartosc(1);
        general.kupZolnierza('s');
        general.stworzListeManewry(general.getArmia().get(0));
        general.wyslijNaManewry();
        assertEquals(false, false);
    }

    @Test  
    public void testZapiszStanDoPliku1() {
        try {
            File file = new File("test_output.txt");
            general.kupZolnierza('s');
            general.zapiszStanDoPliku("test_output.txt", general.getNazwa());       
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                if (line.startsWith("nazwa=")) {
                    assertEquals("nazwa=GeneralTestowy", line);
                }
                line = scanner.nextLine();
            }
            scanner.close();
        } catch (IOException e) {
            fail("Nie ma bledu " + e.getMessage());
        }
    }

    @Test
    public void testZapiszStanDoPliku2() {
        try {  
            File file = new File("test_output1.txt");
            general.kupZolnierza('s');
            general.zapiszStanDoPliku("test_output1.txt", general.getNazwa());  
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                if (line.startsWith("skarbiec=")) {
                    assertEquals("skarbiec=990", line);
                }
                line = scanner.nextLine();
            }
            scanner.close();
        } catch (IOException e) {
            fail("Nie ma bledu: " + e.getMessage());
        }
    }
   

    @Test
    public void testWczytajStanZPliku1() {
       general.kupZolnierza('s');
       general.zapiszStanDoPliku("test_output2.txt", general.getNazwa());  

        General newGeneral = new General("GeneralTestowy0");
        newGeneral.wczytajStanZPliku("test_output2.txt");  
        assertEquals(general.getSkarbiec(), newGeneral.getSkarbiec());
    }

    @Test
    public void testWczytajStanZPliku2() {
        general.kupZolnierza('s');
        general.zapiszStanDoPliku("test_input3.txt", general.getNazwa());
        General newGeneral = new General("GeneralTestowy1");
        newGeneral.wczytajStanZPliku("test_input3.txt");
        assertEquals(1, newGeneral.getArmia().size());
    }

    @Test
    public void testWczytajStanZPliku4() {
        general.kupZolnierza('s');
        general.kupZolnierza('k');
        general.zapiszStanDoPliku("test_input4.txt", general.getNazwa());

        General newGeneral = new General("GeneralTestowy");
        newGeneral.wczytajStanZPliku("test_input4.txt");

        assertEquals(general.getArmia().get(1).getStopien().getNazwa(), newGeneral.getArmia().get(1).getStopien().getNazwa());
    }

}