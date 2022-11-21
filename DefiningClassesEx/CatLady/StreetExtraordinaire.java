package DefiningClassesEx.CatLady;

public class StreetExtraordinaire extends Cat {

    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    @Override
    public double getFeature() {
        return this.decibels;
    }
}
