import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

public class Controls implements KeyListener, MouseListener, MouseWheelListener{
    List<MWEventListener> listeners = new ArrayList<MWEventListener>();
    // mwheel
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println(e.getPreciseWheelRotation());
        // switch (e.)
    }
    
    // keyboard
    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    // mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    public void sendEvent(MWEvent e){
        for (MWEventListener listener : listeners) {
            listener.handleEvent(e);
        }
    }
}
