import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame implements ActionListener{
    JPanel panel;
    JLabel jimmy, gameTimer;
    JButton playAgain;
    static int jimmyY = 0, time = 60;
    static boolean goingUp = false, goingDown = false, shooting = false, gameOver = false;
    MushroomManClass mmc, mmc2, mmc3;
    public Frame(){
        super("Attack of the Mushrooms");
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        add(panel);

        Handler handler = new Handler();

        playAgain = new JButton("Play Again");
        playAgain.setBounds(450, 10, 100, 25);
        playAgain.addActionListener(handler);

        gameTimer = new JLabel(Integer.toString(time));
        gameTimer.setBounds(500, 10, 50, 50);
        gameTimer.setFont(new Font(gameTimer.getFont().getName(), Font.PLAIN, 40));
        panel.add(gameTimer);
        GameTimerClass gtc = new GameTimerClass();
        gtc.start();

        ImageIcon jimmyImage = new ImageIcon(getClass().getResource("Jimmy.png"));
        jimmy = new JLabel(jimmyImage);
        jimmy.setBounds(0, jimmyY, 60, 160);
        panel.add(jimmy);

        mmc = new MushroomManClass(850, 0);
        mmc2 = new MushroomManClass(700, 100);
        mmc3 = new MushroomManClass(550, 200);

        addKeyListener(handler);

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event){
        if(goingUp && shooting && !(jimmyY<0)){
            SoapClass sc = new SoapClass(jimmy.getX(), jimmy.getY());
            shooting = false;
            jimmyY-=7;
            jimmy.setBounds(0, jimmyY, 60, 160);
            panel.revalidate();
            panel.repaint();
        }
        else if(goingDown && shooting && !(jimmyY>500)){
            SoapClass sc = new SoapClass(jimmy.getX(), jimmy.getY());
            shooting = false;
            jimmyY+=7;
            jimmy.setBounds(0, jimmyY, 60, 160);
            panel.revalidate();
            panel.repaint();
        }
        else if(goingUp && !(jimmyY<0)){
            jimmyY-=7;
            jimmy.setBounds(0, jimmyY, 60, 160);
            panel.revalidate();
            panel.repaint();
        }
        else if(goingDown && !(jimmyY>500)){
            jimmyY+=7;
            jimmy.setBounds(0, jimmyY, 60, 160);
            panel.revalidate();
            panel.repaint();
        }
        else if(shooting){
            SoapClass sc = new SoapClass(jimmy.getX(), jimmy.getY());
            shooting = false;
        }

        if(mmc.mushroomManIsDead && mmc2.mushroomManIsDead && mmc3.mushroomManIsDead){
            winGame();
        }
    }

    public void endGame(){
        gameOver = true;
        panel.removeAll();
        ImageIcon gameOverImage = new ImageIcon(getClass().getResource("GameOver.png"));
        JLabel gameOver = new JLabel(gameOverImage);
        gameOver.setBounds(200, 200, 600, 100);
        panel.add(gameOver);

        panel.add(playAgain);

        repaint();
        revalidate();
    }

    public void winGame(){
        gameOver = true;
        panel.removeAll();
        ImageIcon youWinImage = new ImageIcon(getClass().getResource("YouWin.png"));
        JLabel youWin = new JLabel(youWinImage);
        youWin.setBounds(250, 100, 500, 500);
        panel.add(youWin);

        panel.add(playAgain);

        repaint();
        revalidate();
    }

    class Handler implements KeyListener, ActionListener{
        public void keyReleased(KeyEvent event){
            int keyCode = event.getKeyCode();
            if(keyCode == KeyEvent.VK_SPACE){
                shooting = true;
            }

            if(keyCode == KeyEvent.VK_UP){
                goingUp = false;
            }
            else if(keyCode == KeyEvent.VK_DOWN){
                goingDown = false;
            }
        }

        public void keyPressed(KeyEvent event){
            int keyCode = event.getKeyCode();
            if(keyCode == KeyEvent.VK_UP && !(jimmyY<=0)){
                goingUp = true;
            }
            else if(keyCode == KeyEvent.VK_DOWN && !(jimmyY>=500)){
                goingDown = true;
            }
        }

        public void keyTyped(KeyEvent event){
        }

        public void actionPerformed(ActionEvent event){
            if(event.getSource() == playAgain){
                try{
                    final String javaBin = System.getProperty("java.home") + java.io.File.separator + "bin" + java.io.File.separator + "java";
                    final java.io.File currentJar = new java.io.File(Run.class.getProtectionDomain().getCodeSource().getLocation().toURI());

                    if(!currentJar.getName().endsWith(".jar")){
                        return;
                    }

                    final java.util.ArrayList<String> command = new java.util.ArrayList<String>();
                    command.add(javaBin);
                    command.add("-jar");
                    command.add(currentJar.getPath());

                    final ProcessBuilder builder = new ProcessBuilder(command);
                    builder.start();
                    System.exit(0);
                }
                catch(Exception e){
                }
            }
        }
    }

    class GameTimerClass extends Thread implements ActionListener{
        Timer timer;
        public void run(){
            timer = new Timer(1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!gameOver){
                panel.remove(gameTimer);
                time--;
                gameTimer = new JLabel(Integer.toString(time));
                gameTimer.setBounds(500, 10, 50, 50);
                gameTimer.setFont(new Font(gameTimer.getFont().getName(), Font.PLAIN, 40));
                panel.add(gameTimer);
                panel.revalidate();
                panel.repaint();
            }

            if(time == 0){
                endGame();
            }
        }
    }

    class MushroomManClass implements ActionListener{
        Timer timer;
        JLabel mushroomMan;
        int random = (int)(Math.random()*300), counter = 0, mushroomManY = 0, mushroomManVel = 6, mushroomManX = 1000, hits = 0;
        boolean mushroomManIsDead = false;
        public MushroomManClass(int x, int y){
            mushroomManX = x;
            mushroomManY = y;
            ImageIcon mushroomManImage = new ImageIcon(getClass().getResource("MushroomMan.png"));
            mushroomMan = new JLabel(mushroomManImage);
            mushroomMan.setBounds(mushroomManX, mushroomManY, 150, 150);
            panel.add(mushroomMan);
            timer = new Timer(5, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(mushroomManY < 0 && !mushroomManIsDead){
                mushroomManVel = 6;
                MushroomClass mc = new MushroomClass(mushroomMan.getX(), mushroomMan.getY());
            }

            if(mushroomManY > 545 && !mushroomManIsDead){
                mushroomManVel = -6;
                MushroomClass mc = new MushroomClass(mushroomMan.getX(), mushroomMan.getY());
            }

            if(counter == random && !mushroomManIsDead){
                mushroomManVel = -mushroomManVel;
                random = (int)(Math.random()*300);
                counter = 0;
                MushroomClass mc = new MushroomClass(mushroomMan.getX(), mushroomMan.getY());
            }
            counter++;
            mushroomManY = mushroomManY + mushroomManVel;
            mushroomMan.setBounds(mushroomManX, mushroomManY, 150, 150);
            panel.revalidate();
            panel.repaint();

            if(hits == 30){
                panel.remove(mushroomMan);
                mushroomManIsDead = true;
            }
        }
    }

    class MushroomClass implements ActionListener{
        Timer timer;
        JLabel mushroom;
        int mushroomX, mushroomY;
        public MushroomClass(int x, int y){
            mushroomX = x;
            mushroomY = y;
            ImageIcon mushroomImage = new ImageIcon(getClass().getResource("Mushroom.png"));
            mushroom = new JLabel(mushroomImage);
            mushroom.setBounds(mushroomX, mushroomY, 60, 50);
            if(!gameOver){
                panel.add(mushroom);
            }
            timer = new Timer(5, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(mushroomX < 0){
                panel.remove(mushroom);
            }
            mushroomX-=5;
            mushroom.setBounds(mushroomX, mushroomY, 60, 50);
            panel.revalidate();
            panel.repaint();
            if(mushroomX>=jimmy.getX() && mushroomX<=(jimmy.getX()+jimmy.getWidth()) 
                && (mushroomY+mushroom.getHeight())>=jimmy.getY() && mushroomY<=(jimmy.getY()+jimmy.getHeight())){
                if(!gameOver){
                    endGame();
                }
            }
        }
    }

    class SoapClass implements ActionListener{
        Timer timer;
        JLabel soap;
        int soapX, soapY;
        boolean canCollideWithMushroomMan = true;
        public SoapClass(int x, int y){
            soapX = x;
            soapY = y;
            ImageIcon soapImage = new ImageIcon(getClass().getResource("Soap.png"));
            soap = new JLabel(soapImage);
            soap.setBounds(soapX, soapY, 30, 20);
            if(!gameOver){
                panel.add(soap);
            }
            panel.revalidate();
            panel.repaint();
            timer = new Timer(5 , this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(soapX > 970){
                panel.remove(soap);
            }
            soapX+=7;
            soap.setBounds(soapX, soapY, 30, 20);
            panel.revalidate();
            panel.repaint();
            if
            (soapX>=mmc.mushroomManX && soapX<=(mmc.mushroomManX+mmc.mushroomMan.getWidth()) 
                && (soapY+soap.getHeight())>=mmc.mushroomManY && soapY<=(mmc.mushroomManY+mmc.mushroomMan.getHeight()))
            {
                if(canCollideWithMushroomMan){
                    mmc.hits++;
                    panel.remove(soap);
                    canCollideWithMushroomMan = false;
                }
            }
            else if
            (soapX>=mmc2.mushroomManX && soapX<=(mmc2.mushroomManX+mmc2.mushroomMan.getWidth()) 
                && (soapY+soap.getHeight())>=mmc2.mushroomManY && soapY<=(mmc2.mushroomManY+mmc2.mushroomMan.getHeight()))
            {
                if(canCollideWithMushroomMan){
                    mmc2.hits++;
                    panel.remove(soap);
                    canCollideWithMushroomMan = false;
                }
            }
            else if
            (soapX>=mmc3.mushroomManX && soapX<=(mmc3.mushroomManX+mmc3.mushroomMan.getWidth()) 
                && (soapY+soap.getHeight())>=mmc3.mushroomManY && soapY<=(mmc3.mushroomManY+mmc3.mushroomMan.getHeight()))
            {
                if(canCollideWithMushroomMan){
                    mmc3.hits++;
                    panel.remove(soap);
                    canCollideWithMushroomMan = false;
                }
            }
        }
    }
}
