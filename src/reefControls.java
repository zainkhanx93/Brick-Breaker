import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class reefControls implements KeyListener {
    private Kutch k1;
    private final int left;
    private final int right;
    public SuperRainbow s;

    public reefControls(Kutch k1, int left, int right, SuperRainbow s)
    {
        this.k1 = k1;
        this.left = left;
        this.right = right;
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
