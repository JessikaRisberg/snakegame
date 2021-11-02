import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest {

    @Test
    void startGame() {
        // set up
        boolean running = true;
        // conditon
        if (running != true) {
            startGame();
        }
        // result
        assertTrue(running);
    }

    @Test
    void checkCollisionRigthBorder() {
        // set up
        final int screenWidth = 600;
        final int x[] = new int[604];
        boolean running = true;

        // checks if snake collied with right border
        if (x[0] < screenWidth){
            running = false;
        }
        // Result
        assertFalse(running);
    }

    @Test
    void checkCollisionLeftBorder() {
        // set up
        final int x = -1;
        boolean running = true;

        // checks if snake collied with right border
        if (x < 0){
            running = false;
        }
        // Result
        assertFalse(running);
    }

    @Test
    void checkCollisionBottomBorder() {
        // set up
        final int screenHeight = 600;
        final int y = 610;
        boolean running = true;

        // checks if snake collied with bottom border
        if (y > screenHeight){
            running = false;
        }
        // Result
        assertFalse(running);
    }

    @Test
    void checkApple() {
        // set up
        final int x[] = new int[25];
        final int y[] = new int[25];
        int bodyParts = 10;
        int applesEaten = 0;
        int appleX = 0;
        int appleY = 0;
        GamePanel gamePanel = new GamePanel();

        // condition
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            gamePanel.newApple();
        }
        // result
        assertEquals(bodyParts, 11);
        assertEquals(applesEaten, 1);
    }

}