import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Visualizer v = new Visualizer(1280, 960);

        frame.add(v);
        frame.pack();
        frame.setVisible(true);

        v.startThread();
    }
}