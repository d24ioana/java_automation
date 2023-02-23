package mostenire;

import static java.lang.Math.pow;

public class Cerc extends FiguraGeometrica{
    private double raza;
    private String mesaj = " Acesta este un cerc.";

    public Cerc(String culoare, double raza){
        super(culoare);
        this.raza = raza;
    }

    @Override public double Aria(){
        return Math.PI * pow(raza,2);
    }

    @Override public double Perimetru(){
        return 2 * Math.PI * raza;
    }

    @Override public String toString() { return (super.toString() + mesaj); }

    public double getRaza(){
        return raza;
    }

    public String getMesaj() { return mesaj; }

    public void setRaza(double raza){
        this.raza = raza;
    }

    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
}
