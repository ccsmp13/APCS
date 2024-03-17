import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasketBall extends ImageBall {

    // ball is _centered_ on the inherited xPos, yPos
    protected double xVel, yVel;
    protected int radius;

    public BasketBall(int x, int y) {
        super(x, y, "BasketBall", 21);
        this.radius = 21;
        this.xVel = 4;
        this.yVel = 6;

    }

    @Override
    public void update() {
        this.xPos += this.xVel;
        this.yPos += this.yVel;

    }

    public boolean isTouching(GameObject o) {

        int padding = this.radius / 3;
        Rectangle bottomZone = new Rectangle((int) o.xPos - padding, (int) o.yPos + o.height, o.width + 2 * padding,
                this.radius);
        if (bottomZone.contains(this.xPos, this.yPos)) {
            this.yVel = Math.abs(this.yVel);
            return true;
        }
        Rectangle leftZone = new Rectangle((int) o.xPos - this.radius, (int) o.yPos - padding, this.radius,
                o.height + 2 * padding);
        if (leftZone.contains(this.xPos, this.yPos)) {
            this.xVel = -Math.abs(this.xVel);
            return true;
        }
        Rectangle rightZone = new Rectangle((int) o.xPos + o.width, (int) o.yPos - padding, this.radius,
                o.height + 2 * padding);
        if (rightZone.contains(this.xPos, this.yPos)) {
            this.xVel = Math.abs(this.xVel);
            return true;
        }
        Rectangle topZone = new Rectangle((int) o.xPos + padding, (int) o.yPos - this.radius, o.width + 2 * padding,
                this.radius);
        if (topZone.contains(this.xPos, this.yPos)) {
            this.yVel = -Math.abs(this.yVel);
            return true;
        }
        return false;
    }

}
