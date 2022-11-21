package DefiningClassesEx.SpeedRacing;

public class Car {
    private static int DEFAULT_MILEAGE = 0;
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int mileage = DEFAULT_MILEAGE;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public void drive(int km) {
        double neededFuel = fuelCost * km;
        if (fuelAmount - neededFuel >= 0) {
            this.mileage += km;
            fuelAmount -= neededFuel;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getMileage() {
        return mileage;
    }
}
