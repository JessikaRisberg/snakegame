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

    public GamePanel(){
    random = new Random();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        // this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        // creates a new apple at start
        // newApple();

        running = true;

        // set timer to 75 and start
        timer = new Timer(delay,this);
        timer.start();
    }

    public void gameOver(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
