package clasificacionAnimal;

public abstract class Invertebrado extends ReinoAnimal{
    private Integer nroHuesos;

    
    public Invertebrado(){
        nroHuesos = 0;
        }
        
    public Integer getNroHuesos() {
        return nroHuesos;
    }
    
}
