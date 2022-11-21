package DefiningClassesEx.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tire1;
    private Tires tire2;
    private Tires tire3;
    private Tires tire4;

    public Car(String model, Engine engine, Cargo cargo, Tires tire1, Tires tire2, Tires tire3, Tires tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getType() {
        return cargo.getType();
    }

    public double[] getPressure() {
        double[] pressure = new double[4];
        pressure[0] = tire1.getPressure();
        pressure[1] = tire2.getPressure();
        pressure[2] = tire3.getPressure();
        pressure[3] = tire4.getPressure();
        return pressure;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return engine.getPower();
    }
}
