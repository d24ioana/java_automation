package mostenire;

public class Patrat extends Paralelogram {
    private String mesaj = " Acesta este un patrat.";

    public Patrat(String culoare, double baza, double inaltimea) {
        super(culoare, baza, inaltimea);
    }

    @Override public String toString(){
        return (super.toString() + mesaj);
    }

    public String getMesaj(){
        return mesaj;
    }

    public void setMesaj(String mesaj){
        this.mesaj = mesaj;
    }
}
