package grywojenne;

import java.util.ArrayList;

public class Rozgrywka{
    private ArrayList<General> gracze;
    private int etap = 20;
    private int faza = 0;
    private Raport raport = new Raport();

    public Rozgrywka() {
        gracze = new ArrayList<>(); 
    }

    public ArrayList<General> getGracze() {
        return gracze;
    }

    public int getEtap() {
        return etap;
    }

    public int getFaza() {
        return faza;
    }

    public void setEtap(int etap) {
        this.etap = etap;
    }

    public void setFaza(int faza) {
        this.faza = faza;
    }

    public void dodajGracza(String nazwa) {
        for (General gracz : gracze) {
            if (gracz.getNazwa().equals(nazwa)) {
                throw new IllegalArgumentException("Gracz o takiej nazwie już istnieje");
            }
        }
        gracze.add(new General(nazwa));
    }


    public void setFaza(){
       ++this.faza;
    }

    public void zerujFaza(){
        this.faza = 0;
    }


    public void okreslZwyciezce(){

        ArrayList<Integer> silaArmii = new ArrayList<>();

        for (General gracz : gracze) {
            int sumaSily = 0;
            for (Zolnierz zolnierz : gracz.getArmia()) {
                    sumaSily += zolnierz.getSila();
                }
            silaArmii.add(sumaSily);    
        }    

        int silaGracz1 = silaArmii.get(0);
        int silaGracz2 = silaArmii.get(1);

        if (silaGracz1 > silaGracz2) {
            System.out.println("Wygrał gracz: " + gracze.get(0).getNazwa());
        } else if (silaGracz1 < silaGracz2) {
            System.out.println("Wygrał gracz: " + gracze.get(1).getNazwa());
        } else {
            System.out.println("Remis");
        }
    }

    public void faza_0(){
        Logi.dodajLog(7, "system", etap + " etap -" + faza + " faza");
        for (int i = 0; i < gracze.size(); i++) {
            General gracz = gracze.get(i);
            gracz.zerujFlagi();
            raport.zerujRaport();
            for (Zolnierz zolnierz : gracz.getArmia()){
                zolnierz.setPowrotZManewrow();
                String temp = zolnierz.getStopien().getNazwa();
                zolnierz.awansuj();
                if (!temp.equals(zolnierz.getStopien().getNazwa())){
                    Logi.dodajLog(6, gracz.getNazwa(), "o numerze " + zolnierz.getNrNiesmiertelnika() + " awansowal na " + zolnierz.getStopien().getNazwa());
                    raport.dodajAwans(i);
                }
            }
        }
        System.out.println("Faza 0 zakonczona");
        this.zapiszStanGry();
        this.setFaza();
    }


    public void faza_1(){
        Logi.dodajLog(7, "system", etap + " etap -" + faza + " faza");
        // zakupy, manewry
        boolean znacznik = true;
        for (General gracz : gracze){
            if (gracz.getFlaga_zakoncz_manewry() == false){
                znacznik = false;
            }
        }
        if (znacznik){
            for (int i = 0; i < gracze.size(); i++) {
                General gracz = gracze.get(i);
                raport.dodajZakup(i, gracz.getZakupiono());
                raport.dodajManewry(i, gracz.getSzkolono());
            }
            System.out.println("Faza 1 zakonczona");
            this.zapiszStanGry();
            this.setFaza();
        }
    }

    public void faza_2(){
        Logi.dodajLog(7, "system", etap + " etap -" + faza + " faza");
        // walka
        boolean znacznik = true;
        for (General gracz : gracze){
            if (gracz.getFlaga_zakoncz_bitwa() == false){
                znacznik = false;
            }
        }
        if (znacznik){
            boolean flaga = false;
            for (General gracz : gracze){
                if (gracz.getFlaga_zaatakuj()){
                    flaga = true;
                }
            if (flaga){
                System.out.println("Bitwa");
                raport.setBitwa();
                int ilosc1 = gracze.get(0).getArmia().size();
                int ilosc2 = gracze.get(1).getArmia().size(); 
                Walka.bitwa(gracze);
                if (ilosc1 > gracze.get(0).getArmia().size()){
                    raport.dodajStrate(0, ilosc1 - gracze.get(0).getArmia().size());
                }
                if (ilosc2 > gracze.get(1).getArmia().size()){
                    raport.dodajStrate(1, ilosc2 - gracze.get(1).getArmia().size());
                }
              
            }
            System.out.println("Faza 2 zakonczona");
            this.zapiszStanGry();
            this.setFaza();
            }   
        }
    }

    public void faza_3(){
        Logi.dodajLog(7, "system", etap + " etap -" + faza + " faza");
        // sprawdz czy ktos wygral, zmien etap
        if (this.etap > 1){
            this.etap--;
            System.out.println("Faza 3 zakonczona, rozpoczynam etap " + this.etap);
            this.zapiszStanGry();
            this.zerujFaza();
        }
        else{
            this.etap--;
            this.okreslZwyciezce();
        }
    }

    public void rozegrajGre(){
        while (this.etap > 0){
            if (this.faza == 0){
                this.faza_0();
            }
            else if (this.faza == 1){
                this.faza_1();
            }
            else if (this.faza == 2){
                this.faza_2();
            }
            else if (this.faza == 3){
                this.faza_3();
                raport.wypiszRaport(gracze.get(0).getNazwa(), gracze.get(1).getNazwa(), this.etap);
            }
        }
    }

    public void zapiszStanGry() {
        for (General gracz : gracze) {
            String nazwaPliku = String.format("%d-%d_%s.txt", etap, faza, gracz.getNazwa());
            gracz.zapiszStanDoPliku(nazwaPliku, gracz.getNazwa());
        }
        System.out.println("Stan gry zapisano dla wszystkich graczy.");
    }
    

    public void wczytajStanGry(int etap, int faza) {
        ArrayList<General> tempGracze = new ArrayList<>();
    
        for (int i = 0; i < 2; i++) {
            try {
                String nazwaPliku = String.format("%d-%d_%s.txt", etap, faza, gracze.get(i).getNazwa());
                General gracz = new General("Gracz");
                gracz.wczytajStanZPliku(nazwaPliku);
                tempGracze.add(gracz);
            } catch (RuntimeException e) {
                System.err.println("Blad ladowania " + e.getMessage());
                e.printStackTrace(); 
            }
        }
        this.etap = etap;
        this.faza = faza;
        this.gracze = tempGracze;
    }
}