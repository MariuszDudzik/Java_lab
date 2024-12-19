package grywojenne;

import org.junit.*;
import static org.junit.Assert.*;


public class LogiTest {
    

    @Test(expected = RuntimeException.class)
    public void testDodajLogNieznanaOpcja() {
        Logi.dodajLog(99, "Gracz1", "nieznana opcja");
        assertEquals(false,false);

    }

   
}