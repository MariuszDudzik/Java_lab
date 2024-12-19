package grywojenne;

public class Stopien {

    private String nazwa;
    private int wartosc;

    public String getNazwa(){
        return this.nazwa;
    }

    public int getWartosc(){
        return this.wartosc;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public void setWartosc(int wartosc){
        this.wartosc = wartosc;
    }

    public Stopien nastepny(){
        if(this instanceof S_Szeregowy){
            return new S_Kapral();
        } else if(this instanceof S_Kapral){
            return new S_Kapitan();
        } else if(this instanceof S_Kapitan){
            return new S_Major();
        } else {
            return new S_Major();
        }
    }
}


class S_Szeregowy extends Stopien{
    
    public S_Szeregowy(){
        setNazwa("SZEREGOWY");
        setWartosc(1);
    }
}

class S_Kapral extends Stopien{
    
    public S_Kapral(){
        setNazwa("KAPRAL");
        setWartosc(2);
    }
}

class S_Kapitan extends Stopien{
    
    public S_Kapitan(){
        setNazwa("KAPITAN");
        setWartosc(3);
    }
}

class S_Major extends Stopien{
    
    public S_Major(){
        setNazwa("MAJOR");
        setWartosc(4);
    }
}