package pracownicy;

import java.util.List;
public interface I_rejestr {

    void dodajBiurowy(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                      String ulica, String numerDomu, String numerMieszkania,
                      String kodPocztowy, String miasto, int intelekt);

    void dodajFizyczny(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                       String ulica, String numerDomu, String numerMieszkania,
                       String kodPocztowy, String miasto, int silaFizyczna);

    void dodajHandlowiec(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                         String ulica, String numerDomu, String numerMieszkania,
                         String kodPocztowy, String miasto, int prowizja, String skutecznosc);

    void okreslTypPracownikow(char typ);
    void dodajPracownikow(DanePracownika dane);
    void usunPracownika(int idPracownika);
    List<String> wyswietlPoDoswiadczeniu();
    List<String> wyswietlPoWieku();
    List<String> wyswietlPoNazwiskuImieniu();
    List<String> wyswietlPracownikowZmiasta(String miasto);
    List<String> wyswietlPracownikowWrtosc();
}