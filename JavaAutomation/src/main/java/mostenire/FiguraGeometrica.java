package mostenire;

public class FiguraGeometrica {
    protected String culoare;

    public FiguraGeometrica(String culoare){
        this.culoare = culoare;
    }

    public double Aria() { return 0; }
    //didn't make the class and methods abstract because an abstract class cannot be instantiated

    public double Perimetru(){
        return 0;
    }

    public String toString(){
        return ("Figura geometrica are culoarea " + culoare + ", perimetrul de " + Perimetru() + " si aria de " + Aria() + ".");
    }

    public String getCuloare(){
        return culoare;
    }

    public void setCuloare(String culoare){
        this.culoare = culoare;
    }
}
