import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String lastName;
    private String eMail;
    private Car replCar;
    public List<Car> customerCarList = new ArrayList<>();

    public Customer(int id, String name, String lastName, String eMail, Car replCar) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.replCar = replCar;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String geteMail() { return eMail; }
    public void seteMail(String eMail) { this.eMail = eMail; }
    public Car getReplCar() { return replCar; }
    public void setReplCar(Car replCar) { this.replCar = replCar; }
    @Override
    public boolean equals(Object object){
        Customer customer = (Customer) object;
        if(customer.id == this.id){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return getId() + " " + getName() + " " + getLastName() + " " + geteMail();
    }
}
