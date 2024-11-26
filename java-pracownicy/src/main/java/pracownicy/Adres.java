package pracownicy;

public class Adres implements I_adres {
    private String ulica;
    private String numerDomu;
    private String numerMieszkania;
    private String kodPocztowy;
    private String miasto;

    public Adres(String ulica, String numerDomu, String numerMieszkania, String kodPocztowy, String miasto) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    @Override
    public String getUlica() {
        return ulica;
    }

    @Override
    public String getNumerDomu() {
        return numerDomu;
    }

    @Override
    public String getNumerMieszkania() {
        return numerMieszkania;
    }

    @Override
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    @Override
    public String getMiasto() {
        return miasto;
    }

    @Override
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Override
    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }

    @Override
    public void setNumerMieszkania(String numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    @Override
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String getCalyAdres() {
        return "Adres: " + this.ulica + " " + this.numerDomu + "/" + this.numerMieszkania + ", " + this.kodPocztowy + " " + this.miasto;
    }

}