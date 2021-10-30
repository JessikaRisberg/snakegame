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
        final int x[] = new int[];
        boolean running = true;
        //
        // checks if snake collied with right border
        if (x[0] > screenWidth){
            running = false;
        }

        assertFalse(running);

    }

    @Test
    void checkApple() {
    }

    @Test
    void gameOver() {
    }
}