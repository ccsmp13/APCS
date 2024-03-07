import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BreakoutPanel extends JPanel implements KeyListener{

	int screenWidth = 600;
	int screenHeight = 400;
	long prevTime = 0;
	int framerate = 30;
	int delayVal = 1000/framerate;
	boolean pause;
	Ball ball1;
	int ballsLeft = 10;
	Paddle paddle1;
	ArrayList<GameObject> objects;
	
	public BreakoutPanel() {
		int rand = 0;
		Dimension screen = new Dimension(screenWidth, screenHeight);
		setPreferredSize(screen);
		setBackground(Color.BLACK);
		addKeyListener(this);
		ball1 = new Ball(screenWidth / 3, screenHeight / 2);
		objects = new ArrayList<GameObject>();
		paddle1 = new Paddle(screenWidth / 2, screenHeight - 20, 0, screenWidth);
		objects.add(paddle1);
		objects.add(new Wall(0,-1,screenWidth,1)); //top
		objects.add(new Wall(-1,0,1,screenHeight)); //left
		objects.add(new Wall(screenWidth,0,1,screenHeight)); //right
		for(int x = Brick.WIDTH; x <= screenWidth - 2 * Brick.WIDTH; x += Brick.WIDTH) {
			for( int y = 6 * Brick.HEIGHT; y >= Brick.HEIGHT * 2; y -= Brick.HEIGHT) {
				rand = (int)(Math.random() * 10 + 1);
				if (rand == 2){
					objects.add(new StrongBrick(x, y));	
				} else{
					objects.add(new Brick(x, y));				

				}
				
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(GameObject o : objects) {
			
			o.paint(g);
		}
		ball1.paint(g);
	}

	public void run() {
		while (true) {
			while(pause) {
				delay(100);
			}
			tick();
			repaint();
			calcDelay();
			delay(delayVal); 
		}
	}
	
	public void tick() {
		ball1.update();
		if(ball1.yPos > screenHeight + 200){
			ball1 = new Ball(screenWidth / 2, screenHeight /2);
			ballsLeft--;
			if(ballsLeft == 0){
				System.exit(0);
			}
		}
		for(GameObject o : objects) {
			o.update();
		}
		checkCollisions();
	}
	
	private void calcDelay() {
		int delta = (int)(System.currentTimeMillis() - prevTime);
		prevTime += delta;	//reset to current time		
		if(delta > 1000/framerate) {
			delayVal = Math.max(0, delayVal-1);
		}if(delta < 1000/framerate) {
			delayVal++;
		}
	}
	
	private void checkCollisions() {
		ArrayList<GameObject> deleteList = new ArrayList<GameObject>();
		for(GameObject o: objects) {
			if(ball1.isTouching(o)) { 
				 //isTouching handles ball bounce
				 if (o instanceof StrongBrick){
					StrongBrick brick = (StrongBrick)o;
					int s = brick.getStrength();
					if (s == 1){
						deleteList.add(o);
						break;
					} else {
						brick.setStrength(s - 1);
					}
				 } else if(o instanceof Brick) {
					deleteList.add(o);
					break;
				}
			}
		}
		objects.removeAll(deleteList);
	}

	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle1.changeDir(-1);
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle1.changeDir(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'p') {
			pause = !pause;
		}else if(e.getKeyChar() == 'o' && pause) {
			tick();
			repaint();
		}
		
	}

}