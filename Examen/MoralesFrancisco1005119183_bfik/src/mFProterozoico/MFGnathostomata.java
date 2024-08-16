package mFProterozoico;

public abstract class MFGnathostomata {

    public MFGnathostomata(){
        mFPresentar("Gnathostomata", 1);
    }

    public void mFPresentar (String mFClaseNombre, int nivel){
        MFUtil oMFUtil = new MFUtil();
        oMFUtil.mFMostrarSpinner(nivel);
        System.out.println("-".repeat(nivel * 4) + " " + mFClaseNombre);
    }
}
