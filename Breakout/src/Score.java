import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score implements Animatable{

	int x, y;

	public Score(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.setColor(Color.WHITE);
		g.drawString("Score:       Lives:      ", this.x, this.y);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
