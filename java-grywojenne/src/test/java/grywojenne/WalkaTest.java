package grywojenne;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WalkaTest {

    private ArrayList<General> gracze;
    private General gracz1;
    private General gracz2;
    
    @Before
    public void setUp() {
        gracze = new ArrayList<>();
        gracz1 = new General("Gracz1");
        gracz2 = new General("Gracz2");
        Zolnierz zolnierz = gracz1.stworzZolnierz('s');
        Zolnierz zolnierz1 = gracz1.stworzZolnierz('k');
        gracz1.getArmia().add(zolnierz);
        gracz1.getArmia().add(zolnierz);
        gracz2.getArmia().add(zolnierz1);
        gracz2.getArmia().add(zolnierz1);

        gracze.add(gracz1);
        gracze.add(gracz2);
    }

    @Test
    public void testBitwa() {
        int sakwa = gracz1.getSkarbiec();
        int wartoscPotraceniaGracz1 = Walka.wartoscPotracenia(gracz1);
        Walka.bitwa(gracze);
        assertEquals(sakwa - wartoscPotraceniaGracz1, gracz1.getSkarbiec());
    }

    @Test
    public void testObnizSileArmii() {
        Walka.obnizSileArmii(gracz1);
        Walka.obnizSileArmii(gracz2);

 
        for (Zolnierz zolnierz : gracz1.getArmia()) {
            assertTrue(zolnierz.getDoswiadczenie() < 10);
        }
    }

    @Test
    public void testLosowoOdstrzelZolnierza() {
        int originalSize = gracz1.getArmia().size();
        Walka.losowoOdstrzelZolnierza(gracz1);
        assertEquals(originalSize - 1, gracz1.getArmia().size());
    }
}