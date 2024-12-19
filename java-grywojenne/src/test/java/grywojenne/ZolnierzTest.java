package grywojenne;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZolnierzTest {
    private Stopien stopienSzeregowy;
    private Stopien stopienMajor;
    private Zolnierz zolnierz;

    @Before
    public void setUp() {
        stopienSzeregowy = new S_Szeregowy();
        stopienMajor = new S_Major();
        zolnierz = new Zolnierz(stopienSzeregowy);
    }

    @Test
    public void testGetDoswiadczenie() {
        assertEquals(1, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testSetDoswiadczenie() {
        zolnierz.setDoswiadczenie(10);
        assertEquals(10, zolnierz.getDoswiadczenie());
    }


    @Test
    public void testGetSila() {
        assertEquals(1, zolnierz.getSila());
    }

    @Test
    public void testSetSila2() {
        zolnierz.setSila2(50);
        assertEquals(50, zolnierz.getSila());
    }

    @Test
    public void testSprawdzAwans() {
        zolnierz.setDoswiadczenie(5);
        assertTrue(zolnierz.sprawdzAwans());
    }

    @Test
    public void testZerujDoswiadczenie() {
        zolnierz.setDoswiadczenie(10);
        zolnierz.zerujDoswiadczenie();
        assertEquals(1, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testSetSilaWithDoswiadczenie() {
        zolnierz.setDoswiadczenie(3);
        zolnierz.setSila();
        assertEquals(3, zolnierz.getSila());
    }

    @Test
    public void testAwansujFromSzeregowy() {
        zolnierz = new Zolnierz(stopienSzeregowy);
        zolnierz.setDoswiadczenie(10);
        zolnierz.awansuj();
        assertEquals("KAPRAL", zolnierz.getStopien().getNazwa());
    }

    @Test
    public void testAwansujFromSzeregowy1() {
        zolnierz = new Zolnierz(stopienSzeregowy);
        zolnierz.setDoswiadczenie(10);
        zolnierz.awansuj();
        assertEquals(1, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testAwansujFromSzeregowy2() {
        zolnierz = new Zolnierz(stopienSzeregowy);
        zolnierz.setDoswiadczenie(10);
        zolnierz.awansuj();
        assertEquals(2, zolnierz.getSila());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAwansujFromMajor3() {
        zolnierz = new Zolnierz(stopienMajor);
        zolnierz.setDoswiadczenie(20);
        zolnierz.awansuj();
        assertEquals(false, false);
    }


    @Test
    public void testTrenuj() {
        zolnierz.trenuj();
        assertEquals(2, zolnierz.getSila());
    }

    @Test
    public void testTrenuj1() {
        zolnierz.trenuj();
        assertEquals(2, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testZmniejszDoswiadczenie() {
        zolnierz.trenuj();
        zolnierz.zmniejszDoswiadczenie();
        assertEquals(1, zolnierz.getSila());
    }

    @Test
    public void testZmniejszDoswiadczenie1() {
        zolnierz.trenuj();
        zolnierz.zmniejszDoswiadczenie();
        assertEquals(1, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testSetNaManewrach() {
        zolnierz.setNaManewrach();
        assertTrue(zolnierz.getNaManewrach());
    }

    @Test
    public void testSetPowrotZManewrow() {
        zolnierz.setNaManewrach();
        zolnierz.setPowrotZManewrow();
        assertFalse(zolnierz.getNaManewrach());
    }

    @Test
    public void testSetPowrotZManewrow1() {
        zolnierz.setNaManewrach();
        zolnierz.setPowrotZManewrow();
        assertEquals(2, zolnierz.getDoswiadczenie());
    }

    @Test
    public void testSetPowrotZManewrow2() {
        zolnierz.setNaManewrach();
        zolnierz.setPowrotZManewrow();
        assertEquals(2, zolnierz.getSila());
    }
}