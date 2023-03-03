package Exemplu2;

public class PersoanaStudent extends Persoana{
    //clasa abstracta te obliga sa mostenesti toate metodele (si pentru angajat si pentru somer)
    //trebuie sa ne definim si variabilele
    private String nume;
    private String prenume;

    public PersoanaStudent(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public void munceste() {

    }

    @Override
    public void salariu() {

    }

    @Override
    public void invata() {

    }

    @Override
    public void mergeLaCursuri() {

    }

    @Override
    public void sta() {

    }

    @Override
    public void ajutor() {

    }
}
