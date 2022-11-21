package DefiningClassesEx.CatLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public double getFeature(){
        return this.furLength;
    }
}
