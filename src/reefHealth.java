import java.awt.*;

public class reefHealth {

    private boolean show;
    public int lifeCount;
    private int lifeLost;
    private int x,y;
    private boolean miss;
    private Color lifeColor;

    reefHealth(int x, int y, int life, int lost)
    {
        this.lifeCount = life;
        this.lifeLost = lost;
        this.x = x;
        this.y = y;
        this.miss = false;
        this.show = true;
    }

    public int getLifeCount ()
    {
        return this.lifeCount;
    }
    public int getDamage()
    {
        return this.lifeLost;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    public boolean getNiss(){
        return this.miss;
    }
    public boolean geShow()
    {
        return this.show;
    }

    public void setShow(boolean sh)
    {
        this.show = sh;
    }

    public void Miss (int m)
    {
        this.lifeCount -= m;
        if( this.lifeCount < 0) this.lifeCount = 0;
    }

    public boolean isAlive()
    {
        if(lifeCount <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void update (int x, int y)
    {
        if (miss = true)
        {
            lifeCount = lifeCount - lifeLost;
        }
    }

    public void draw(Graphics g)
    {
        if(show)
        {
            g.setColor(Color.BLUE);
            g.fillOval(x,y,30,30);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman",Font.PLAIN,24));
            g.drawString(Integer.toString(lifeCount),x,y);
        }
    }
}
