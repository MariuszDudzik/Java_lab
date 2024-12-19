package grywojenne;
import org.junit.Test;
import static org.junit.Assert.*;

public class StopienTest {

    @Test
    public void testGetNazwa() {
        Stopien szeregowy = new S_Szeregowy();
        assertEquals("SZEREGOWY", szeregowy.getNazwa());
    }

    @Test
    public void testGetWartosc() {
        Stopien kapral = new S_Kapral();
        assertEquals(2, kapral.getWartosc());
    }

    @Test
    public void testSetNazwa() {
        Stopien szeregowy = new S_Szeregowy();
        szeregowy.setNazwa("Nowa Nazwa");
        assertEquals("Nowa Nazwa", szeregowy.getNazwa());
    }

    @Test
    public void testSetWartosc() {
        Stopien szeregowy = new S_Szeregowy();
        szeregowy.setWartosc(10);
        assertEquals(10, szeregowy.getWartosc());
    }

    @Test
public void testNastepnyFromS_Szeregowy() {
    Stopien szeregowy = new S_Szeregowy();
    Stopien next = szeregowy.nastepny();
    assertEquals("KAPRAL", next.getNazwa());
}

@Test
public void testNastepnyFromS_Kapral() {
    Stopien kapral = new S_Kapral();
    Stopien next = kapral.nastepny();
    assertEquals("KAPITAN", next.getNazwa());
}

@Test
public void testNastepnyFromS_Kapitan() {
    Stopien kapitan = new S_Kapitan();
    Stopien next = kapitan.nastepny();
    assertEquals("MAJOR", next.getNazwa());
}

@Test
public void testNastepnyFromS_Major() {
    Stopien major = new S_Major();
    Stopien next = major.nastepny();
    assertEquals("MAJOR", next.getNazwa());
}
}