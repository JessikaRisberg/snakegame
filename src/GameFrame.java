import javax.swing.*;

public class GameFrame extends JFrame {

        public GameFrame(){
            GamePanel panel = new GamePanel();

            // set up
            this.add(panel);
            this.setTitle("Snake");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);
            // Puts the frame in the middle of the screen
            this.setLocationRelativeTo(null);
        }
}
