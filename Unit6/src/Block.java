public class Block {
    private String name;
    private int x, y, z;
    private double strength;

    public Block(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.strength = 100;
    }

    

    public String damage(double hitStrength) {
        this.strength -= hitStrength;
        if (this.strength <= 0) {
            return name;
        } else {
            return null;
        }

    }

    @Override
    public String toString() {
        return "Block: " + name + " at (" + x + "," + y + "," + z + ")";
    }




    public double getStrength() {
        return strength;
    }

    
}
