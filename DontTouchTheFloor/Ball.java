import javax.swing.*;
import java.awt.event.*;
public class Ball implements ActionListener{
    static JLabel ball;
    static int x = 470, y = 300, velX = 0, velY = -7;
    static Timer timer;
    public Ball(){
        ImageIcon ballImage = new ImageIcon(getClass().getResource("Ball.png"));
        ball = new JLabel(ballImage);
        ball.setBounds(x, y, 105, 105);
        
        timer = new Timer(5, this);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        //if ball hits top border, ball moves down
        if(y<0){
            velY = 7;
        }
        
        //if ball hits left/right border, change direction
        if(x<0){
            velX = 3;
        }
        else if(x>950){
            velX = -3;
        }
        x = x + velX;
        y = y + velY;
        ball.setBounds(x, y, 60, 60);
    }
}
