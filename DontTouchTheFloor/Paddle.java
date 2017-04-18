import javax.swing.*;
public class Paddle{
    static JLabel paddle;
    static int x = 450;
    public Paddle(){
        ImageIcon paddleImage = new ImageIcon(getClass().getResource("Paddle.png"));
        paddle = new JLabel(paddleImage);
        paddle.setBounds(x, 600, 130, 30);
    }
}

