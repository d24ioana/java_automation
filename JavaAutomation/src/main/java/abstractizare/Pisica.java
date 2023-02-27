package abstractizare;

public class Pisica extends Animal{
    private String animalSound;

    public Pisica(int nrPicioare, String marime, String animalSound){
        super(nrPicioare, marime);
        this.animalSound = animalSound;
    }

    @Override public String toString(){
        return ("Pisica face " + animalSound);
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }
}
