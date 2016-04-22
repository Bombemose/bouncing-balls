import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList <BouncingBall>balls;
    private RandomGenerator randomGenerator;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        randomGenerator = new RandomGenerator();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        balls = new ArrayList<BouncingBall>();
       
        addBalls(numberOfBalls, ground);
        showAllBalls();
        myCanvas.wait(5000);

        // make them bounce
        boolean oneBallHasMoved = true;;
        
        while(oneBallHasMoved) {
            myCanvas.wait(50);           // small delay
            Iterator<BouncingBall> ballIterator = balls.iterator();
            oneBallHasMoved = false;
            
            while(ballIterator.hasNext()) {
                BouncingBall actualBall = ballIterator.next();
                
               if(actualBall.getXPosition() < 600) {
                   actualBall.move();
                   oneBallHasMoved = true;
               }
                
            }
        }
    }
    
    private void addBalls(int numberOfBalls, int ground) {
        
        int index;
        int xPosition;
        int yPosition;
        int diameter;
        Color color;
        
        index = 1;
        
        while(index <= numberOfBalls) {
            yPosition = randomGenerator.getRandomNumber(250);
            xPosition = randomGenerator.getRandomNumber(150);
            diameter = randomGenerator.getRandomNumber(15)+15;
            color = randomGenerator.getRandomColor();
            
            BouncingBall ball = new BouncingBall(xPosition, yPosition, diameter, color, ground, myCanvas);
            balls.add(ball);
            
            index ++;
        }
        
    }
    
    private void showAllBalls() {
        // Show all balls
        
        Iterator<BouncingBall> ballIterator = balls.iterator();
            
        while(ballIterator.hasNext()) {
            BouncingBall actualBall = ballIterator.next();
            actualBall.draw();
        }
    }
}
