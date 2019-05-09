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


    public void update() {
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
        if(checkWall(x,y)) {
            this.x += 5;
        }
        else {
            this.x-=50;
        }
        checkBorder();

    }
    private void moveLeft()
    {
        if(checkWall(x,y)) {
            this.x -= 5;
        }
        else {
            this.x += 50;
        }
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
        if (x < 35) {
            x = 35;
        }
        if (x >= SuperRainbow.SCREEN_WIDTH - 88) {
            x = SuperRainbow.SCREEN_WIDTH - 88;
        }
        if (y < 45) {
            y = 45;
        }
        if (y >= SuperRainbow.SCREEN_HEIGHT - 80) {
            y = SuperRainbow.SCREEN_HEIGHT - 80;
        }
    }

    boolean  checkWall(int x1, int y1) {
        int x_, y_, len_, width_;

        for (Object object : sr.Bricks) {
            gameObject element = (gameObject) object;
            if (this == element) continue;
            if (!element.is_visible()) continue;
            x_ = element.getx();
            y_ = element.gety();
            len_ = element.getLength();
            width_ = element.getwidth();
          //  System.out.println(x_ + " " + y_ + " " + len_ + " " + width_ + " " + x + " " + y);


            if (((x1 > x_ && x1 < (x_ + width_)) && (y1 > y_ && y1 < (y_ + len_))) ||
                    (((x1 + 70) > x_ && (x1 + 70) < (x_ + width_)) && (y1 > y_ && y1 < (y_ + len_))) ||
                    ((x1 > x_ && x1 < (x_ + width_)) && ((y1 + 80) > y_ && (y1 + 80) < (y_ + len_))) ||
                    (((x1 + 70) > x_ && (x1 + 70) < (x_ + width_)) && ((y1 + 80) > y_ && (y1 + 80) < (y_ + len_))))
            {
                return false;
            }

        }
        return true;
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
