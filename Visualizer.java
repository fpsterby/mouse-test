import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Visualizer extends JPanel implements Runnable, MWEventListener {
    Controls c = new Controls();
    double circleX, circleY, scale;
    Thread t;
    final int width, height, gap = 5, circleSize = 5;
    int x = 0,y = 0;
    List<MouseWheelEvent> events = new ArrayList<>();

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

        c.addListener(this);

        this.setFocusable(true);

    }
    
    public void startThread(){
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (this.t != null){
            // checkControls();        
            update();
            repaint();
            // i fear this sleep may cause interference with the eventListening
            eep(1);
        }
    }

    // public void checkControls(){
    //     if (eventCount < events.size()){
    //         int rots = events.get(0).getWheelRotation();
    //         if (rots > 0){

    //         } else if (rots < 0) {

    //         }
    //         eventCount = events.size();
    //     }
    // }

    public void update(){
        
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);

        int count = 0, i = 0;
        for (MouseWheelEvent e : events) {
            count -= e.getWheelRotation();
            g2.fillOval(gap + i * gap, height / 2 - (count * gap), 5, 5);
            i++;
        }
    }
    public void eep(double ms){ // honkk shmimimimimi
        try {
            Thread.sleep((long) ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleEvent(MouseWheelEvent e) {
        System.out.println(e.getWheelRotation());
        events.add(e);
    }

}

interface MWEventListener {
    public void handleEvent(MouseWheelEvent e);
}