public class MoralesFrancisco {
    //private int mfNivel;
    private String mfSimboloMas;
    private String mfSimboloMenos;
    private String mfSimboloLinea;
    

    
    // public int getmfNivel() {
    //     return mfNivel;
    // }
    
    // public void setmfNivel(int mfNivel) {
    //     this.mfNivel = mfNivel;
    // }
    
    public String getmfSimboloMas() {
        return mfSimboloMas;
    }

    public void setmfSimboloMas(String mfSimboloMas) {
        this.mfSimboloMas = mfSimboloMas;
    }
    
    public String getmfSimboloMenos() {
        return mfSimboloMenos;
    }
    
    public void setmfSimboloMenos(String mfSimboloMenos) {
        this.mfSimboloMenos = mfSimboloMenos;
    }
    
    public String getSimboloLinea() {
        return mfSimboloLinea;
    }

    public void setSimboloLinea(String mfSimboloLinea) {
        this.mfSimboloLinea = mfSimboloLinea;
    }

    public void mfF10(int mfNivel, String mfSimboloMas, String mfSimboloMenos, String mfSimboloLinea){
        
        System.out.println("Figura 10: ");        
        for (int i = 0; i < mfNivel; i++) {

            System.out.println(i % 2 == 0 ? mfSimboloLinea + mfSimboloMas + mfSimboloLinea: mfSimboloLinea + mfSimboloMenos + mfSimboloLinea);
            for (int j = 0; j < i+1; j++) {
                System.out.print("    ");
            }
            System.out.print("|");

        }
        System.out.println("");
    }
    
    public void mfF11(int mfNivel, String mfSimboloMenos, String mfSimboloLinea){
        
        int espaciado = 0; 
        System.out.println("Figura 11: ");        
        for (int i = 0; i < mfNivel; i++) {
            
            System.out.print("|");
            for (int j = 0; j < i+1; j++) {
                System.out.print("_");
                espaciado++;
            }

            System.out.println("");
            espaciado++;

            for (int j = 0; j < espaciado; j++) {
                System.out.print(" ");
            }
            
        }
        System.out.println("");
    }

    public void mfF12(int mfNivel){

        int num;
        System.out.println("Figura 12: ");

        for (int i = 0; i < mfNivel; i++) {
            num = 1;
            for (int j = mfNivel; j > i ; j--) {
                System.out.print(num++);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void mfF13(int mfNivel){

        System.out.println("Figura 13: ");

        for (int i = 1; i <= mfNivel; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mfF14(int mfNivel){
        int mfEspaciado = mfNivel;
        System.out.println("Figura 14: ");
        
        for (int i = 0; i < mfNivel; i++) {
            
            int mfNumero = 1;            
            for (int j = 0; j < (mfEspaciado*2) - 2; j++) {
                System.out.print(" ");
            }
            
            for (int j = 0; j <= i; j++) {
                System.out.print(mfNumero + "   ");
                mfNumero = mfNumero * (i - j) / (j + 1);
            }
            
            mfEspaciado += -1;
            System.out.println("");
        }
        System.out.println("");
    }

    public void mfF15(int mfNivel){
        
        System.out.println("Figura 15: ");
        
        for (int i = 0; i < mfNivel; i++) {
            
            int mfNumero = 1;            
            
            for (int j = 0; j <= i; j++) {
                System.out.print(mfNumero + "   ");
                mfNumero = mfNumero * (i - j) / (j + 1);
            }
            
            System.out.println("");
        }
        System.out.println("");
    }

    public void mfF16(int mfNivel, String mfSimboloMenos, String mfSimboloMas){
        
        System.out.println("Figura 16: ");

        for (int i = 0; i < mfNivel; i++) {
            if (i % 4 == 0 || i == 0){
                System.out.println(mfSimboloMas +  "               " + mfSimboloMas);
            }else if(i % 2 != 0){
                System.out.println("    " + mfSimboloMenos +   "       " + mfSimboloMenos);
            }else{
                System.out.println("        " + mfSimboloMas);
            }
        }
    }

    public void mfF17(int mfNivel){
        
        System.out.println("Figura 17: ");

        for (int i = 0; i < mfNivel; i++) {
            if (i % 4 == 0 || i == 0){
                System.out.println(1 +  "               " + 1);
            }else if(i % 2 != 0){
                System.out.println("    " + 0 +   "       " + 0);
            }else{
                System.out.println("        " + 1);
            }
        }
    }

}
