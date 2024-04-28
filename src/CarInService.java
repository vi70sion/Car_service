public class CarInService extends Car{
    private String defects;

    public CarInService(String brand, String model, int year, FuelType fuelType, String defects) {
        super(brand, model, year, fuelType);
        this.defects = defects;
    }

    public String getDefects() { return defects; }
    public void setDefects(String defects) { this.defects = defects; }

    @Override
    public String toString(){
        return super.toString() + " " + defects;
    }

    public String getCarInfoForCSV(){
        return getBrand() + "," + getModel() + "," + getYear() + "," + getFuelType() + "," + getDefects();
    }

}
