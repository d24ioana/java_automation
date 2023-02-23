package mostenire;

public class Triunghi extends FiguraGeometrica{
    private double latura1;
    private double latura2;
    private double baza;
    private String mesaj = " Acesta este un triunghi.";

    public Triunghi(String culoare, double latura1, double latura2, double baza){
        super(culoare);
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.baza = baza;
    }

    @Override public double Aria(){
        return Math.sqrt(Perimetru()/2 * (Perimetru()/2 - latura1) * (Perimetru()/2 - latura2) *(Perimetru()/2 - baza));
    }

    @Override public double Perimetru(){
        return latura1 + latura2 + baza;
    }

    @Override public String toString() { return (super.toString() + mesaj); }

    public double getLatura1() { return latura1; }

    public double getLatura2() { return latura2; }

    public double getBaza() { return baza; }

    public String getMesaj() { return mesaj; }

    public void setLatura1(double latura1) { this.latura1 = latura1; }

    public void setLatura2(double latura2) { this.latura2 = latura2; }

    public void setBaza(double baza) { this.baza = baza; }

    public void setMesaj(String mesaj) { this.mesaj = mesaj; }

}
