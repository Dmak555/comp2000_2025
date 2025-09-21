import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public abstract class BaseItem implements Item{

    protected final Cell loc;
    protected final Color color;

    protected BaseItem(Cell loc,Color color){
        this.loc = loc;
        this.color = color;
    }

    @Override 
    public Cell getCell(){ 
        return loc;
    }
    
    @Override 
    public void paint(Graphics g){
        int cx = loc.x + loc.width / 2;
        int cy = loc.y + loc.height / 2;
        int s  = (int)(loc.width * 0.35);

        Polygon diamond = new Polygon(
            new int[]{cx, cx + s, cx, cx - s},
            new int[]{cy - s, cy, cy + s, cy},
            4
        );
        g.setColor(color);
        g.fillPolygon(diamond);
        g.setColor(Color.DARK_GRAY);
        g.drawPolygon(diamond);
    }
}
