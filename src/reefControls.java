import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class reefControls implements KeyListener {
    private Kutch k1;
    private pop p1;
    private final int left;
    private final int right;
    private final int enter;
    public SuperRainbow s;

    public reefControls(Kutch k1, pop p1, int left, int right, int enter, SuperRainbow s)
    {
        this.k1 = k1;
        this.p1 = p1;
        this.left = left;
        this.right = right;
        this.enter = enter;
        this.s = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed (KeyEvent ke)
    {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == left)
        {
            this.k1.toggleLeftPressed();
        }
        if (keyPressed == right)
        {
            this.k1.toggleRightPressed();
        }
        if (keyPressed == enter){
            this.p1.setRunning(true);
        }

    }

    @Override
    public void keyReleased (KeyEvent ke)
    {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == left)
        {
            this.k1.unToggleLeftPressed();
        }
        if (keyPressed == right)
        {
            this.k1.unToggleRightPressed();
        }
    }




}
