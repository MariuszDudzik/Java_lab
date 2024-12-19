package grywojenne;

import java.util.ArrayList;

public class Raport {

    ArrayList<Integer> awanseArmii = new ArrayList<>();
    ArrayList<Integer> zakupyArmii = new ArrayList<>();
    ArrayList<Integer> manewryArmii = new ArrayList<>();
    ArrayList<Integer> stratyArmii = new ArrayList<>();
    private boolean bitwa = false;


    public Raport() {

      setPoczatkoweListy();
    }

    public void setPoczatkoweListy(){
        for (int i = 0; i < 2; i++){
            awanseArmii.add(0);
            zakupyArmii.add(0);
            manewryArmii.add(0);
            stratyArmii.add(0);
        }
    }

    public void setBitwa(){
        this.bitwa = true;
    }

    public boolean getBitwa(){
        return this.bitwa;
    }

    public void dodajAwans(int indeks) {
        int awans = awanseArmii.get(indeks);
        awanseArmii.set(indeks, awans + 1);
    }

    public void dodajZakup(int indeks, int ilosc) {
        zakupyArmii.set(indeks, ilosc);
    }

    public void dodajManewry(int indeks, int ilosc) {
        manewryArmii.set(indeks, ilosc);
    }

    public void dodajStrate(int indeks, int ilosc) {
        stratyArmii.set(indeks, ilosc);
    }


    public void zerujRaport() {
        for (int i = 0; i < 2; i++){
            awanseArmii.set(i, 0);
            zakupyArmii.set(i, 0);
            manewryArmii.set(i, 0);
            stratyArmii.set(i, 0);
        }
        this.bitwa = false;
    }

    public void wypiszRaport(String nazwa1, String nazwa2, int etap) {
        System.out.println("Raport z etapu " + etap);
        System.out.println("Awansowano " + awanseArmii.get(0) + " zolnierzy w armii " + nazwa1);
        System.out.println("Awansowano " + awanseArmii.get(1) + " zolnierzy w armii " + nazwa2);
        System.out.println("Gracz " + nazwa1 + " zakupil " + zakupyArmii.get(0) + " zolnierzy");
        System.out.println("Gracz " + nazwa2 + " zakupil " + zakupyArmii.get(1) + " zolnierzy");
        System.out.println("Gracz " + nazwa1 + " wyszkolil " + manewryArmii.get(0) + " zolnierzy");
        System.out.println("Gracz " + nazwa2 + " wyszkolil " + manewryArmii.get(1) + " zolnierzy");
        if (this.bitwa){
            System.out.println("Doszlo do bitwy");
            System.out.println("Gracz " + nazwa1 + " stracil " + stratyArmii.get(0) + " zolnierzy");
            System.out.println("Gracz " + nazwa2 + " stracil " + stratyArmii.get(1) + " zolnierzy");
        } 
    }
}