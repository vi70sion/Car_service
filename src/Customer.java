import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String lastName;
    private String eMail;
    private String replCar;
    private List<Car> customerCarList;

    public Customer(int id, String name, String lastName, String eMail, String replCar, List<Car> customerCarList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.replCar = replCar;
        this.customerCarList = customerCarList;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String geteMail() { return eMail; }
    public void seteMail(String eMail) { this.eMail = eMail; }
    public String getReplCar() { return replCar; }
    public void setReplCar(String replCar) { this.replCar = replCar; }
    public List<Car> getCustomerCarList() { return customerCarList; }
    public void setCustomerCarList(List<Car> customerCarList) { this.customerCarList = customerCarList; }



}
