import java.util.List;

public class BusinessCustomer extends Customer{
    private String businessName, vatNumber;

    public BusinessCustomer(int id, String name, String lastName, String eMail, Car replCar, String businessName, String vatNumber) {
        super(id, name, lastName, eMail, replCar);
        this.businessName = businessName;
        this.vatNumber = vatNumber;
    }

    public String getBusinessName() { return businessName;}
    public void setBusinessName(String businessName) { this.businessName = businessName;}
    public String getVatNumber() { return vatNumber; }
    public void setVatNumber(String vatNumber) { this.vatNumber = vatNumber; }

    @Override
    public String toString(){
        return getId() + " " + getName() + " " + getLastName() + " " + geteMail() + " " + getBusinessName() + " " + getVatNumber();
    }
}
