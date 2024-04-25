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

        String choice = "";
        do{
            System.out.println("(1)- nuskaityti klientų duomenis iš failo, (0)- pabaiga");
            choice = scanner.nextLine();
            switch(choice){
                case "1":
                    customerList.clear();
                    management.importCustomersFromCSV(filePathClients, customerList);
                    System.out.println();

                    break;
                case "0":
                    break;
            }
        } while (!choice.equals("0"));



    }
}