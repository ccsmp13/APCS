public class App {
    public static void main(String[] args) throws Exception {
        Gravel gr = new Gravel(3, 4, 5);
        System.out.println(gr);
        gr.damage(10);
    }
}
