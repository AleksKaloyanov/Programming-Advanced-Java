package DefiningClassesEx.CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public double getFeature() {
        return this.earSize;
    }
}
