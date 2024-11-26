package pracownicy;

public class Skutecznosc implements I_skutecznosc{

    private String nazwa;
    private int sLiczbowo;

    @Override
    public String getNazwa(){
        return this.nazwa;
    }

    @Override
    public int getSLiczbowo(){
        return this.sLiczbowo;
    }

    @Override
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    @Override
    public void setSLiczbowo(int sLiczbowo){
        this.sLiczbowo = sLiczbowo;
    }

}

class SNiska extends Skutecznosc{
    
    public SNiska(){
        setNazwa("NISKA");
        setSLiczbowo(60);
    }

}

class SSrednia extends Skutecznosc{
    
    public SSrednia(){
        setNazwa("SREDNIA");
        setSLiczbowo(90);
    }
}

class SWysoka extends Skutecznosc{
    
    public SWysoka(){
        setNazwa("WYSOKA");
        setSLiczbowo(120);
    }
}