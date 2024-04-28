import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Sukurti serviso registravimo sistemą:
//        1. Sukurti klasę automobilis. Marke, modelis, metai, (Enum) KuroTipas
//        2. Sukurti klasę remontuotinasAutomobilis, kuri paveldi klasę Automobilis. : (String) Defektai
//        3. Sukurti klasę pakaitinisAutomobilis, kuri paveldi klasę Automobilis. : int Rida
//
//        Susikurti Interface ir jo Implementaciją ServisoValdymas. Kuri turi metodus
//        registruotiNaujaAutomobiliRemontui(Automobilis automobilis), suteiktiPakaitini() -- išrenka random automobili
//        iš pakaitinių automobilių sąrašo. ServisoValdymas turi turėti sąrašą remontuotinų automobilių, bei metodą
//        gautiVisąRemontuojamuAutoSarasa() kuris jį gražintų. Sąrašas turi būti private SerivsoValdymas klasės dalis.
//        Sukurti metodą grazintiKlientuiSuremontuota(Autombilis automobilis) --iraso automobili i SuremontuotuAutomobiliuIstorija.CSV
//
//        4. Sukurti klasę klientas, kuris turi Id, Varda, pavarde, el.pasto adresa, pakaitinis automobilis, bei
//        sarasa automobiliu kuriuos klientas turi.
//        5. Sukurti klasę verslo klientas kuri papildytų klasę klientas su Imones pavadinimas, PVM Moketojo kodas(String)
//
//        Duomenys turi būti nuskaitomi iš 3 CSV failų:
//        KlientaiIrJuAuto.csv, PakaitiniaiAutomobiliai.csv, SuremontuotuAutomobiliuIstorija.csv


        Scanner scanner = new Scanner(System.in);
        String filePathClients = "C:\\JavaTest\\KlientaiIrJuAuto.csv";
        String filePathReplaceCar = "C:\\JavaTest\\PakaitiniaiAutomobiliai.csv";
        String filePathServicedCarHistory = "C:\\JavaTest\\SuremontuotuAutomobiliuIstorija.csv";
        ServiceManagement management = new ServiceManagement();
        List<Customer> customerList = new ArrayList<>();
        List<Car> replaceCarList = new ArrayList<>();

        String choice = "";
        do{
            System.out.println("(1)- nuskaityti klientų duomenis ir pakaitinius automobilius iš failų,");
            System.out.println("(2)- registruoti naują automobilį remontui ir gauti pakaitinį, ");
            System.out.println("(3)- remontuojamų automobilių sąrašas, ");
            System.out.println("(4)- grąžinti klientui suremontuotą automobilį, (0)- pabaiga");
            choice = scanner.nextLine();
            switch(choice){
                case "1":
                    customerList.clear();
                    management.importAllCustomersFromCSV(filePathClients, customerList);
                    management.importReplaceCarsListFromCSV(filePathReplaceCar, replaceCarList);
                    System.out.println("Įvykdyta.");
                    break;
                case "2":
                    System.out.println("Pasirinkite klientą (ID): ");
                    printCustomerList(customerList);
                    String input = scanner.nextLine();
                    Customer custSelection = customerList.get(Integer.parseInt(input) - 1);
                    System.out.println("Pasirinkite automobilį (ID): ");
                    int i = 0;
                    for(Car item : custSelection.customerCarList){  //print customer car list
                        i++;
                        System.out.println(i + " " + item);
                    }
                    Car carSelection = custSelection.customerCarList.get(Integer.parseInt(scanner.nextLine())-1);
                    System.out.println("Pasirinktas automobilis " + carSelection);
                    management.registerCarForService(carSelection); //register car for service
                    int carNumberInList = 0;
                    for(Customer item : customerList){
                        if(item.equals(custSelection)){
                            carNumberInList = management.assignReplaceCar(replaceCarList); //get random int number, car index in replacement car list
                            item.setReplCar(replaceCarList.get(carNumberInList));   // assign car to customer
                            System.out.println("Klientui suteiktas pakaitinis automobilis:");
                            System.out.println(item.getReplCar());
                            replaceCarList.remove(carNumberInList); //remove selected car from replacement car list
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Šiuo metu remontuojami automobiliai:");
                    for(Car item : management.getCarsInServiceList()){
                        System.out.println(item);
                    }
                    break;
                case "4":
                    System.out.println("Pasirinkite automobilį, kuriam baigtas remontas (ID):");
                    int j = 0;
                    for(Car item : management.getCarsInServiceList()){
                        j++;
                        System.out.println(j + " " + item);
                    }
                    int selection = Integer.parseInt(scanner.nextLine())-1;
                    management.returnCustomersCar(filePathServicedCarHistory, management.getCarsInServiceList().get(selection)); //write car service history to csv
                    management.getCarsInServiceList().remove(selection); //remove car from service list
                    break;
                case "0":
                    break;
            }
        } while (!choice.equals("0"));

    }
    public static void printCustomerList(List<Customer> list){
        for(Customer item : list){
            System.out.println(item);
        }
    }

}