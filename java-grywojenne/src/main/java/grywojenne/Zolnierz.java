package grywojenne;

public class Zolnierz {
    private static int nr_bierzacy_nies = 1;

    private int nr_niesmiertelnika;
    private Stopien stopien;
    private int doswiadczenie;
    private int sila;
    private boolean na_manewrach;
    

    public Zolnierz(Stopien stopien){
        this.nr_niesmiertelnika = nr_bierzacy_nies++;
        this.doswiadczenie = 1;
        this.na_manewrach = false;
        this.stopien = stopien;
        this.setSila();           
    }

    public static int getNrBierzacyNies() {
        return nr_bierzacy_nies;
    }

    public static void setNrBierzacyNies(int nr) {
        nr_bierzacy_nies = nr;
    }

    public int getNrNiesmiertelnika(){
        return this.nr_niesmiertelnika;
    }

    public int getDoswiadczenie(){
        return this.doswiadczenie;
    }

    public void setDoswiadczenie(int doswiadczenie){
        this.doswiadczenie = doswiadczenie;
    }

    public Stopien getStopien(){
        return this.stopien;
    }

    public int getSila(){
        return this.sila;
    }

    public void setSila2(int sila){
        this.sila = sila;
    }

    public void setNrNiesmiertelnika(int nr){
        this.nr_niesmiertelnika = nr;
    }

    public boolean sprawdzAwans(){
        if(this.getDoswiadczenie() >= 5 * this.stopien.getWartosc()){
            return true;
        }
        return false;  
    }

    public void zerujDoswiadczenie(){
        this.doswiadczenie = 1;
    }

    public void setSila(){
        this.sila = this.stopien.getWartosc() * this.getDoswiadczenie();
    }

    public void awansuj(){
        if(this.sprawdzAwans()){
          if(!(this.getStopien() instanceof S_Major)) {
            this.stopien = this.stopien.nastepny();
            this.zerujDoswiadczenie();
            this.setSila();
            }
          else{
            throw new IllegalArgumentException("Nie mozna awansowac majora");
            }
        }
    }

    public void trenuj(){
        this.doswiadczenie++;
        this.setSila();
    }

    public void zmniejszDoswiadczenie(){
        this.doswiadczenie--;
        this.setSila();
    }

    public void setNaManewrach(){
        this.na_manewrach = true;
    }

    public void setPowrotZManewrow(){
        this.na_manewrach = false;
        this.trenuj();
    }

    public boolean getNaManewrach(){
        return this.na_manewrach;
    }

}