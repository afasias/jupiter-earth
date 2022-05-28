package jupiter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sphere {

  private Point center;
  private double radius;

  public boolean contains(Sphere other) {
    return center.distance(other.getCenter()) <= radius - other.getRadius();
  }

}
