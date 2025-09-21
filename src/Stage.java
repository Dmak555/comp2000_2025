import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;
  List<Item> items;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    items = new ArrayList<Item>();

    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));   
    
    items.add(new Bone(grid.cellAtColRow(5, 5).get()));
    items.add(new Fish(grid.cellAtColRow(10, 10).get())); 
    items.add(new Seed(grid.cellAtColRow(15, 15).get()));
  }

  private void paintAll(Graphics g, List<? extends Drawable> things) {
    for (Drawable d : things) d.paint(g);
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);

    paintAll(g, actors);
    paintAll(g, items);

    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if (underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }

    g.setColor(Color.BLACK);
    g.drawString("Legend:", 740, 60);
    g.setColor(new Color(245,245,200)); g.fillRect(740, 70, 16, 10);
    g.setColor(Color.BLACK);            g.drawString("Bone", 762, 78);
    g.setColor(new Color(90,160,255));  g.fillRect(740, 90, 16, 10);
    g.setColor(Color.BLACK);            g.drawString("Fish", 762, 98);
    g.setColor(new Color(80,200,120));  g.fillRect(740,110, 16, 10);
    g.setColor(Color.BLACK);            g.drawString("Seed", 762,118);
  }
}