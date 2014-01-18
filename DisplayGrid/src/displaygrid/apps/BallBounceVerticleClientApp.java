/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ClientApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Akshay
 */
public class BallBounceVerticleClientApp extends ClientApp {
    
    static final String APPNAME = BallBounceVerticleServerApp.APPNAME;
    static final long TARGET_DELTA = 50*5; 
    
    public static final float MAX_X = BallBounceServerApp.MAX_X;
    public static final float MAX_Y = BallBounceServerApp.MAX_Y;
    public static final float MIN_X = BallBounceServerApp.MIN_X;
    public static final float MIN_Y = BallBounceServerApp.MIN_Y;
    
    private JFrame frame;
    private JPanel panel;
    
    private Random rand;
    
    private int index = 0;
    private int numClients = 1;
    
    private float x,y,dx, dy;
    private int screenX, screenY;
    private int radius;
    
    private int leftPaddleX = 0;
    private int leftPaddleSpeed = 0;
    private int rightPaddleX = 0;
    private int rightPaddleSpeed;
    private int paddleWidth,paddleHeight;
        
    long lastFrame = 0;

    @Override
    public void init() {
        x = 0; 
        y = 0;
        dx = 0;
        dy = 0;
        screenX = 0;
        screenY = 0;
        
        rand = new Random();
        
        frame = new JFrame();
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                paintPanel(g);
            }
        };
        frame.add(panel);
        frame.setResizable(false);
        frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        radius = d.width/30;
        paddleWidth = radius*6;
        paddleHeight = radius/2;
        frame.setSize(d);
        //frame.setSize(300,400);
        panel.setDoubleBuffered(true);
        frame.setVisible(true);
        
        leftPaddleX = (int) (Math.random()*panel.getWidth());
        rightPaddleX = (int) (Math.random()*panel.getWidth());
        
    }

    @Override
    public void update() {
        x += dx;
        y += dy/numClients;
        
        if(x > MAX_X){
            x = MAX_X;
            dx *= -1;
        } else if (x < MIN_X){
            x = MIN_X;
            dx *= -1;
        }
        
        if(y > MAX_Y){
            y = MAX_Y;
            dy *= -1;
        } else if (y < MIN_Y){
            y = MIN_Y;
            dy *= -1;
        }
        
        //left paddle
        if(index == 0 && dy < 0){
            if(screenX > (leftPaddleX+paddleWidth/2) && leftPaddleSpeed < 15){
                leftPaddleSpeed++;
            }else if(leftPaddleSpeed > -15){
                leftPaddleSpeed--;
            }
            
            
            leftPaddleX += leftPaddleSpeed;
            if(leftPaddleX < 0 ){
            	leftPaddleX = 0;
                leftPaddleSpeed = 0;
            }

            if( leftPaddleX > panel.getWidth()-paddleWidth){
                leftPaddleX =  panel.getWidth()-paddleWidth;
                leftPaddleSpeed = 0;
            }
        }
        
        //right paddle
        if(index == numClients-1 && dy > 0){
            if(screenX > (rightPaddleX+paddleWidth/2) && rightPaddleSpeed < 15){
                rightPaddleSpeed++;
            }else if(rightPaddleSpeed > -15){
                rightPaddleSpeed--;
            }
            rightPaddleX += rightPaddleSpeed;
            if(rightPaddleX < 0 ){
            	rightPaddleX = 0;
                rightPaddleSpeed = 0;
            }        
            if( rightPaddleX > panel.getWidth()-paddleWidth){
            	rightPaddleX =  panel.getWidth()-paddleWidth;
                rightPaddleSpeed = 0;
            }
        }

        
        
        frame.repaint();        
    }
    
    
    public void paintPanel(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g.setColor(Color.WHITE);
        
        float windowSize = MAX_Y/numClients;
        float minx = index*windowSize;
        float maxx = (index+1)*windowSize;
        float rx = (y-minx)/windowSize; //relative to this screen
        
        screenX = (int)(x*panel.getWidth());
        screenY = (int)(rx*panel.getHeight());
        g.fillOval(screenX-radius, screenY-radius, radius*2, radius*2);  
        
        if(index == 0){
            g.fillRect(leftPaddleX, 0, paddleWidth, paddleHeight);
        }
        
        if(index == numClients -1){
            g.fillRect(rightPaddleX, panel.getHeight()-paddleHeight, paddleWidth, paddleHeight);
        }  
    }

    @Override
    public void commandRecieved(String command) {
        String[] coords = command.split(",");
        if(coords.length < 2) {
            return;
        }
        
        index = Integer.parseInt(coords[0]);
        numClients = Integer.parseInt(coords[1]);
        x = Float.parseFloat(coords[2]);
        y = Float.parseFloat(coords[3]);
        dx = Float.parseFloat(coords[4]);
        dy = Float.parseFloat(coords[5]);
    }

    @Override
    public String getCommand() {
        return null;
    }
    
    @Override
    public long getTargetDelta(){
        return TARGET_DELTA;
    }

    @Override
    public void end() {
        frame.setVisible(false);
        
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
