import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ServiceManagement implements Interface{

    private List<Car> carsInServiceList = new ArrayList<>();
    public List<Car> getCarsInServiceList() { return carsInServiceList; }

    public void registerCarForService(Car car){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite gedimą: ");
        String defect = scanner.nextLine();
        carsInServiceList.add(new CarInService(car.getBrand(), car.getModel(), car.getYear(), car.getFuelType(), defect));
    }

    public int assignReplaceCar(List<Car> replaceCarList){
        Random random = new Random();
        int randomNumber = random.nextInt(replaceCarList.size());
        return randomNumber;
    }

    public void returnCustomersCar (String filePath, Car car){  //iraso automobili i SuremontuotuAutomobiliuIstorija.CSV
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            CarInService car1 = (CarInService) car;
            bufferedWriter.write(car1.getBrand()+ "," + car1.getModel() + "," + car1.getYear() + "," + car1.getFuelType() + "," + car1.getDefects());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Nepavyko rasyti failo: " + e.getMessage());
        }

    }

    @Override
    public void importAllCustomersFromCSV(String filePath, List<Customer> list){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Customer customer = null;
            String line;
            while ((line = bufferedReader.readLine()) != null ) {
                String[] lineValues = line.split(",");
                Car car = new Car(lineValues[4], lineValues[5], Integer.parseInt(lineValues[6]), FuelType.valueOf(lineValues[7].toUpperCase()));
                if(lineValues.length == 8) {    //private customer
                    customer = new Customer(Integer.parseInt(lineValues[0]), lineValues[1], lineValues[2], lineValues[3], null);
                    if(list.contains(customer)){
                        for(Customer item : list){
                            if(item.equals(customer)){
                                item.customerCarList.add(car);
                            }
                        }
                    } else {
                        customer.customerCarList.add(car);
                        list.add(customer);
                    }
                } else {    // business customer
                    customer = new BusinessCustomer(Integer.parseInt(lineValues[0]), lineValues[1], lineValues[2], lineValues[3], null,
                            lineValues[8], lineValues[9]);
                    if(list.contains(customer)){
                        for(Customer item : list){
                            if(item.equals(customer)){
                                item.customerCarList.add(car);
                            }
                        }
                    } else {
                        customer.customerCarList.add(car);
                        list.add(customer);
                    }
                }
            }
        } catch (IOException e){
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }
    }

    @Override
    public void importReplaceCarsListFromCSV(String filePath, List<Car> list){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] lineValues = line.split(",");
                list.add(new ReplaceCar(lineValues[0], lineValues[1], Integer.parseInt(lineValues[2]),
                        FuelType.valueOf(lineValues[3].toUpperCase()), Integer.parseInt(lineValues[4])));
            }
        } catch (IOException e){
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }
    }

}


