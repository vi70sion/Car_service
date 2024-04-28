import java.util.List;

public interface Interface {
    public void registerCarForService(Car car);
    public int assignReplaceCar(List<Car> replaceCarList);
    public void importAllCustomersFromCSV(String filePath, List<Customer> list);
    public void importReplaceCarsListFromCSV(String filePath, List<Car> list);
    public void returnCustomersCar (String filePath, Car car);

}
