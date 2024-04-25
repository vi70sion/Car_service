import java.io.FileNotFoundException;
import java.util.List;

public interface Interface {
    public void registerCarForService(Car car);
    public void assignReplaceCar();
    public void importCustomersFromCSV(String filePath, List<Customer> list);

}
