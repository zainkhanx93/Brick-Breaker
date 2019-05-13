import java.awt.*;

public class reefScore extends gameObject {

    int type;
    int score;
    int totalscore;
    private Color myColor;
    public SuperRainbow sr;
    Kutch k1;

    reefScore(int type, int x, int y, int sc, SuperRainbow s, Kutch k)
    {
        super(x,y,20,20);
        // this.x = x;
        //  this.y = y;
        this.sr = s;
        this.k1 = k;
        this.type = type;
        this.score = sc;

        if(type == 1)
        {
            // no power ups
            // get the basic 100 pts
            this.score = 100;
        }
        // multi pops
        if(type == 2)
        {
            // no power ups
            // 100 pts
            this.score = 100;
        }
        if(type == 3)
        {
            // 100 pts
            // extra ball is released
            this.score = 100;
        }
        if(type == 4)
        {
            //no power ups
            //double points
            this.score = 200;
        }
        if(type == 5)
        {
            this.score = 300;
            // 500 pts
            // takes 5 hit to destroy
        }
    }

    public int getType()
    {
        System.out.println("Type is " + type);
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }


    public int getScore()
    {
        return score;
    }

    public void setScore(int sc)
    {
        this.score = sc;
    }
    public int getTotalscore()
    {
        return 0;
    }

    public void Draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman",Font.PLAIN,16));
        g.drawString(Integer.toString(this.score),x,y);
        // System.out.println("Score = "+ this.score);

        // g.drawString(Integer.toString(this.totalscore), x, y);

    }



}
