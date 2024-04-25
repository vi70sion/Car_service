import java.io.*;
import java.util.ArrayList;
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

            String line;
            while ((line = bufferedReader.readLine()) != null ) {
                sortedList.add(line);
            }
            Collections.sort(sortedList);
            String[] lineValues1 = sortedList.get(0).split(",");
            for(int i = 1; i < sortedList.size(); i++){

                String[] lineValues2 = sortedList.get(i).split(",");

//                if(lineValues.length == 8){  // private customer
//                    int id = Integer.parseInt(lineValues[0]);
//                    String name = lineValues[1];
//                    String lastName = lineValues[2];
//                    String eMail = lineValues[3];
//                    String brand = lineValues[4];
//                    String model = lineValues[5];
//                    int year = Integer.parseInt(lineValues[6]);
//                    String fuelType = lineValues[7];
//
//
//                } else if (lineValues.length == 10) {   //business customer
//                }

            }











            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }


    }
}
