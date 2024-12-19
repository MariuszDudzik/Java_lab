package grywojenne;

import org.junit.*;
import static org.junit.Assert.*;

public class RaportTest {
    
    private Raport raport;
    
    @Before
    public void setUp() {
        raport = new Raport();
    }

   

    @Test
    public void testSetBitwa() {
        raport.setBitwa();
        assertTrue(raport.getBitwa());
    }

    @Test
    public void testDodajAwans() {
        raport.setPoczatkoweListy();
        raport.dodajAwans(0);
        assertEquals(Integer.valueOf(1), raport.awanseArmii.get(0));
    }

    @Test
    public void testDodajZakup() {
        raport.setPoczatkoweListy();
       
        raport.dodajZakup(1, 5);
        assertEquals(Integer.valueOf(5), raport.zakupyArmii.get(1));
    }

    @Test
    public void testDodajManewry() {
        raport.setPoczatkoweListy();
       
        raport.dodajManewry(1, 3); // dla drugiej armii
        assertEquals(Integer.valueOf(3), raport.manewryArmii.get(1));
    }

    @Test
    public void testDodajStrate() {
        raport.setPoczatkoweListy();
        raport.dodajStrate(0, 12); // dla pierwszej armii
        assertEquals(Integer.valueOf(12), raport.stratyArmii.get(0));
    }

    @Test
    public void testZerujRaport() {
        raport.setPoczatkoweListy();
        raport.dodajAwans(0);
        raport.dodajZakup(1, 5);
        raport.dodajManewry(0, 8);
        raport.dodajStrate(1, 7);
        raport.setBitwa();

        raport.zerujRaport();
    
        assertEquals(Integer.valueOf(0), raport.stratyArmii.get(1));
    
    }   
}