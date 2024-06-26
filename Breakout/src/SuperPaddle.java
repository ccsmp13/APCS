import java.awt.Color;
import java.awt.Graphics;

public class SuperPaddle extends Paddle{
private double xVel;
	private static final int MAX_VEL = 6;
	public static final int WIDTH = 60;
	public static final int WIDE_WIDTH = 90;
	public static final int HEIGHT = 15;
	private Color color;
	private int leftLim, rightLim;
    private int timer;

    public SuperPaddle(int x, int y, int leftLimit, int rightLimit) {

        super(x,y,leftLimit,rightLimit);
        this.width = WIDTH;
		this.height = HEIGHT;
		this.color = Color.LIGHT_GRAY;
		this.leftLim = leftLimit;
		this.rightLim = rightLimit;
        this.timer = 0;
        

    }
		
	@Override
	public void update() {
		this.xPos += this.xVel;
		if (this.xPos <= this.leftLim || this.xPos + this.width >= this.rightLim) {
			this.changeDir(0);
		}
        
        if (timer > 0){
            this.width = WIDE_WIDTH;
        } else {
            this.width = WIDTH;
        }
        timer--;
	}
	
    public void setTimer(int timer) {
        this.timer = timer;
    }
    
}
