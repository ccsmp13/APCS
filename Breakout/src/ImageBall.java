import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageBall extends Ball {

	private BufferedImage img;

	

	public ImageBall(int x, int y, String s, int radius) {
		super(x, y);
		this.radius = radius;
		String stage1Path = "Breakout/" + s + ".png";
        try {
            img = ImageIO.read(new File(stage1Path));
        } catch (IOException e) {
            img = null;
            System.out.println(e + " file: " + stage1Path);
        }
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img,(int)this.xPos - this.radius, (int)this.yPos - this.radius, 2*this.radius, 2*this.radius,null);
	}

}
