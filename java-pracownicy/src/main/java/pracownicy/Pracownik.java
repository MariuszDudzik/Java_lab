package pracownicy;

public class Pracownik implements I_pracownicy {
    private static int licznikPracownikow = 0;

    private int idPracownika;
    private String imie;
    private String nazwisko;
    private int rokUrodzenia;
    private int doswiadczenie;
    private Adres adres;

    public Pracownik(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie, 
                    String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, String miasto) {
    
        this.idPracownika = ++licznikPracownikow;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.doswiadczenie = doswiadczenie;
        this.adres = new Adres(ulica, numerDomu, numerMieszkania, kodPocztowy, miasto);
    }

    @Override
    public int getIdPracownika() {
        return this.idPracownika;
    }

    @Override
    public String getImie() {
        return this.imie;
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;
    }

    @Override
    public int getRokUrodzenia() {
        return this.rokUrodzenia;
    }

    @Override
    public int getDoswiadczenie() {
        return this.doswiadczenie;
    }

    @Override
    public Adres getAdres() {
        return this.adres;
    }

    @Override
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    @Override
    public void setDoswiadczenie(int doswiadczenie) {
        this.doswiadczenie = doswiadczenie;
    }

    @Override
    public void setAdres(Adres adres) {
        this.adres = adres;
    }

}

class Biurowy extends Pracownik implements I_biurowy {
    private static int licznikStanowiska = 0;

    private int idStanowiska;
    private int intelekt;

    public Biurowy(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie, String ulica, String numerDomu, 
                    String numerMieszkania, String kodPocztowy, String miasto, int intelekt) {
        super(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto);

        checkIntelekt(intelekt);

        this.idStanowiska = ++licznikStanowiska;
        this.intelekt = intelekt;
    }

    @Override
    public void checkIntelekt(int intelekt) {
        if (intelekt < 70 || intelekt > 150) {
            throw new IllegalArgumentException("Intelekt musi być w zakresie od 70 do 150.");
        }
    }

    @Override
    public int getIdStanowiska() {
        return this.idStanowiska;
    }

    @Override
    public int getIntelekt() {
        return this.intelekt;
    }


    @Override
    public void setIntelekt(int intelekt) {
        checkIntelekt(intelekt);
        this.intelekt = intelekt;
    }

}

class Fizyczny extends Pracownik implements I_fizyczny {

    private int silaFizyczna;

    public Fizyczny(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie, String ulica, String numerDomu, 
                    String numerMieszkania, String kodPocztowy, String miasto, int silaFizyczna) {
        super(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto);

        checkSilaFizyczna(silaFizyczna);

        this.silaFizyczna = silaFizyczna;
    }

    @Override
    public void checkSilaFizyczna(int silaFizyczna) {
        if (silaFizyczna < 1 || silaFizyczna > 100) {
            throw new IllegalArgumentException("Sila fizyczna musi być w zakresie od 1 do 100.");
        }
    }

    @Override
    public int getSilaFizyczna() {
        return this.silaFizyczna;
    }

    @Override
    public void setSilaFizyczna(int silaFizyczna) {
        this.silaFizyczna = silaFizyczna;
    }

}

class Handlowiec extends Pracownik implements I_handlowiec {

    private Skutecznosc skutecznosc;
    private int prowizja;

    public Handlowiec(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie, String ulica, String numerDomu, 
                    String numerMieszkania, String kodPocztowy, String miasto, int prowizja, String skutecznosc) {
        super(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, numerMieszkania, kodPocztowy, miasto);


        this.skutecznosc = I_skutecznosc.stworzSkutecznosc(skutecznosc);
        this.prowizja = prowizja;
        
    }

    @Override
    public Skutecznosc getSkutecznosc() {
        return this.skutecznosc;
    }

    @Override
    public int getProwizja() {
        return this.prowizja;
    }

    @Override
    public void setSkutecznosc(Skutecznosc skutecznosc) {
        this.skutecznosc = skutecznosc;   
    }

    @Override
    public void setProwizja(int prowizja) {
        this.prowizja = prowizja;
    }
    
}