public class BooleanSource {

  double probability;

  public BooleanSource(double p) {
    if (p < 0.0 || p > 1.0) {
      throw new IllegalArgumentException();
    }

    this.probability = p;
  }

  boolean RequestArrived() {
    return (Math.random() < probability);
  }
}
