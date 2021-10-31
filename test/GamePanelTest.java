import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest {

    @Test
    void startGame() {

        boolean running = true;

        if (running != true) {
            startGame();
        }

        assertTrue(running);
    }

    @Test
    void newApple() {

    }

    @Test
    void gameplan() {
    }

    @Test
    void checkCollision() {
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
    void checkApple() {
        // set up
        final int x[] = new int[25];
        final int y[] = new int[25];
        int bodyParts = 10;
        int applesEaten = 0;
        int appleX = 0;
        int appleY = 0;

        // condition
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
        // result
        assertEquals(bodyParts, 11);
        assertEquals(applesEaten, 1);
    }

    @Test
    void gameOver() {
    }
}