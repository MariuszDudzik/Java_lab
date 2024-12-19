package grywojenne;
import java.util.ArrayList;
import java.util.Random;

public class Walka{

    public static void bitwa(ArrayList<General> gracze) {
   
        ArrayList<Integer> silaArmii = new ArrayList<>();

        for (General gracz : gracze) {
            int sumaSily = 0;
            for (Zolnierz zolnierz : gracz.getArmia()) {
                if (!zolnierz.getNaManewrach()) {
                    sumaSily += zolnierz.getSila();
                }
            }
            silaArmii.add(sumaSily);
        }

        int silaGracz1 = silaArmii.get(0);
        int silaGracz2 = silaArmii.get(1);

        if (silaGracz1 > silaGracz2) {
            obnizSileArmii(gracze.get(1));
            podwyzSileArmii(gracze.get(0));
            int wartosc = wartoscPotracenia(gracze.get(1));
            obnizSkarbiec(gracze.get(1), wartosc);
            zwiekszSkarbiec(gracze.get(0), wartosc);
            usunMartwych(gracze.get(1));

        } else if (silaGracz1 < silaGracz2) {
            obnizSileArmii(gracze.get(0));
            podwyzSileArmii(gracze.get(1));
            int wartosc = wartoscPotracenia(gracze.get(0));
            obnizSkarbiec(gracze.get(0), wartosc);
            zwiekszSkarbiec(gracze.get(1), wartosc);
            usunMartwych(gracze.get(0));

        } else {
            losowoOdstrzelZolnierza(gracze.get(0));
            losowoOdstrzelZolnierza(gracze.get(1));
        }

    }

    public static void obnizSileArmii(General gracz) {
        for (Zolnierz zolnierz : gracz.getArmia()) {
                zolnierz.zmniejszDoswiadczenie();
        }    
    }

    public static void podwyzSileArmii(General gracz) {
        for (Zolnierz zolnierz : gracz.getArmia()) {
                zolnierz.trenuj();
        }    
    }

    public static int wartoscPotracenia(General gracz) {
        int wartosc = gracz.getSkarbiec() / 10;
        return wartosc;
    }

    public static void obnizSkarbiec(General gracz, int wartosc) {
        gracz.setWartosc(gracz.getSkarbiec() - wartosc); 
        
    }

    public static void zwiekszSkarbiec(General gracz, int wartosc) {
        gracz.setWartosc(gracz.getSkarbiec() + wartosc); 
        
    }


    public static void losowoOdstrzelZolnierza(General gracz) {
        Random random = new Random();

        int losowyIndeks = random.nextInt(gracz.getArmia().size());
        gracz.getArmia().remove(losowyIndeks);    
    }

    public static void usunMartwych(General gracz) {
        for (int indeks = 0; indeks < gracz.getArmia().size(); indeks++) {
            if (gracz.getArmia().get(indeks).getDoswiadczenie() <= 0) {
                gracz.getArmia().remove(indeks);
            }
        }
    }

}