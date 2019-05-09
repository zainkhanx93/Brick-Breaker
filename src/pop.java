import java.awt.*;
import java.awt.image.BufferedImage;
public class pop extends gameObject{
    int damage;
    int angle;
    final int speed = 5;
    public SuperRainbow sr;
    Kutch k;

    public pop (int x, int y, int damage, int angle, SuperRainbow sr, Kutch ku)
    {
        super(x,y,20,20);
        this.angle = angle;
        this.damage = damage;
        this.sr = sr;
        this.k = ku;

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



    boolean  checkCollision(int x1, int y1)
    {
        int x_,y_,len_,width_;

        for(Object object : sr.Bricks) {
            gameObject element = (gameObject) object;
            if(this == element) continue;
            if(!element.is_visible()) continue;
            x_ = element.getx();
            y_ = element.gety();
            len_ = element.getLength();
            width_ = element.getwidth();
            //System.out.println(x_ + " " + y_+" "+len_+" "+width_+ " "  + x +" " + y);
            if(element.whoAmI()==POP) continue;;
            if(((x > x_ && x< (x_+width_)) && (y > y_ && y < (y_+len_)))  ||
                    (( (x + 5) > x_ && (x+5)< (x_+width_)) && (y > y_ && y < (y_+len_)))  ||
                    (( x > x_ && x< (x_+width_)) && ((y+5) > y_ && (y+5) < (y_+len_)))  ||
                    (( (x+5) > x_ && (x+5)< (x_+width_)) && ((y+5) > y_ && (y+5) < (y_+len_))) )

            {
                //  System.out.println("Bullet Collision");

                if(((gameObject) object).BRICK == element.whoAmI()){
                    super.set_visible(false);
                    reefBricks w = (reefBricks) object;
                    if(w.is_breakable()) {
                        w.set_visible(false);
                        sr.delete_list.add(element);
                    }
                }
                if(((gameObject) object).KUTCH == element.whoAmI()){
                    Kutch w = (Kutch) object;
                    if(w != k) {
                        super.set_visible(false);
                        sr.delete_list.add(this);
                       // w.updateHealth(damage);
                    }
                    else {
                        //   System.out.println("This is my tank");
                    }
                }

                return true;
            }
        }



        return false;

    }

    public void Start(SuperRainbow sr,int angle, int x, int y)
    {

    }
    @Override
    public void update(int height, int width)
    {
        if ( y < height - 50 && y > 0 && x < width - 50 && x > 0)
        {
            x = x +(int) (speed *(Math.cos(Math.toRadians(angle))));
            y = y +(int) (speed *(Math.sin(Math.toRadians(angle))));
        }

        checkCollision(x,y);

    }

    public void drawImage(Graphics g)
    {
        if (super.is_visible())
        {
            g.setColor(Color.BLUE);
            g.fillOval(x,y,20,20);
        }
        checkCollision(x,y);
    }

}
