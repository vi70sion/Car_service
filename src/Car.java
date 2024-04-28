public class Car {
    private String brand;
    private String model;
    private int year;
    private FuelType fuelType;

    public Car(String brand, String model, int year, FuelType fuelType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public FuelType getFuelType() { return fuelType; }
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }


    @Override
    public String toString(){
        return brand + " " + model + " " + year + " " + fuelType;
    }
}
