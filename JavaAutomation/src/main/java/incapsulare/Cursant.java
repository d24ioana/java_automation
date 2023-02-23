package incapsulare;

public class Cursant {
    //region class variables
    private String numeCursant;
    private int varstaCursant;
    //endregion

    //region class constructors
    public Cursant(String numeCursant, int varstaCursant){
        this.numeCursant = numeCursant;
        this.varstaCursant = varstaCursant;
    }
    //endregion

    //region class methods
    public String StadiuAdmisRespins(double nota){
        if (nota < 5)
            return "Nu";
        else if (nota >= 5)
            return "Da";
        else
            return "Nota cursantului este invalida";
    }
    //endregion

    //region class getters
    public String getNumeCursant(){
        return numeCursant;
    }

    public int getVarstaCursant(){
        return varstaCursant;
    }
    //endregion

    //region class setters
    //public void setNumeCursant(String newNumeCursant) { numeCursant = newNumeCursant; } sau:
    public void setNumeCursant(String numeCursant) { this.numeCursant = numeCursant; }

    public void setVarstaCursant(int varstaCursant){
        this.varstaCursant = varstaCursant;
    }
    //endregion
}
