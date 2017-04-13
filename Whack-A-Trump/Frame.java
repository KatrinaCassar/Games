import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame{
    JPanel panel = new JPanel();
    JLabel gameHits, gameTimer, hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8, hole9;
    Handler handler = new Handler();
    static int hits = 0, time = 60;
    static boolean trumpIsVisibleH1, trumpIsVisibleH2, trumpIsVisibleH3, trumpIsVisibleH4, trumpIsVisibleH5, trumpIsVisibleH6;
    static boolean trumpIsVisibleH7, trumpIsVisibleH8, trumpIsVisibleH9;
    final static ImageIcon image = new ImageIcon("Hole.png"), image2 = new ImageIcon("HoleWithTrump.png");
    public Frame(){
        super("Whack-A-Trump");
        panel.setLayout(null);
        add(panel);

        gameHits = new JLabel(Integer.toString(hits) + " hits");
        gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
        gameHits.setBounds(10, 10, 200, 100);
        panel.add(gameHits);

        gameTimer = new JLabel(Integer.toString(time));
        gameTimer.setFont(new Font(gameTimer.getFont().getName(), Font.PLAIN, 50));
        gameTimer.setBounds(250, 25, 60, 60);
        panel.add(gameTimer);

        hole1 = new JLabel(image);
        hole1.setBounds(0, 105, 105, 105);
        hole1.addMouseListener(handler);
        panel.add(hole1);

        hole2 = new JLabel(image);
        hole2.setBounds(105, 105, 105, 105);
        hole2.addMouseListener(handler);
        panel.add(hole2);

        hole3 = new JLabel(image);
        hole3.setBounds(210, 105, 105, 105);
        hole3.addMouseListener(handler);
        panel.add(hole3);

        hole4 = new JLabel(image);
        hole4.setBounds(0, 210, 105, 105);
        hole4.addMouseListener(handler);
        panel.add(hole4);

        hole5 = new JLabel(image);
        hole5.setBounds(105, 210, 105, 105);
        hole5.addMouseListener(handler);
        panel.add(hole5);

        hole6 = new JLabel(image);
        hole6.setBounds(210, 210, 105, 105);
        hole6.addMouseListener(handler);
        panel.add(hole6);

        hole7 = new JLabel(image);
        hole7.setBounds(0, 315, 105, 105);
        hole7.addMouseListener(handler);
        panel.add(hole7);

        hole8 = new JLabel(image);
        hole8.setBounds(105, 315, 105, 105);
        hole8.addMouseListener(handler);
        panel.add(hole8);

        hole9 = new JLabel(image);
        hole9.setBounds(210, 315, 105, 105);
        hole9.addMouseListener(handler);
        panel.add(hole9);

        GameTimer gameTimer = new GameTimer();
        HoleOne h1 = new HoleOne();
        HoleTwo h2 = new HoleTwo();
        HoleThree h3 = new HoleThree();
        HoleFour h4 = new HoleFour();
        HoleFive h5 = new HoleFive();
        HoleSix h6 = new HoleSix();
        HoleSeven h7 = new HoleSeven();
        HoleEight h8 = new HoleEight();
        HoleNine h9 = new HoleNine();
        gameTimer.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        h8.start();
        h9.start();
    }

    class GameTimer extends Thread implements ActionListener{
        Timer timer = new Timer(1000, this);
        public void run(){
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            panel.remove(gameTimer);
            time--;
            gameTimer = new JLabel(Integer.toString(time));
            gameTimer.setFont(new Font(gameTimer.getFont().getName(), Font.PLAIN, 50));
            gameTimer.setBounds(250, 25, 60, 60);
            panel.add(gameTimer);
            panel.revalidate();
            panel.repaint();
            if(time == 0){
                timer.stop();
                JOptionPane.showMessageDialog(null, "You got " +hits+ " hits");
            }
        }
    }

    class HoleOne extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH1 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH1 && time != 0){
                panel.remove(hole1);
                hole1 = new JLabel(image2);
                hole1.setBounds(0, 105, 105, 105);
                hole1.addMouseListener(handler);
                panel.add(hole1);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH1 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH1){
                panel.remove(hole1);
                hole1 = new JLabel(image);
                hole1.setBounds(0, 105, 105, 105);
                hole1.addMouseListener(handler);
                panel.add(hole1);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH1 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleTwo extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH2 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH2 && time != 0){
                panel.remove(hole2);
                hole2 = new JLabel(image2);
                hole2.setBounds(105, 105, 105, 105);
                hole2.addMouseListener(handler);
                panel.add(hole2);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH2 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH2){
                panel.remove(hole2);
                hole2 = new JLabel(image);
                hole2.setBounds(105, 105, 105, 105);
                hole2.addMouseListener(handler);
                panel.add(hole2);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH2 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleThree extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH3 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH3 && time != 0){
                panel.remove(hole3);
                hole3 = new JLabel(image2);
                hole3.setBounds(210, 105, 105, 105);
                hole3.addMouseListener(handler);
                panel.add(hole3);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH3 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH3){
                panel.remove(hole3);
                hole3 = new JLabel(image);
                hole3.setBounds(210, 105, 105, 105);
                hole3.addMouseListener(handler);
                panel.add(hole3);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH3 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleFour extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH4 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH4 && time != 0){
                panel.remove(hole4);
                hole4 = new JLabel(image2);
                hole4.setBounds(0, 210, 105, 105);
                hole4.addMouseListener(handler);
                panel.add(hole4);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH4 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH4){
                panel.remove(hole4);
                hole4 = new JLabel(image);
                hole4.setBounds(0, 210, 105, 105);
                hole4.addMouseListener(handler);
                panel.add(hole4);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH4 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleFive extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH5 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH5 && time != 0){
                panel.remove(hole5);
                hole5 = new JLabel(image2);
                hole5.setBounds(105, 210, 105, 105);
                hole5.addMouseListener(handler);
                panel.add(hole5);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH5 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH5){
                panel.remove(hole5);
                hole5 = new JLabel(image);
                hole5.setBounds(105, 210, 105, 105);
                hole5.addMouseListener(handler);
                panel.add(hole5);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH5 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleSix extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH6 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH6 && time != 0){
                panel.remove(hole6);
                hole6 = new JLabel(image2);
                hole6.setBounds(210, 210, 105, 105);
                hole6.addMouseListener(handler);
                panel.add(hole6);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH6 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH6){
                panel.remove(hole6);
                hole6 = new JLabel(image);
                hole6.setBounds(210, 210, 105, 105);
                hole6.addMouseListener(handler);
                panel.add(hole6);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH6 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleSeven extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH7 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH7 && time != 0){
                panel.remove(hole7);
                hole7 = new JLabel(image2);
                hole7.setBounds(0, 315, 105, 105);
                hole7.addMouseListener(handler);
                panel.add(hole7);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH7 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH7){
                panel.remove(hole7);
                hole7 = new JLabel(image);
                hole7.setBounds(0, 315, 105, 105);
                hole7.addMouseListener(handler);
                panel.add(hole7);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH7 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleEight extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH8 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH8 && time != 0){
                panel.remove(hole8);
                hole8 = new JLabel(image2);
                hole8.setBounds(105, 315, 105, 105);
                hole8.addMouseListener(handler);
                panel.add(hole8);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH8 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH8){
                panel.remove(hole8);
                hole8 = new JLabel(image);
                hole8.setBounds(105, 315, 105, 105);
                hole8.addMouseListener(handler);
                panel.add(hole8);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH8 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class HoleNine extends Thread implements ActionListener{
        Timer timer; 
        Timer timer2 = new Timer(500, this);
        public void run(){
            trumpIsVisibleH9 = false;
            timer = new Timer((int)(Math.random() * 10000) + 1000, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent event){
            if(!trumpIsVisibleH9 && time != 0){
                panel.remove(hole9);
                hole9 = new JLabel(image2);
                hole9.setBounds(210, 315, 105, 105);
                hole9.addMouseListener(handler);
                panel.add(hole9);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH9 = true;
                timer.stop();
                timer2.start();
            }
            else if(trumpIsVisibleH9){
                panel.remove(hole9);
                hole9 = new JLabel(image);
                hole9.setBounds(210, 315, 105, 105);
                hole9.addMouseListener(handler);
                panel.add(hole9);
                panel.revalidate();
                panel.repaint();
                trumpIsVisibleH9 = false;
                timer2.stop();
                timer = new Timer((int)(Math.random() * 10000) + 1000, this);
                timer.start();
            }
        }
    }

    class Handler implements MouseListener{
        public void mouseExited(MouseEvent event){
        }

        public void mouseEntered(MouseEvent event){
        }

        public void mouseReleased(MouseEvent event){
        }

        public void mousePressed(MouseEvent event){
            if(event.getSource() == hole1){
                if(trumpIsVisibleH1){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole2){
                if(trumpIsVisibleH2){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole3){
                if(trumpIsVisibleH3){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole4){
                if(trumpIsVisibleH4){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole5){
                if(trumpIsVisibleH5){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole6){
                if(trumpIsVisibleH6){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole7){
                if(trumpIsVisibleH7){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole8){
                if(trumpIsVisibleH8){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else if(event.getSource() == hole9){
                if(trumpIsVisibleH9){
                    panel.remove(gameHits);
                    hits++;
                    gameHits = new JLabel(Integer.toString(hits) + " hits");
                    gameHits.setFont(new Font(gameHits.getFont().getName(), Font.PLAIN, 40));
                    gameHits.setBounds(10, 10, 200, 100);
                    panel.add(gameHits);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        }

        public void mouseClicked(MouseEvent event){
        }
    }
}

