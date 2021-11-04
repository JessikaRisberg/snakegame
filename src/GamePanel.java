import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    // Panel set up
    static final int screenWidth = 600;
    static final int screenHeight = 600;
    static final int unit_size = 25;
    static final int game_units = (screenHeight*screenWidth)/unit_size; // make snake and apple a size according to screen width and height
    static final int delay = 75; // set max time for play time

    boolean running = false;
    Timer timer; // timer for game time
    Random random;

    // Holds the coordinates for the snakes body parts
    final int x[] = new int[game_units];
    final int y[] = new int[game_units];
    int bodyParts = 6; // snake length at start
    int applesEaten; // points for apples
    int appleX; // x coordinate for apple
    int appleY; // y coordinate for apple
    char direction = 'R'; // Start direction for snake

    public GamePanel(){
    random = new Random();
        // set up for panel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();

    }
    public void startGame(){
        // creates a new apple at start
        newApple();

        running = true; // start running the game

        // set timer to 75 and start
        timer = new Timer(delay,this);
        timer.start();
    }
    public void newApple() {
        // places apple random
        appleX = random.nextInt(screenWidth/unit_size)*unit_size;
        appleY = random.nextInt(screenHeight/unit_size)*unit_size;
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        gameplan(g);
    }
    public void gameplan(Graphics graphics){
        // draws when game is running
        if(running) {
            // draws apple
            graphics.setColor(Color.red);
            graphics.fillOval(appleX, appleY, unit_size, unit_size);

            // draw snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(Color.CYAN);
                    graphics.fillRect(x[i], y[i], unit_size, unit_size);
                } else {
                    graphics.setColor(Color.cyan);
                    graphics.fillRect(x[i], y[i], unit_size, unit_size);
                }
                // Score text
                graphics.setColor(Color.red);
                graphics.setFont(new Font("comic sans", Font.BOLD, 35));
                FontMetrics metrics = getFontMetrics(graphics.getFont());
                graphics.drawString("Score: " + applesEaten, (screenWidth - metrics.stringWidth("Score: " + applesEaten)) / 2, graphics.getFont().getSize());
            }
        }
        else {
            gameOver(graphics);
        }
    }
    public void checkCollision() {
        // checks if snake collied with itself
        for (int i = bodyParts; i > 0; i--){
            if ((x[0] == x[i]) && (y[0] == y[i])){
                running = false;
            }
        }
        // Checks if snake collied with left border
        if (x[0] < 0){
            running = false;
        }
        // checks if snake collied with right border
        if (x[0] > screenWidth){
            running = false;
        }
        // checks if snake collied with top border
        if (y[0] < 0){
            running = false;
        }
        // checks if snake collied with bottom border
        if (y[0] > screenHeight){
            running = false;
        }
        // stopp timer when not running
        if (!running) {
            timer.stop();
        }
    }
    public void move() { // movement
        for (int i = bodyParts; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        // snake direction
        switch (direction){
            case 'U':
                y[0] = y[0] - unit_size;
                break;
            case 'D':
                y[0] = y[0] + unit_size;
                break;
            case 'L':
                x[0] = x[0] - unit_size;
                break;
            case 'R':
                x[0] = x[0] + unit_size;
                break;
        }
    }
    public void checkApple() {
        // checks if snake gets apple
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void gameOver(Graphics graphics){
        // Score text
        graphics.setColor(Color.red);
        graphics.setFont(new Font("comic sans", Font.BOLD, 35));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: " + applesEaten, (screenWidth - metrics.stringWidth("Score: " + applesEaten))/2, graphics.getFont().getSize());
        //Game Over text
        graphics.setColor(Color.red);
        graphics.setFont(new Font("comic sans", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if (running){
                move();
                checkApple();
                checkCollision();
            }
            repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{ // Key Adapter abstract class.
        @Override
        public void keyPressed(KeyEvent e){
            // steer the snake
            switch (e.getKeyCode()){
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
}


