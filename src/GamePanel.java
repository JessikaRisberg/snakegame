import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    // Panel set up
    static final int screenWidth = 600;
    static final int screenHeight = 600;
    static final int unit_size = 25;
    static final int game_units = (screenHeight*screenWidth)/unit_size;
    static final int delay = 75;

    boolean running = false;
    Timer timer;
    Random random;

    // Holds the coordinates for the snakes body parts
    final int x[] = new int[game_units];
    final int y[] = new int[game_units];
    int bodyParts = 10;
    int applesEaten;

    // Direction for apples
    int appleX;
    int appleY;

    // Start direction for snake
    char direction = 'R';

    public GamePanel(){
    random = new Random();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();

    }

    public void startGame(){
        // creates a new apple at start
        newApple();

        running = true;

        // set timer to 75 and start
        timer = new Timer(delay,this);
        timer.start();
    }
    public void newApple() {
        // places apple random
        appleX = random.nextInt((int)(screenWidth/unit_size))*unit_size;
        appleY = random.nextInt((int)(screenHeight/unit_size))*unit_size;
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        gameplan(g);
    }

    public void gameplan(Graphics graphics){
        // draw the gamepanel
        for (int i = 0; i < screenHeight/unit_size; i++){
            graphics.drawLine(i*unit_size, 0, i*unit_size, screenHeight); // x-axel
            graphics.drawLine(0, i*unit_size, screenWidth, i*unit_size); // Y-axel
        }

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

        // stopp timer
        if (!running) {
            timer.stop();
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
                checkCollision();
            }
            repaint();
    }
}
