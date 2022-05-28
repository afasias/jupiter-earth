package jupiter;

import static java.lang.Math.ceil;
import java.util.Collection;

public class Main {

  private static final double EARTH_RADIUS = 1;

  private static final double JUPITER_RADIUS = EARTH_RADIUS * 10.973;

  private static final double RESOLUTION = 200;

  public static void main(String[] args) {
    LatticeGenerator latticeGenerator = new HexagonalLatticeGenerator();
    double boundary = EARTH_RADIUS * ceil(JUPITER_RADIUS / EARTH_RADIUS) + EARTH_RADIUS;
    Collection<Point> lattice = latticeGenerator.generateLattice(EARTH_RADIUS, boundary);
    long maxEarthCount = 0;
    for (double x = -EARTH_RADIUS; x < EARTH_RADIUS; x += EARTH_RADIUS / RESOLUTION) {
      for (double y = -EARTH_RADIUS; y < EARTH_RADIUS; y += EARTH_RADIUS / RESOLUTION) {
        for (double z = -EARTH_RADIUS; z < EARTH_RADIUS; z += EARTH_RADIUS / RESOLUTION) {
          Sphere jupiter = new Sphere(new Point(x, y, z), JUPITER_RADIUS);
          long earthCount = lattice.stream()
              .map(point -> new Sphere(point, EARTH_RADIUS))
              .filter(jupiter::contains)
              .count();
          if (maxEarthCount < earthCount) {
            maxEarthCount = earthCount;
          }
        }
      }
    }
    System.out.println(maxEarthCount);
  }

}
