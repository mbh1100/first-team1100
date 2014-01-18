
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * A crosshair app for the Driver's station. This app is used instead of a axis
 * camera logo setting so that the robot doesn't not recieve an image that
 * interferes with tracking Also not subject to camera compression.
 *
 * @author akshay
 */
public class Crosshair extends JFrame implements MouseListener, MouseMotionListener {

    //size of the driver station camera feed
    final int w = 534;
    final int h = 399;
    int dX = 0;
    int dY = 0;
    boolean down = false;

    public Crosshair() {
        setTitle("Crosshair");
        setAlwaysOnTop(true);
        setSize(w, h);
        setUndecorated(true);//remove window borders
        setBackground(new Color(0, 0, 0, 1));//make transparent, alpha = 1 so it can be dragged easily
        addMouseListener(this);
        addMouseMotionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void paint(Graphics g) {
        //g.clearRect(0, 0, w, h);
        //draw crosshair
        g.setColor(Color.RED);
        g.drawLine(0, h / 2, w, h / 2);
        g.drawLine(w / 2, 0, w / 2, h);
        //draw box
        g.setColor(new Color(255, 0, 0, 50));

    }

    @Override
    public void mousePressed(MouseEvent e) {
        down = true;
        dX = e.getX();
        dY = e.getY();

        setBackground(new Color(0, 0, 0, 50));
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        down = false;
        setBackground(new Color(0, 0, 0, 1));
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //move to new location
        setLocation(e.getXOnScreen() - dX, e.getYOnScreen() - dY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public static void main(String[] args) {
        new Crosshair();
    }
}