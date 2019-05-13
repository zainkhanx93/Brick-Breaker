import java.awt.*;
import java.awt.image.BufferedImage;
public class pop extends gameObject{
    int damage;
    int angle;
    int speed ;
    int life;
    boolean running;
    public SuperRainbow sr;
    Kutch k;
    private reefHealth health;
    private totalScore scr;

    public pop (int x, int y, int life, int damage, int angle, SuperRainbow sr,reefHealth h, Kutch ku, totalScore sc)
    {
        super(x,y,20,20);
        this.angle = angle;
        this.life = life;
        this.damage = damage;
        this.sr = sr;
        this.k = ku;
        this.health = h;
        this.scr=sc;
        this.speed = 10;
        this.running = false;

    }

    public void setRunning(boolean run){
        this.running = run;
    }

    @Override
    public int whoAmI()
    {
        return POP;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public boolean getShow()
    {
        return super.is_visible();
    }
    public void setShow( boolean show)
    {
        super.set_visible(show);
    }


    public void setNextSpeed(){
        speed += 5;
    }


    boolean  checkCollision(int x1, int y1) {
        checkBrickCollision(x1,y1);
        return checkControlCollision(x1,y1);

    }

    boolean  checkBrickCollision(int x1, int y1) {
        int x_, y_, len_, width_;

        for (Object object : sr.Bricks) {
            gameObject element = (gameObject) object;
            if (this == element) continue;
            if (!element.is_visible()) continue;
            x_ = element.getx();
            y_ = element.gety();
            len_ = element.getLength();
            width_ = element.getwidth();
            //System.out.println(x_ + " " + y_+" "+len_+" "+width_+ " "  + x +" " + y);
            if (element.whoAmI() == POP) continue;
            ;
            if (((x > x_ && x < (x_ + width_)) && (y > y_ && y < (y_ + len_))) ||
                    (((x + 5) > x_ && (x + 5) < (x_ + width_)) && (y > y_ && y < (y_ + len_))) ||
                    ((x > x_ && x < (x_ + width_)) && ((y + 5) > y_ && (y + 5) < (y_ + len_))) ||
                    (((x + 5) > x_ && (x + 5) < (x_ + width_)) && ((y + 5) > y_ && (y + 5) < (y_ + len_)))) {
                //  System.out.println("Bullet Collision");

                if (((gameObject) object).BRICK == element.whoAmI()) {

                    reefBricks w = (reefBricks) object;
                    if (w.is_breakable()) {
                        System.out.println(("Deleting 1"));
                        scr.addToScore(w.getValue());
                        w.set_visible(false);
                        sr.delete_list.add(element);
                    }
                    this.angle *= -1;
                    this.angle = this.angle % 360;
                }

                return true;
            }
        }


        return false;

    }

    boolean  checkControlCollision(int x1, int y1) {
        int x_, y_, len_, width_;

        for (Object object : sr.Controls) {
            gameObject element = (gameObject) object;
            if (this == element) continue;
            if (!element.is_visible()) continue;
            x_ = element.getx();
            y_ = element.gety();
            len_ = element.getLength();
            width_ = element.getwidth();
            //System.out.println(x_ + " " + y_+" "+len_+" "+width_+ " "  + x +" " + y);
            if (element.whoAmI() == POP) continue;
            ;
            if (((x > x_ && x < (x_ + width_)) && (y > y_ && y < (y_ + len_))) ||
                    (((x + 10) > x_ && (x + 10) < (x_ + width_)) && (y > y_ && y < (y_ + len_))) ||
                    ((x > x_ && x < (x_ + width_)) && ((y + 5) > y_ && (y + 5) < (y_ + len_))) ||
                    (((x + 10) > x_ && (x + 10) < (x_ + width_)) && ((y + 5) > y_ && (y + 5) < (y_ + len_)))) {
                //  System.out.println("Bullet Collision");


                if (((gameObject) object).KUTCH == element.whoAmI()) {
                    Kutch w = (Kutch) object;
                    if (w == k) {
                        // Chsnge Angle/ this is the bouncing back
                        this.angle *= -1;
                        this.angle = this.angle % 360;

                        //  Check where in Kutch it is hitting
                        // if 1st 1/3 then subtract 30 from angle
                        // if last 1/3 then add 30 to angle

                        if((x - k.getx()) < (k.getwidth()/3))
                        {

                            this.angle = angle - 30;
                            System.out.println("Frst 3rd " + angle + " " + k.getwidth() + " " + x + " " + k.getx());
                        }
                        else if(( k.getx() + k.getwidth() - x )< (k.getwidth()/3))
                        {
                            this.angle = angle + 30;
                            System.out.println("Last 3rd " + angle);
                        }
                    }
                }
                if (((gameObject) object).WALL == element.whoAmI()) {
                    reefBricks w = (reefBricks) object;
                    if(w.getDirection() == 0){
                        this.angle = -(180 + this.angle);
                    } else {
                        this.angle *= -1;
                    }
                }

                return true;
            }
        }


        return false;

    }

    /*public void Start(SuperRainbow sr,int angle, int x, int y)
    {

    }*/

    public void updateLife(int m)
    {
        System.out.println("Ball lost");
        this.health.Miss(life);
    }

    public boolean checkAlive() {
        return health.isAlive();
    }

    @Override
    public void update(int height, int width)
    {
        if(running)

            if ( y < height - 50 && y > 0 && x < width - 50 && x > 0)
            {
                x = x +(int) (speed *(Math.cos(Math.toRadians(angle))));
                y = y +(int) (speed *(Math.sin(Math.toRadians(angle))));
            } else {
                //  updateLife(life);
                // Ball is out of game board
                health.Miss(1);
                if (health.isAlive())
                {
                    x = 500;
                    y = 600;
                    angle = 90;
                }


            }

        checkCollision(x,y);

    }

    public void drawImage(Graphics g)
    {
        if (super.is_visible() && running)
        {
            g.setColor(Color.BLUE);
            g.fillOval(x,y,20,20);
        }
        //checkCollision(x,y);
    }

}
