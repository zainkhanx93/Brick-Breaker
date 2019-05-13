import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class totalScore extends gameObject {
    private int finalscore;
    private reefScore score;
    // private reefBricks brick;


    totalScore(int x, int y, int fs, reefScore sc)
    {
        super(x,y,30,30);
        this.score = sc;
        this.finalscore = fs;
        // this.brick = rb;
    }

    public void addToScore(int n){
        this.finalscore += n;
    }

    @Override
    public void update(int x, int y){
        // this.finalscore += score;
    }

    @Override
    public void drawImage(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman",Font.BOLD,35));
        g.drawString(Integer.toString(this.finalscore),x,y);

    }


}
