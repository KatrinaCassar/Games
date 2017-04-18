import javax.swing.JFrame;
public class Run{
    public static void main(String[] args){
        runGame();
    }
    
    public static void runGame(){
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
