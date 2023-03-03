package Exemplu;

public class PersoanaAngajat extends Persoana implements Angajat{
    //din Persoana ne luam proprietatile;
    //din Interfata ne luam comportamentul;

    public PersoanaAngajat(String nume, String prenume, String adresa) {
        super(nume, prenume, adresa);
    }

    @Override
    public void munceste() {
        System.out.println("");
    }

    @Override
    public void primesteSalariu() {

    }
}
