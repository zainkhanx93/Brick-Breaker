import java.awt.*;

public class reefBricks extends gameObject{
    private int direction;
    int type;
    boolean breakable;
    private reefHealth h;
    private Color brickColor1;
    reefBricks(int type, int startX,int startY, int length, int direction, boolean breakables)
    {

        super(startX,startY,10,length);
        this.type = type;
        if (direction != 1)
        {
            super.set_length(length);
            super.set_width(10);
        }

        this.direction = direction;
        this.breakable = breakables;
        if (breakables == true && type == 1)
        {
                brickColor1 = Color.pink;
        }
        else if (breakables == true && type == 2)
        {
            brickColor1 = Color.GREEN;
        }
        else if( breakables == true && type == 3)
        {
            brickColor1 = Color.CYAN;
        }
        else if( breakables == true && type == 4)
        {
            brickColor1 = Color.MAGENTA;
        }
        else if (breakables == true && type == 5)
        {
                brickColor1 = Color.ORANGE;
        }

        else
        {
            brickColor1 = Color.GRAY;
        }

    }

    public boolean is_breakable()
    {
        return breakable;
    }

    @Override
    public int whoAmI()
    {
        if ( breakable = true)
        {
            return BRICK;
        }
        else
        {
            return WALL;
        }
    }

    @Override
    void drawImage(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        if(!super.is_visible()){
            return;
        }
        g2d.setColor(brickColor1);
        //super.drawImage(g2d);
        g2d.fillRect(x, y,width,length);

    }
}
