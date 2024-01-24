public class Dot {
    private double x;  //x and y follow best practice
    private double y;
    double z;  //z shows examples of bad practice

    public Dot(){
        this.x = 0;
        this.y = 0;
        z = 0;
    }
    
    public Dot(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //if you allow users to make changes to variables, the object is mutable
    public void move(double dx, double dy, double dz){
        this.x += dx;
        this.y += dy;
        this.z += dz;

    }
    
    public String toString(){
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
    public double distance(Dot other){
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

}
