package pracownicy;

public interface I_skutecznosc {
    public String getNazwa();
    public int getSLiczbowo();
    public void setNazwa(String nazwa);
    public void setSLiczbowo(int sLiczbowo);
    public static Skutecznosc stworzSkutecznosc(String nazwa) { 
        switch (nazwa.toUpperCase()) {
            case "NISKA":
                return new SNiska();
            case "SREDNIA":
                return new SSrednia();
            case "WYSOKA":
                return new SWysoka();
            default:
                throw new IllegalArgumentException("Nieznana skuteczność: " + nazwa);
        }
    }
}