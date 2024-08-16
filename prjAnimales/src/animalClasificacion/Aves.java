package animalClasificacion;

public abstract class Aves extends Animal{
    private int nroAlas;

    public Aves (){
        nroAlas = 2;
    }

    public int getNroAlas() {
        return nroAlas;
    }

}
