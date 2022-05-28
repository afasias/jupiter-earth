package jupiter;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.Collection;

public class HexagonalLatticeGenerator implements LatticeGenerator {

  @Override
  public Collection<Point> generateLattice(double radius, double boundary) {
    Collection<Point> lattice = new ArrayList<>();
    double h = radius * sqrt(3);
    boolean evenX = true;
    for (double x = 0; x < boundary; x += radius, evenX = !evenX) {
      boolean evenY = true;
      for (double y = 0; y < boundary; y += h, evenY = !evenY) {
        boolean evenZ = true;
        for (double z = 0; z < boundary; z += h, evenZ = !evenZ) {
          if (((evenX == evenY) && evenZ) || ((evenX != evenY) && !evenZ)) {
            lattice.add(new Point(x, y, z));
            lattice.add(new Point(-x, y, z));
            lattice.add(new Point(x, -y, z));
            lattice.add(new Point(-x, -y, z));
            lattice.add(new Point(x, y, -z));
            lattice.add(new Point(-x, y, -z));
            lattice.add(new Point(x, -y, -z));
            lattice.add(new Point(-x, -y, -z));
          }
        }
      }
    }
    return lattice.stream()
        .distinct()
        .collect(toList());
  }

}
