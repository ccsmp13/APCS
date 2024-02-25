public class Gravel extends Block {

    public Gravel(int x, int y, int z){
        super("gravel",x,y,z);

    }
    public double checkStrength(){
        return this.getStrength();
    }
}
