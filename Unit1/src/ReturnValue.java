public class ReturnValue {
    
    public static void main(String[] args){

        System.out.println(calcTime(40000));
        System.out.println(calcRoots(1, -5, -14));
        System.out.println(calcCylinderVolume(5, 10));
    }

    public static String calcTime(int seconds){

        int hours = seconds / (60*60);
        int minutes = seconds % (60*60) / 60;
        int remSeconds = seconds % (60*60) % 60;
        
        String output = String.format("%02d:%02d:%02d",hours,minutes, remSeconds);
        return output;
        
    }
    public static String calcRoots(double a, double b, double c){

        double posResult = (-b + Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));
        double negResult = (-b - Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));


        String output = String.format("The positive root is %f\n The negative root is %f",posResult,negResult);
        return output;
    }
    public static String calcCylinderVolume(double d, double h){

        
        double r = d / 2;
        double volume = Math.PI * (r) * (r) * (h);


        String output = String.format("The volume for this cylinder is %f\n",volume);
        return output;
    }
}
