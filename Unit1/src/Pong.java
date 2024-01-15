import java.util.Scanner;

@SuppressWarnings ("resource")
public class Pong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int ballPositionX = 0;
        int ballPositionY = 0;
        int ballVelocityX = 1;
        int ballVelocityY = 1;
        
        int paddlePosition = 3;
        
        while (true) {
            // Clear the console
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
            
            // Update ball position
            ballPositionX += ballVelocityX;
            ballPositionY += ballVelocityY;
            
            // Check collision with top and bottom walls
            if (ballPositionY <= 0 || ballPositionY >= 19) {
                ballVelocityY = -ballVelocityY;
            }
            
            // Check collision with paddle
            if (ballPositionX == 0 && ballPositionY == paddlePosition) {
                ballVelocityX = -ballVelocityX;
            }
            
            // Draw the game
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 50; j++) {
                    if ((i == ballPositionY && j == ballPositionX) || (i == paddlePosition && j == 0)) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            
            // Move the paddle
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("w") && paddlePosition > 0) {
                    paddlePosition--;
                } else if (input.equals("s") && paddlePosition < 19) {
                    paddlePosition++;
                }
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
