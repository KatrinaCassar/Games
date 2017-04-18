import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Frame extends JFrame implements ActionListener{
    static JPanel panel = new JPanel();
    static Paddle paddleClass;
    static Ball ballClass;
    static JLabel paddle, ball, pointsDisplay; 
    static JButton playAgainButton;
    static int paddleX, points = 0;
    static boolean paddleGoingLeft = true, paddleGoingRight = false; //paddleGoingLeft set to true to avoid afk-ing
    static Timer timer;
    Handler handler = new Handler();
    public Frame(){
        super("Don't Touch the Floor!");
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);
        
        paddleClass = new Paddle();
        ballClass = new Ball();
        paddle = paddleClass.paddle;
        ball = ballClass.ball;
        paddleX = paddleClass.x;
        
        pointsDisplay = new JLabel(Integer.toString(points));
        pointsDisplay.setFont(new Font(pointsDisplay.getFont().getName(), Font.PLAIN, 40));
        pointsDisplay.setForeground(Color.WHITE);
        pointsDisplay.setBounds(0, 0, 50, 35);
        panel.add(pointsDisplay);

        panel.add(paddle);
        panel.add(ball);
        
        addKeyListener(handler);

        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        //if ball collides with paddle, ball goes up, add 1 point
        if( ball.getX() >= (paddle.getX() - ball.getWidth())
        &&  ball.getX() <= (paddle.getX() + paddle.getWidth())
        &&  (ball.getY() + ball.getHeight()) >= paddle.getY()
        &&  ball.getY() <= (paddle.getY() + paddle.getHeight()) ){
            ballClass.velY = -7;
            points++;
            panel.remove(pointsDisplay);
            pointsDisplay = new JLabel(Integer.toString(points));
            pointsDisplay.setFont(new Font(pointsDisplay.getFont().getName(), Font.PLAIN, 40));
            pointsDisplay.setForeground(Color.WHITE);
            pointsDisplay.setBounds(0, 0, 50, 35);
            panel.add(pointsDisplay);
            panel.repaint();
            panel.revalidate();
            //if paddle is going left, ball goes left. if paddle is going right, ball goes right
            if(paddleGoingLeft){
                ballClass.velX-=3;
            }
            else if(paddleGoingRight){
                ballClass.velX+=3;
            }
        }
        
        //if ball hits bottom border, end game
        if(ball.getY() > 700){
            endGame();
        }
    }

    public void endGame(){
        timer.stop();
        ballClass.timer.stop();

        panel.removeAll();

        JLabel gameOverMessage = new JLabel("<html>Game over<br>You got " + points + " points<html>");
        gameOverMessage.setFont(new Font(gameOverMessage.getFont().getName(), Font.PLAIN, 40));
        gameOverMessage.setBounds(400, 100, 500, 300);
        gameOverMessage.setForeground(Color.WHITE);
        panel.add(gameOverMessage);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(450, 350, 100, 25);
        playAgainButton.addActionListener(handler);
        panel.add(playAgainButton);
        
        ball.setBounds(ballClass.x, ballClass.y, 105, 105);
        paddleGoingLeft = true;
        paddleGoingRight = false;
        ballClass.x = 470;
        ballClass.y = 300;
        ballClass.velX = 0;
        ballClass.velY = -5;
        paddleClass.x = 450;
        points = 0;

        panel.repaint();
        panel.revalidate();
    }

    class Handler implements KeyListener, ActionListener{
        @Override
        public void keyReleased(KeyEvent event){
        }

        @Override
        public void keyPressed(KeyEvent event){
            int keyCode = event.getKeyCode();
            //left key and right key to move panel 
            if(keyCode == KeyEvent.VK_LEFT && !(paddle.getX()<0)){
                paddleGoingLeft = true;
                paddleGoingRight = false;
                paddleX-=7;
                paddle.setBounds(paddleX, 600, 130, 30);
                panel.repaint();
                panel.revalidate();
            }
            else if(keyCode == KeyEvent.VK_RIGHT && !(paddle.getX()>870)){
                paddleGoingRight = true;
                paddleGoingLeft = false;
                paddleX+=7;
                paddle.setBounds(paddleX, 600, 130, 30);
                panel.repaint();
                panel.revalidate();
            }
        }

        @Override
        public void keyTyped(KeyEvent event){
        }
        
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == playAgainButton){
                panel.removeAll();
                panel.repaint();
                panel.revalidate();
                remove(panel);
                dispose();
                
                Run run = new Run();
                run.runGame();
            }
        }
    }
}