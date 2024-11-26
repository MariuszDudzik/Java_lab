package pracownicy;

public class DanePracownika implements I_danepracownika{

    String imie;
    String nazwisko;
    int rokUrodzenia;
    int doswiadczenie;
    String ulica;
    String numerDomu;
    String numerMieszkania;
    String kodPocztowy;
    String miasto;
    int intelekt; 
    int silaFizyczna;
    int prowizja;
    String skutecznosc;


    public void setHandlowiec(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                        String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, 
                        String miasto, int prowizja, String skutecznosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.doswiadczenie = doswiadczenie;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.prowizja = prowizja;
        this.skutecznosc = skutecznosc;
    }

    public void setFizyczny(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                        String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, 
                        String miasto, int silaFizyczna) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.doswiadczenie = doswiadczenie;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.silaFizyczna = silaFizyczna;
    }

    public void setBiurowy(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                        String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, 
                        String miasto, int intelekt) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.doswiadczenie = doswiadczenie;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.intelekt = intelekt;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public String getNumerMieszkania() {
        return numerMieszkania;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public int getIntelekt() {
        return intelekt;
    }

    public int getSilaFizyczna() {
        return silaFizyczna;
    }

    public int getProwizja() {
        return prowizja;
    }

    public String getSkutecznosc() {
        return skutecznosc;
    }

}
