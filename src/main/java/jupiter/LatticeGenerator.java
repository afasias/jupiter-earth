package jupiter;

import java.util.Collection;

public interface LatticeGenerator {

  public Collection<Point> generateLattice(double radius, double boundary);

}
