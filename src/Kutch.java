import java.awt.*;
import java.awt.image.BufferedImage;

public class Kutch extends gameObject{


    private int direction;
    // private int x,y;
    private int vx,vy;
    private SuperRainbow sr;
    private reefHealth h;
    private final int speed = 2;

    private BufferedImage img;
    private boolean leftPressed;
    private boolean rightPressed;

    private reefScore powers;
    private pop p;

    Kutch(int start_x, int start_y, int vx, int vy,int length, int dir, SuperRainbow s)
    {
        super(start_x,start_y,10,length);
        this.vx = vx;
        this.vy = vy;
        // this.x = x;
        //this.y = y;
        this.sr = s;
        //   this.h = rh;

        if(dir != 1)
        {
            super.set_length(length);
            super.set_width(10);

        }
        this.direction = dir;

    }

    void toggleRightPressed() {
        this.rightPressed = true;
    }

    void toggleLeftPressed() {
        this.leftPressed = true;
    }
    void toggleEnterPressed(){}

    void unToggleRightPressed() {
        this.rightPressed = false;
    }

    void unToggleLeftPressed() {
        this.leftPressed = false;
    }

    @Override
    public void update(int height, int width) {
        if (this.rightPressed)
        {
            this.moveRight();
        }
        if (this.leftPressed)
        {
            this.moveLeft();
        }
    }

    private void moveRight()
    {
        this.x += 10;

        checkBorder();

    }
    private void moveLeft()
    {
        this.x -= 10;

        checkBorder();

    }

    private void getPowerup(reefScore powers)
    {
        this.powers.setType(this.powers.getType() | powers.getType());
        powers.set_visible(false);
        // sr.delete_list.add(powers);
    }

    private  void checkBorder()
    {
        if (x < 110) {
            x = 110;
        }
        if (x >= 1000 - width ) {
            x = 1000 - width ;
        }

    }



    @Override
    public int whoAmI()
    {
        return KUTCH;
    }

    void drawImage (Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;
        if (!super.is_visible())
        {
            return;
        }
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x,y,width,length);

    }

}
