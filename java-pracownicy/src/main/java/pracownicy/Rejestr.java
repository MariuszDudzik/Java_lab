package pracownicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

public class Rejestr implements I_rejestr {

    private ArrayList<Pracownik> rejestrPracownikow = new ArrayList<Pracownik>();
    private ArrayList<Character> typyPracownikow = new ArrayList<Character>();

    public ArrayList<Pracownik> getRejestrPracownikow() {
        return rejestrPracownikow;
    }

    public ArrayList<Character> getTypyPracownikow() {
        return typyPracownikow;
    }

    public void dodajBiurowy(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                            String ulica, String numerDomu, String numerMieszkania,
                            String kodPocztowy, String miasto, int intelekt) {
        Pracownik nowyPracownik = new Biurowy(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, 
                                        numerMieszkania, kodPocztowy, miasto, intelekt);

        rejestrPracownikow.add(nowyPracownik);
    }

    public void dodajFizyczny(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                            String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, 
                            String miasto, int silaFizyczna) {
        Pracownik nowyPracownik = new Fizyczny(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, 
                numerMieszkania, kodPocztowy, miasto, silaFizyczna);
    rejestrPracownikow.add(nowyPracownik);
    }

    public void dodajHandlowiec(String imie, String nazwisko, int rokUrodzenia, int doswiadczenie,
                            String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, 
                            String miasto, int prowizja, String skutecznosc) {
        Pracownik nowyPracownik = new Handlowiec(imie, nazwisko, rokUrodzenia, doswiadczenie, ulica, numerDomu, 
                numerMieszkania, kodPocztowy, miasto, prowizja, skutecznosc);
    rejestrPracownikow.add(nowyPracownik);
    }


    public boolean sprawdzTypPracownika(char typ){
        if (Character.toUpperCase(typ) == 'B' || Character.toUpperCase(typ) == 'F' || Character.toUpperCase(typ) == 'H')
            return true;   
        return false;
    }


    public void okreslTypPracownikow(char typ){
        // okresla typy pracownikow jakie maja byc dodane do rejestru
        if (sprawdzTypPracownika(typ)){
            typyPracownikow.add(Character.toUpperCase(typ));
        }
        else{
            throw new IllegalArgumentException("Niepoprawny typ pracownika.");
        } 
    }


    public void dodajPracownikow(DanePracownika dane){
        for (char typ : typyPracownikow) {
            switch (typ) {
                case 'B':  // Biurowy
                    dodajBiurowy(dane.getImie(), dane.getNazwisko(), dane.getRokUrodzenia(), dane.getDoswiadczenie(),
                                dane.getUlica(), dane.getNumerDomu(), dane.getNumerMieszkania(), dane.getKodPocztowy(),
                                dane.getMiasto(), dane.getIntelekt());
                    break;
                case 'F':  // Fizyczny
                    dodajFizyczny(dane.getImie(), dane.getNazwisko(), dane.getRokUrodzenia(), dane.getDoswiadczenie(),
                                dane.getUlica(), dane.getNumerDomu(), dane.getNumerMieszkania(), dane.getKodPocztowy(),
                                dane.getMiasto(), dane.getSilaFizyczna());
                    break;
                case 'H':  // Handlowiec
                    dodajHandlowiec(dane.getImie(), dane.getNazwisko(), dane.getRokUrodzenia(), dane.getDoswiadczenie(),
                                dane.getUlica(), dane.getNumerDomu(), dane.getNumerMieszkania(), dane.getKodPocztowy(),
                                dane.getMiasto(), dane.getProwizja(), dane.getSkutecznosc());
                    break;
                default:
                    throw new IllegalArgumentException("Niepoprawny typ pracownika.");
            }
        }
    }

    public void usunPracownika(int idPracownika) {
        boolean znacznik = false;
        for (int i = 0; i < rejestrPracownikow.size(); i++) {
            if (rejestrPracownikow.get(i).getIdPracownika() == idPracownika) {
                rejestrPracownikow.remove(i);
                znacznik = true;
                break;
            }
        }
        if (!znacznik) {
            throw new IllegalArgumentException("Nie ma pracownika o podanym id.");
        }
    }

    public List<String> wyswietlPoDoswiadczeniu() {
        Collections.sort(rejestrPracownikow, new PracownikComparator.DoswiadczenieComparator());
        List<String> wynik = new ArrayList<>();
        for (Pracownik pracownik : rejestrPracownikow) {
            wynik.add(pracownik.getImie() + " " + pracownik.getNazwisko() + " - " +
                    pracownik.getDoswiadczenie());
        }
        return wynik;
    }

    public List<String> wyswietlPoWieku() {
        Collections.sort(rejestrPracownikow, new PracownikComparator.WiekComparator());
        List<String> wynik = new ArrayList<>();
        for (Pracownik pracownik : rejestrPracownikow) {
            wynik.add(pracownik.getImie() + " " + pracownik.getNazwisko() + " - " + 
            (LocalDate.now().getYear()- pracownik.getRokUrodzenia()));
        }
        return wynik;
    }

    public List<String> wyswietlPoNazwiskuImieniu() {
        Collections.sort(rejestrPracownikow, new PracownikComparator.NazwiskoImieComparator());
        List<String> wynik = new ArrayList<>();
        for (Pracownik pracownik : rejestrPracownikow) {
            wynik.add(pracownik.getNazwisko() + " " + pracownik.getImie());
        }
        return wynik;
    }


    public List<String> wyswietlPracownikowZmiasta(String miasto) {
        Collections.sort(rejestrPracownikow, new PracownikComparator.NazwiskoImieComparator());
        List<String> wynik = new ArrayList<>();
        for (Pracownik pracownik : rejestrPracownikow) {
            if (pracownik.getAdres().getMiasto().equalsIgnoreCase(miasto)) {
                wynik.add(pracownik.getImie() + " " + pracownik.getNazwisko() + " - " + pracownik.getAdres().getMiasto());
            }
        }
        return wynik;
    }

    public List<String> wyswietlPracownikowWrtosc() {
        Collections.sort(rejestrPracownikow, new PracownikComparator.NazwiskoImieComparator());
        List<String> wynik = new ArrayList<>();
        int wartosc = 0;    
        for (Pracownik pracownik : rejestrPracownikow) {
            if (pracownik instanceof Biurowy) {
                Biurowy pracownikBiurowy = (Biurowy) pracownik;
                wartosc = pracownikBiurowy.getDoswiadczenie() * pracownikBiurowy.getIntelekt();
            }
            else if (pracownik instanceof Fizyczny) {
                Fizyczny pracownikFizyczny = (Fizyczny) pracownik;
                wartosc = (pracownikFizyczny.getDoswiadczenie() * pracownikFizyczny.getSilaFizyczna() / 
                (LocalDate.now().getYear() - pracownikFizyczny.getRokUrodzenia()));
            }
            else if (pracownik instanceof Handlowiec) {
                Handlowiec pracownikHandlowiec = (Handlowiec) pracownik;
                wartosc = pracownikHandlowiec.getDoswiadczenie() * pracownikHandlowiec.getSkutecznosc().getSLiczbowo();
            }
                
            wynik.add(pracownik.getImie() + " " + pracownik.getNazwisko() + " - " + 
            pracownik.getClass().getSimpleName() + " " + wartosc);
            
        }
        return wynik;
    }

}
