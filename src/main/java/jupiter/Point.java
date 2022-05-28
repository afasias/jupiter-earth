package jupiter;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

  private double x;
  private double y;
  private double z;

  public double distance(Point other) {
    return sqrt(pow(x - other.getX(), 2) + pow(y - other.getY(), 2) + pow(z - other.getZ(), 2));
  }

}
