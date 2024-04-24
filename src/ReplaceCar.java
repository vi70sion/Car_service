public class ReplaceCar extends Car{
    private int mileage;

    public ReplaceCar(String brand, String model, int year, FuelType fuelType, int mileage) {
        super(brand, model, year, fuelType);
        this.mileage = mileage;
    }
    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }



}
