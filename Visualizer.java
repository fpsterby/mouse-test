import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Visualizer extends JPanel implements Runnable, MWEventListener {
    Controls c = new Controls();
    MWEvent currentE;
    double circleX, circleY, currentFrame, lastFrame;
    Thread t;
    final int width, height;
    int x = 0,y = 0;

    public Visualizer(){
        this(800, 600);
    }

    public Visualizer(int width, int height){
        this.width = width;
        this.height = height;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.addKeyListener(c);
        this.addMouseListener(c);
        this.addMouseWheelListener(c);

        this.setFocusable(true);

    }
    
    public void startThread(){
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (this.t != null){
            checkControls();        
            update();
            repaint();
            eep(1);
        }
    }

    public void checkControls(){
        if (currentE != null){
            if (currentE == MWEvent.mUp)
                System.out.println("up");
            else if (currentE == MWEvent.mDown)
                System.out.println("down");
            
            currentE = null;
        }
    }

    public void update(){
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);

        for (int i = 0; i < 100; i++ ){
            
        }
    }
    public void eep(double ms){
        try {
            Thread.sleep((long) ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleEvent(MWEvent e) {
        this.currentE = e;
    }

}

interface MWEventListener {
    public void handleEvent(MWEvent e);
}