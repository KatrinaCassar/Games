import javax.swing.JFrame;
public class Run{
    public static void main(String[] args){
        run();
    }
    
    public static void run(){
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(322, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
