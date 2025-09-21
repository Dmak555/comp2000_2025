import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class Cell extends Rectangle {
  static int size = 35;
  char col;
  int row;

  private Terrain terrain = Terrain.GRASS;

  public Cell(char inCol, int inRow, int x, int y){
    super(x, y, size, size);
    col = inCol;
    row = inRow;
  }

  public void setTerrain(Terrain t){
    this.terrain = t;
  }
  public Terrain getTerrain(){
    return terrain;
  }

  public void paint(Graphics g,Point mousePos){
  g.setColor(terrain.fill);
  g.fillRect(x, y, width,height);
  g.setColor(java.awt.Color.GRAY);
  g.drawRect(x, y, width,height);
  }

}
