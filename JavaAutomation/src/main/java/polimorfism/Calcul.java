package polimorfism;

public class Calcul {
    //overriding - when derived class has same method as base class; the return type is the same
    //overloading:
    public static int Inmultire(int a, int b){
        return a * b;
    }

    public static int Inmultire(int a, int b, int c){
        return a * b * c;
    }

    public static double Inmultire(double a, double b){
        return a * b;
    }
}
