import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor implements Drawable {
  Color color;
  Cell loc;
  List<Polygon> display;

  public void paint(Graphics g){
    if(display ==null) 
    return;
    for(Polygon p: display){
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }
}
