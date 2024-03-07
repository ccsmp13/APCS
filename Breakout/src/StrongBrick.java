import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StrongBrick extends Brick {
    private int strength;
    private static BufferedImage stage1Image;
    private static BufferedImage stage2Image;
    
    

    public StrongBrick(int x, int y) {
        super(x, y);
        this.strength = 3;
    }

    static{
        String stage1Path = "Breakout/Stage1Crack.png";
        try {
            stage1Image = ImageIO.read(new File(stage1Path));
        } catch (IOException e) {
            stage1Image = null;
            System.out.println(e + " file: " + stage1Path);
        }
    }

    static{
        String stage2Path = "Breakout/Stage2Crack.png";
        try {
            stage2Image = ImageIO.read(new File(stage2Path));
        } catch (IOException e) {
            stage2Image = null;
            System.out.println(e + " file: " + stage2Path);
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public void paint(Graphics g){
        g.setColor(this.color); 
		g.fill3DRect((int) this.xPos + 1, (int) this.yPos + 1, this.width - 2, this.height - 2, true);
        if(this.strength == 2){
            g.drawImage(stage1Image,(int) this.xPos + 1, (int) this.yPos + 1,null);
        }
        if(this.strength == 1){
            g.drawImage(stage2Image,(int) this.xPos + 1, (int) this.yPos + 1,null);
        }
        
        
    }
    
}
