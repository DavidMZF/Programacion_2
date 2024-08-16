package mFReptiles;

import mFFanerozoico.MFReptiles;
import mFInterfaces.IMFComportamientoTurtle;

public class MFTurtle extends MFReptiles implements IMFComportamientoTurtle{
    private String mFNombreTurtle;
    
    public MFTurtle(){
        this.mFNombreTurtle = "David";
        mFPresentar("Turtle", 7);
        mFNacer(mFNombreTurtle, "Turtle");
        mFSaludar(mFNombreTurtle, "Turtle");
    }


    @Override
    public void mFNacer(String mFNombre, String mFEspecie) {
        System.out.println(mFNombre + " es un " + mFEspecie);
    }

    @Override
    public void mFSaludar(String mFNombre, String mFEspecie){
        System.out.println("Hola Sr.Biologo " + " soy un " + mFEspecie + " llamado "+ mFNombre);
    }
}
