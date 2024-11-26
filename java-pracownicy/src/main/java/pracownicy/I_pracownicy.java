package pracownicy;

public interface I_pracownicy {
    public int getIdPracownika();
    public String getImie();
    public String getNazwisko();
    public int getRokUrodzenia();
    public int getDoswiadczenie();
    public Adres getAdres();
    public void setImie(String imie);
    public void setNazwisko(String nazwisko);
    public void setRokUrodzenia(int rokUrodzenia);
    public void setDoswiadczenie(int doswiadczenie);
    public void setAdres(Adres adres);
}

interface I_biurowy {
    public int getIdStanowiska();
    public int getIntelekt();
    public void setIntelekt(int intelekt);
    public void checkIntelekt(int intelekt);
}

interface I_fizyczny {
    public void checkSilaFizyczna(int silaFizyczna);
    public int getSilaFizyczna();
    public void setSilaFizyczna(int silaFizyczna);  
}

interface I_handlowiec {
    public int getProwizja();
    public void setProwizja(int prowizja);
    public Skutecznosc getSkutecznosc();
    public void setSkutecznosc(Skutecznosc skutecznosc);
}