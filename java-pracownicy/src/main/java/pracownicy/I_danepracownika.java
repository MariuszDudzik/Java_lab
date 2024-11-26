package pracownicy;

public interface I_danepracownika {

    void setHandlowiec(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                       String ulica, String numerDomu, String numerMieszkania, String kodPocztowy,
                       String miasto, int prowizja, String skutecznosc);

    void setFizyczny(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                     String ulica, String numerDomu, String numerMieszkania, String kodPocztowy,
                     String miasto, int silaFizyczna);

    void setBiurowy(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                    String ulica, String numerDomu, String numerMieszkania, String kodPocztowy,
                    String miasto, int intelekt);

    String getImie();
    String getNazwisko();
    int getRokUrodzenia();
    int getDoswiadczenie();
    String getUlica();
    String getNumerDomu();
    String getNumerMieszkania();
    String getKodPocztowy();
    String getMiasto();
    int getIntelekt();
    int getSilaFizyczna();
    int getProwizja();
    String getSkutecznosc();
}