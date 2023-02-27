package polimorfism;

import mostenire.Paralelogram;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Romb extends Paralelogram {
    private String mesaj = " Acesta este un romb.";
    private double latura;

    private double unghi;

    public Romb(String culoare, double baza, double inaltimea, double latura, double unghi){
        super(culoare, baza, inaltimea);
        this.latura = latura;
        this.unghi = unghi;
    }

    @Override public double Aria() { return pow(latura,2) * sin(unghi); }

    @Override public String toString(){
        return (super.toString() + mesaj);
    }

    public double getLatura() { return latura; }

    public String getMesaj() { return mesaj; }

    public void setLatura(double latura) { this.latura = latura; }

    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
}
