package abstractizare;

public abstract class Animal {
    protected int nrPicioare;
    protected String marime;

    public Animal(int nrPicioare, String marime){
        this.nrPicioare = nrPicioare;
        this.marime = marime;
    }

    public abstract String toString();

    public String randomMethod(){
        return "Whatever";
    };

    public int getNrPicioare() {
        return nrPicioare;
    }

    public void setNrPicioare(int nrPicioare) {
        this.nrPicioare = nrPicioare;
    }

    public String getMarime() {
        return marime;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }
}
