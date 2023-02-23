package mostenire;

public class Paralelogram extends FiguraGeometrica{
    protected double baza;
    protected double inaltimea;

    public Paralelogram(String culoare, double baza, double inaltimea) {
        super(culoare);
        this.baza = baza;
        this.inaltimea = inaltimea;
    }

    @Override public double Aria(){
        return this.baza * this.inaltimea;
    }

    @Override public double Perimetru(){
        return 2 * (this.baza + this.inaltimea);
    }

    @Override public String toString() { return (super.toString()); }

    public double getBaza(){
        return baza;
    }

    public double getInaltimea(){
        return inaltimea;
    }

    public void setBaza(double baza){
        this.baza = baza;
    }

    public void setInaltimea(double inaltimea){
        this.inaltimea = inaltimea;
    }
}
