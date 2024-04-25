import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Override
    public void importCustomersFromCSV(String filePath, List<Customer> list) {
        Customer customer;
        try{
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> sortedList = new ArrayList<>();
            List<Car> customerCarList = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null ) {
                sortedList.add(line);
            }
            Collections.sort(sortedList);

            String[] lineValues1 = sortedList.get(0).split(",");
            customerCarList.add(new Car(lineValues1[4], lineValues1[5], Integer.parseInt(lineValues1[6]), FuelType.valueOf(lineValues1[7].toUpperCase())));
            for(int i= 1; i < sortedList.size(); i++){
                String[] lineValues2 = sortedList.get(i).split(",");
                if(lineValues1[0].equals(lineValues2[0])){ // if the same customer, adding cars to customer car list
                    customerCarList.add(new Car(lineValues2[4], lineValues2[5], Integer.parseInt(lineValues2[6]), FuelType.valueOf(lineValues2[7].toUpperCase())));

                } else {
                    if(lineValues1.length == 8){  // private customer
                        list.add(new Customer(Integer.parseInt(lineValues1[0]), lineValues1[1], lineValues1[2], lineValues1[3], null, new ArrayList<>(customerCarList)));
                    } else if (lineValues1.length == 10) {   //business customer
                        list.add(new BusinessCustomer(Integer.parseInt(lineValues1[0]), lineValues1[1], lineValues1[2], lineValues1[3], null, new ArrayList<>(customerCarList),
                                lineValues1[8], lineValues1[9]));
                    }
                    customerCarList.clear();
                    customerCarList.add(new Car(lineValues2[4], lineValues2[5], Integer.parseInt(lineValues2[6]), FuelType.valueOf(lineValues2[7].toUpperCase())));
                }
                lineValues1 = Arrays.copyOf(lineValues2, lineValues2.length);
            }
            // couldn't think of a smarter way to add the last line
            if(lineValues1.length == 8){  // private customer
                list.add(new Customer(Integer.parseInt(lineValues1[0]), lineValues1[1], lineValues1[2], lineValues1[3], null, new ArrayList<>(customerCarList)));
            } else if (lineValues1.length == 10) {   //business customer
                list.add(new BusinessCustomer(Integer.parseInt(lineValues1[0]), lineValues1[1], lineValues1[2], lineValues1[3], null, new ArrayList<>(customerCarList),
                        lineValues1[8], lineValues1[9]));
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }
    }


}
