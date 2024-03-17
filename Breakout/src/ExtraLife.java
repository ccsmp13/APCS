import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExtraLife extends GameObject {
    private static BufferedImage img;

    static{
        String stage1Path = "Breakout/Heart.png";
        try {
            img = ImageIO.read(new File(stage1Path));
        } catch (IOException e) {
            img = null;
            System.out.println(e + " file: " + stage1Path);
        }
    }

    public ExtraLife(int x, int y){
        super(x,y);
    }
    @Override
	public void paint(Graphics g) {
		g.drawImage(img,(int) this.xPos + 1, (int) this.yPos + 1, this.width - 2, this.height - 2, null);
	}

	@Override
	public void update() {
		this.yPos += 3;
	}

}
