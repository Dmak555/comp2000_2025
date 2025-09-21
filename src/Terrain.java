import java.awt.Color;

public enum Terrain {
  GRASS(new Color(235, 255, 235)),
  SAND (new Color(255, 245, 200)),
  WATER(new Color(210, 235, 255));

  public final Color fill;
  Terrain(Color fill) {this.fill = fill;}
}
