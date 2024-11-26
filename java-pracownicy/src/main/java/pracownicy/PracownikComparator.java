package pracownicy;

import java.util.Comparator;

public class PracownikComparator {

    public static class DoswiadczenieComparator implements Comparator<Pracownik> {
        @Override
        public int compare(Pracownik pracownik1, Pracownik pracownik2) {
            return Integer.compare(pracownik2.getDoswiadczenie(), pracownik1.getDoswiadczenie());
        }
    }

    public static class WiekComparator implements Comparator<Pracownik> {
        @Override
        public int compare(Pracownik pracownik1, Pracownik pracownik2) {
            return Integer.compare(pracownik2.getRokUrodzenia(), pracownik1.getRokUrodzenia());
        }
    }

    public static class NazwiskoImieComparator implements Comparator<Pracownik> {
        @Override
        public int compare(Pracownik pracownik1, Pracownik pracownik2) {
            int wynikPorownania = pracownik1.getNazwisko().compareTo(pracownik2.getNazwisko());
            if (wynikPorownania != 0) {
                return wynikPorownania;
            }
            return pracownik1.getImie().compareTo(pracownik2.getImie());
        }
    }

}