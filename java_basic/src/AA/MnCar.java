package AA;

public class MnCar extends MnVehicle {

    public MnCar() {
        super();
    }

    @Override
    public void describe() {
        System.out.println("This is a car of " + brand + 
        " with a fuel capacity of " + fuelCapacity + " liters");
    }
}
