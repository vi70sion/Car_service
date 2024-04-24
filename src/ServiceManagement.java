import java.util.List;

public class ServiceManagement implements Interface{

    private List<Car> carsInServiceList;


    public List<Car> getCarsInServiceList() {  return carsInServiceList; }
    public void setCarsInServiceList(List<Car> carsInServiceList) { this.carsInServiceList = carsInServiceList; }

    public void registerCarForService(Car car){

    }

    public void assignReplaceCar(){

    }

    public void returnCustomersCar (Car car){  //iraso automobili i SuremontuotuAutomobiliuIstorija.CSV

    }
}
