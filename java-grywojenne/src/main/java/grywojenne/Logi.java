package grywojenne;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logi {
    
    public synchronized static void dodajLog(int opcja , String nazwa, String tresc) {    
        String log = "";
        switch(opcja) {
            case 1: // zakupy
                log = "Gracz: " + nazwa + " kupil: " + tresc;
                break;
            case 2: // szkolenie
                log = "Gracz: " + nazwa + " szkoli zolnierza nr: " + tresc;
                break;
            case 3: // deklaracja ataku
                log = "Gracz: " + nazwa + " " + tresc;
                break;
            case 4: // zakonczenie fazy 2
                log = "Gracz: " + nazwa + " " + tresc;
                break;
            case 5: // zakonczenie fazy 3
                log = "Gracz: " + nazwa + " " + tresc;
                break;
            case 6: // awans
                log = "zolnierz gracza: " + nazwa + " " + tresc;
                break;
            case 7: // etap faza
                log = nazwa + " " + tresc;
                break;
            default:
                throw new RuntimeException("Nieznana opcja"); 
        }

         try (BufferedWriter writer = new BufferedWriter(new FileWriter("logi.txt", true))) {
            writer.write(log);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania loga: " + e.getMessage());
        }
    }

}
