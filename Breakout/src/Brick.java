import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObject {

	Color color;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 20;
	private static final Color[] COLOR_PALETTE = { Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
			Color.BLUE };

	public Brick(int x, int y) {
		super(x, y);
		this.width = WIDTH;
		this.height = HEIGHT;
		this.color = COLOR_PALETTE[Math.min(5, y / this.height - 1)];
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fill3DRect((int) this.xPos + 1, (int) this.yPos + 1, this.width - 2, this.height - 2, true);
	}

	@Override
	public void update() {
		// do nothing
	}

}
