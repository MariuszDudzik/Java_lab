package pracownicy;

public interface I_adres {
    public String getUlica();
    public String getNumerDomu();
    public String getNumerMieszkania();
    public String getKodPocztowy();
    public String getMiasto();
    public void setUlica(String ulica);
    public void setNumerDomu(String numerDomu);
    public void setNumerMieszkania(String numerMieszkania);
    public void setKodPocztowy(String kodPocztowy);
    public void setMiasto(String miasto);
    public String getCalyAdres();
}