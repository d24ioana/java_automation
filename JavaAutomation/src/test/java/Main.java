import abstractizare.Pisica;
import abstractizare.Sub3;
import mostenire.*;
import polimorfism.Calcul;
import polimorfism.Romb;

public class Main {
    public static void main(String args[])
    {
        //region mostenire
        FiguraGeometrica figura = new FiguraGeometrica("albastru");
        System.out.println(figura.toString());
        figura.setCuloare("roz");
        System.out.println(figura.toString());

        Cerc cerc = new Cerc("galben", 15.2);
        System.out.println(cerc.toString()); //sout
        cerc.setCuloare("turcoaz");
        cerc.setRaza(2);
        cerc.setMesaj(" Acesta este un cerc turcoaz.");
        System.out.println(cerc.toString());

        Triunghi triunghi = new Triunghi("rosu", 10.1, 10.2, 10.3);
        System.out.println(triunghi.toString());
        triunghi.setCuloare("negru");
        triunghi.setLatura1(3);
        triunghi.setLatura2(4);
        triunghi.setBaza(2);
        System.out.println(triunghi.toString());

        Paralelogram paralelogram = new Paralelogram("mov", 3, 4);
        System.out.println(paralelogram.toString());

        Patrat patrat = new Patrat("portocaliu", 2, 2);
        System.out.println(patrat.toString());

        Dreptunghi dreptunghi = new Dreptunghi("maro", 6, 4);
        System.out.println(dreptunghi.toString());
        //endregion

        //region polimorfism
        //Overriding
        Romb romb = new Romb("cenusiu", 5, 3.12, 4, 1.13446);
        System.out.println(romb.Aria());
        System.out.println(romb.toString());

        //Overloading
        System.out.println(Calcul.Inmultire(2,3));
        System.out.println(Calcul.Inmultire(2.33, 3.33));
        System.out.println(Calcul.Inmultire(4,5,6));
        //endregion

        //region abstractizare
        //clasa abstracta
        Pisica pisica = new Pisica(4,"mica", "miau");
        System.out.println(pisica.toString());
        System.out.println(pisica.randomMethod());

        //interfete
        Sub3 sub3 = new Sub3(1000);
        sub3.Deposit(500);
        sub3.Withdraw(755);
        sub3.Deposit(50);
        System.out.println(sub3.ToString());
        //endregion
    }
}
