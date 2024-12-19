package grywojenne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class General {
    private String nazwa;
    private int skarbiec;
    private ArrayList<Zolnierz> armia = new ArrayList<Zolnierz>();
    private ArrayList<Integer> manewry = new ArrayList<Integer>();
    private boolean flaga_zaatakuj = false;
    private boolean flaga_zakoncz_manewry = false;
    private boolean flaga_zakoncz_bitwa = false;
    private int zakupiono = 0;
    private int szkolono = 0;

    public General(String nazwa) {
        this.nazwa = nazwa;
        this.skarbiec = 1000;
    }

    public ArrayList<Zolnierz> getArmia() {
        return this.armia;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public int getSkarbiec() {
        return this.skarbiec;
    }

    public int getZakupiono() {
        return this.zakupiono;
    }

    public int getSzkolono() {
        return this.szkolono;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setWartosc(int skarbiec) {
        this.skarbiec = skarbiec;
    }

    public void setSzkolono(int szkolono) {
        this.szkolono = szkolono;
    }

    public void setFlaga_zakoncz_bitwa() {
        this.flaga_zakoncz_bitwa = true;
        Logi.dodajLog(5, this.getNazwa(), "zakonczyl faze 3");
    }

    public void setFlaga_zakoncz_manewry() {
        this.flaga_zakoncz_manewry = true;
        Logi.dodajLog(4, this.getNazwa(), "zakonczyl faze 2");
    }

    public boolean getFlaga_zakoncz_bitwa() {
        return this.flaga_zakoncz_bitwa;
    }

    public boolean getFlaga_zakoncz_manewry() {
        return this.flaga_zakoncz_manewry;
    }

    public boolean getFlaga_zaatakuj() {
        return this.flaga_zaatakuj;
    }

    public void setFlaga_zaatakuj() {
        this.flaga_zaatakuj = true;
        Logi.dodajLog(3, this.getNazwa(), "zadeklarował atak");
    }

    public void zerujFlagi() {
        this.flaga_zakoncz_bitwa = false;
        this.flaga_zakoncz_manewry = false;
        this.flaga_zaatakuj = false;
        this.zakupiono = 0;
        this.szkolono = 0;
    }

    public int kosztZakupu(int stopien) {
        return stopien * 10;
    }

    public int kosztManewrow(int stopien) {
        return stopien;
    }

    public Zolnierz stworzZolnierz(char opcja) {
        Stopien stopien = null;
        switch (opcja) {
            case 's':
                stopien = new S_Szeregowy();
                break;
            case 'k':
                stopien = new S_Kapral();
                break;
            case 'K':
                stopien = new S_Kapitan();
                break;
            case 'm':
                stopien = new S_Major();
                break;
        }
        Zolnierz zolnierz = new Zolnierz(stopien);
        return zolnierz;
    }

    public void kupZolnierza(char opcja) {
        Zolnierz zolnierz = this.stworzZolnierz(opcja);

        if (this.getSkarbiec() >= this.kosztZakupu(zolnierz.getStopien().getWartosc())) {
            this.armia.add(zolnierz);
            this.skarbiec -= this.kosztZakupu(zolnierz.getStopien().getWartosc());
            this.zakupiono++;
            Logi.dodajLog(1, this.getNazwa(), zolnierz.getStopien().getNazwa());
        } else {
            throw new RuntimeException("Brak funduszy na zakup zolnierza");
        }
    }

    public void stworzListeManewry(Zolnierz zolnierz) {
        if (!(zolnierz.getNaManewrach()))
            this.manewry.add(zolnierz.getNrNiesmiertelnika());
        else
            throw new RuntimeException("Zolnierz nie moze byc na manewrach");
    }

    public int kosztManewrow() {
        int koszt = 0;
        for (int i = 0; i < this.manewry.size(); i++) {
            for (int j = 0; j < this.armia.size(); j++) {
                if (this.manewry.get(i) == this.armia.get(j).getNrNiesmiertelnika()) {
                    koszt += this.kosztManewrow(this.armia.get(j).getStopien().getWartosc());
                }
            }
        }
        return koszt;
    }

    public void wyslijNaManewry() {
        int koszt = this.kosztManewrow();
        int ilosc_szkolonych = this.manewry.size();
        if (this.getSkarbiec() >= koszt) {
            for (int i = 0; i < this.manewry.size(); i++) {
                for (int j = 0; j < this.armia.size(); j++) {
                    if (this.manewry.get(i) == this.armia.get(j).getNrNiesmiertelnika()) {
                        this.armia.get(j).setNaManewrach();
                        String tekst = "" + this.armia.get(j).getNrNiesmiertelnika();
                        Logi.dodajLog(2, this.getNazwa(), tekst);
                    }
                }
            }
            this.skarbiec -= koszt;
            this.setSzkolono(ilosc_szkolonych);
            this.manewry.clear();
        } else {
            throw new RuntimeException("Brak funduszy na wyslanie zolnierzy na manewry");
        }
    }

    public void zapiszStanDoPliku(String plik, String gracz) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plik))) {
            int nr = Zolnierz.getNrBierzacyNies();
            writer.write("GENERAL=" + gracz + "\n");

            writer.write("nazwa=" + this.nazwa + "\n");
            writer.write("skarbiec=" + this.skarbiec + "\n");
            writer.write("zakupiono=" + this.zakupiono + "\n");
            writer.write("szkolono=" + this.szkolono + "\n");
            writer.write("flaga_zaatakuj=" + this.flaga_zaatakuj + "\n");
            writer.write("flaga_zakoncz_manewry=" + this.flaga_zakoncz_manewry + "\n");
            writer.write("flaga_zakoncz_bitwa=" + this.flaga_zakoncz_bitwa + "\n");
            writer.write("nrBiezacyNiesmiertelnik=" + nr + "\n");

            writer.write("armia=" + this.armia.size() + "\n");
            for (Zolnierz zolnierz : armia) {
                writer.write("zolnierz=" 
                        + zolnierz.getNrNiesmiertelnika() + ","
                        + zolnierz.getStopien().getNazwa() + ","
                        + zolnierz.getDoswiadczenie() + ","
                        + zolnierz.getSila() + ","
                        + zolnierz.getNaManewrach() + "\n");
            }

            System.out.println("Stan zapisano do pliku: " + plik);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania stanu: " + e.getMessage());
        }
    }

    public void wczytajStanZPliku(String plik) {
        try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
            String wiersz;
            boolean odczytujDane = true;
            this.armia.clear();
            this.manewry.clear();
            
            while ((wiersz = reader.readLine()) != null) {
              
    
                if (odczytujDane) {
                    String[] czesc = wiersz.split("=");
                    switch (czesc[0]) {
                        case "nazwa":
                            this.nazwa = czesc[1];
                            break;
                        case "skarbiec":
                            try {
                                this.skarbiec = Integer.parseInt(czesc[1]); 
                            } catch (NumberFormatException e) {
                                System.err.println("Błąd parsowania skarbiec: " + czesc[1]);
                            }
                            break;
                        case "zakupiono":
                            try {
                                this.zakupiono = Integer.parseInt(czesc[1]);
                            } catch (NumberFormatException e) {
                                System.err.println("Błąd parsowania zakupiono: " + czesc[1]);
                            }
                            break;
                        case "szkolono":
                            try {
                                this.szkolono = Integer.parseInt(czesc[1]);
                            } catch (NumberFormatException e) {
                                System.err.println("Błąd parsowania szkolono: " + czesc[1]);
                            }
                            break;
                        case "flaga_zaatakuj":
                            this.flaga_zaatakuj = Boolean.parseBoolean(czesc[1]);
                            break;
                        case "flaga_zakoncz_manewry":
                            this.flaga_zakoncz_manewry = Boolean.parseBoolean(czesc[1]);
                            break;
                        case "flaga_zakoncz_bitwa":
                            this.flaga_zakoncz_bitwa = Boolean.parseBoolean(czesc[1]);
                            break;
                        case "nrBiezacyNiesmiertelnik":
                            Zolnierz.setNrBierzacyNies(Integer.parseInt(czesc[1]));
                            break;
                        case "zolnierz":
                            try {
                                String[] zolnierzParts = czesc[1].split(",");
                                if (zolnierzParts.length == 5) {
                                    int nrNiesmiertelnika = Integer.parseInt(zolnierzParts[0]);
                                    String stopienNazwa = zolnierzParts[1];
                                    int doswiadczenie = Integer.parseInt(zolnierzParts[2]);
                                    int sila = Integer.parseInt(zolnierzParts[3]);
                                    boolean naManewrach = Boolean.parseBoolean(zolnierzParts[4]);
    
                                    Stopien stopien = null;
                                    switch (stopienNazwa) {
                                        case "SZEREGOWY":
                                            stopien = new S_Szeregowy();
                                            break;
                                        case "KAPRAL":
                                            stopien = new S_Kapral();
                                            break;
                                        case "KAPITAN":
                                            stopien = new S_Kapitan();
                                            break;
                                        case "MAJOR":
                                            stopien = new S_Major();
                                            break;
                                    }
    
                                    Zolnierz zolnierz = new Zolnierz(stopien);
                                    zolnierz.setNrNiesmiertelnika(nrNiesmiertelnika);
                                    zolnierz.setDoswiadczenie(doswiadczenie);
                                    zolnierz.setSila2(sila);
    
                                    if (naManewrach) {
                                        zolnierz.setNaManewrach();
                                    }
                                    this.armia.add(zolnierz);
                                } else {
                                    System.err.println("Nieprawidłowa liczba elementów dla zolnierz w pliku: " + czesc[1]);
                                }
                            } catch (Exception e) {
                                System.err.println("Błąd wczytywania zolnierza: " + e.getMessage());
                            }
                            break;
                    }
                }
            }
    
            System.out.println("Stan wczytano z pliku: " + plik);
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania stanu: " + e.getMessage());
        }
    }
    
}