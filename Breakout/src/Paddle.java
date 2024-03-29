import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {

	private double xVel;
	private static final int MAX_VEL = 6;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 15;
	private Color color;
	private int leftLim, rightLim;
	private int dir;

	public Paddle(int x, int y, int leftLimit, int rightLimit) {
		super(x, y);
		this.width = WIDTH;
		this.height = HEIGHT;
		this.color = Color.LIGHT_GRAY;
		this.leftLim = leftLimit;
		this.rightLim = rightLimit;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRoundRect((int)this.xPos, (int)this.yPos, this.width, this.height, this.height/2, this.height/2);
	}
		
	@Override
	public void update() {
		this.xPos += this.xVel;
		if (this.xPos <= this.leftLim || this.xPos + this.width >= this.rightLim) {
			this.changeDir(0);
		}
	}
	
	
	public void changeDir(int d) {
		dir = d;
		if(d > 0) {
			this.xVel = MAX_VEL;
		}else if( d < 0) {
			this.xVel = -MAX_VEL;
		}else {
			this.xVel = 0;
		}
		
	}

	public int getDir(){
		return dir;
	}

	public double getxPos() {
		return this.xPos;
	}
	public double getyPos() {
		return this.yPos;
	}

	public static int getMaxVel() {
		return MAX_VEL;
	}

	public Color getColor() {
		return color;
	}

	public int getLeftLim() {
		return leftLim;
	}

	public int getRightLim() {
		return rightLim;
	}

}
