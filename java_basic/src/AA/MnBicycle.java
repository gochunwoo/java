package AA;

public class MnBicycle extends MnCar {
    int gearCount = 21;

    @Override
    public void describe() {
        System.out.println("\"This is a bicycle of " + brand + " with " + gearCount + " gears");
    }
}
