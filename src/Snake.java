import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Snake extends KeyAdapter {

    // Holds the coordinates for the snakes body parts
    int bodyParts = 10;
    int applesEaten;
    char direction;


    @Override
    public void keyPressed(KeyEvent event){
        // steer the snake
        switch (event.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if (direction != 'R'){
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L'){
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D'){
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U'){
                    direction = 'D';
                }
                break;
        }
    }
}
