package animalClasificacion;

public abstract class Ave extends Animal {
    private int nroAla;

    public Ave() {
        nroAla = 2;
    }

    public int getNroAla() {
        return nroAla;
    }
}
