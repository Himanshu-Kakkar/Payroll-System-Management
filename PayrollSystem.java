import java.util.*;
import java.io.*;

class Employee {
    protected int id;
    protected String name;
    protected double salary;

    public Employee(String name,int id, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public double calculatePay() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary+"\n");
    }

    public static boolean isIdUnique(int id, ArrayList<? extends Employee> employees) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean StringException(String input)
    {
        int i=0;
        while(i<input.length())
        {
            if( !( input.charAt(i)>='0' && input.charAt(i)<='9'))
            {
                System.out.println("\nplease Enter a valid Number");
                return true;
            }
            i++;
        }
        return false;
    }
}

class Manager extends Employee {

    public Manager(String name,int id, double salary) {
        super(name, id ,salary);
    }

    public static void addManager(ArrayList<Manager> managers, Scanner scanner) {
    try{
        System.out.print("Enter the number of managers to add: ");
        int numManagers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numManagers; i++) {
            int managerId;
            String temp;
            do{
                do{
                    System.out.print("Enter Manager ID: ");
                    temp= scanner.nextLine();
                }while(StringException(temp));

                managerId = Integer.parseInt(temp);
            }while(managerId<=0);  // checking manager ID >0
            

            if(isIdUnique(managerId, managers)) {
                System.out.print("Enter Manager name: ");
                String managerName = scanner.nextLine();
            
                double managerSalary;
                String tempSalary;
                do{
                    do{
                        System.out.print("Enter Manager salary: ");
                        tempSalary= scanner.nextLine();
                    }while(StringException(tempSalary));
                    
                    managerSalary = Double.parseDouble(tempSalary);
                }while(managerSalary<=0);   // checking salary >0


                managers.add(new Manager(managerName, managerId, managerSalary));
                System.out.println("Manager added successfully.");
            }
            else {
                System.out.println("Manager with ID " + managerId + " already exists. Skipping...");
            }
        }
        if(numManagers<1)
        {
            System.out.println("\nEnter a valid number of managers\n");
            addManager(managers, scanner); // recursion
        }
    }
    catch(InputMismatchException | NumberFormatException e)
    //catch(Exception e)
    {
        System.out.println("\nEnter a valid number\n");
    }
    }

    public static void removeManager(ArrayList<Manager> managers, Scanner scanner) {
        int idToRemove=0;
        try{
        System.out.print("Enter Manager ID to remove: ");
        idToRemove = scanner.nextInt();
        scanner.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("\nEnter a valid ID");
        }
        for (Manager manager : managers) {
            if (manager.id == idToRemove) {
                managers.remove(manager);
                System.out.println("Manager with ID " + idToRemove + " removed successfully.");
                return; 
            }
        }
        System.out.println("Manager with ID " + idToRemove + " not found.");
    }

    public static void managerEnquiry(ArrayList<Manager> managers) {
        System.out.println("Manager Enquiry:");
        for (Manager manager : managers) {
            manager.displayInfo();
        }
        System.out.println("\n");
    }
}

class Developer extends Employee {

    public Developer(String name,int id, double salary) {
        super(name,id, salary);
    }

    public static void addDeveloper(ArrayList<Developer> developers, Scanner scanner) {
    try{
        System.out.print("Enter the number of developers to add: ");
        int numDevelopers = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numDevelopers; i++) {
            int developerId;
            String temp;
            do{
                do{
                    System.out.print("Enter Developer ID: ");
                    temp= scanner.nextLine();
                }while(StringException(temp));
                developerId = Integer.parseInt(temp);
            }while(developerId<=0);

            if (isIdUnique(developerId, developers)) {
                System.out.print("Enter Developer name: ");
                String developerName = scanner.nextLine();

                double developerSalary;
                String tempSalary;
                do{
                    do{
                        System.out.print("Enter Developer salary: ");
                        tempSalary= scanner.nextLine();
                    }while(StringException(tempSalary));
                    
                    developerSalary = Double.parseDouble(tempSalary);
                }while(developerSalary<=0);

                developers.add(new Developer(developerName, developerId, developerSalary));
                System.out.println("Developer added successfully.");
            } else {
                System.out.println("Developer with ID " + developerId + " already exists. Skipping...");
            }
        }
        if(numDevelopers<1)
        {
            System.out.println("\nEnter a valid number of Developers\n");
            addDeveloper(developers, scanner);
        }
    }
    catch(InputMismatchException | NumberFormatException e)
    //catch(Exception e)
    {
        System.out.println("\nEnter a valid number\n");
    }
    }

    public static void removeDeveloper(ArrayList<Developer> developers, Scanner scanner) {
        int idToRemove=0;
        try{
        System.out.print("Enter Developer ID to remove: ");
        idToRemove = scanner.nextInt();
        scanner.nextLine(); 
        }
        catch(Exception e)
        {
            System.out.println("\nEnter a valid ID");
        }
        for (Developer developer : developers) {
            if (developer.id == idToRemove) {
                developers.remove(developer);
                System.out.println("Developer with ID " + idToRemove + " removed successfully.");
                return;
            }
        }
        System.out.println("Developer with ID " + idToRemove + " not found.");
    }

    public static void developerEnquiry(ArrayList<Developer> developers) {
        System.out.println("Developer Enquiry:");
        for (Developer developer : developers) {
            developer.displayInfo();
        }
        System.out.println("\n");
    }
}

class SalesAgent extends Employee {

    public SalesAgent(String name,int id, double salary) {
        super(name,id, salary);
    }

    public static void addSalesAgent(ArrayList<SalesAgent> SalesAgents, Scanner scanner) {
    try{
        System.out.print("Enter the number of SalesAgents to add: ");
        int numSalesAgents = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numSalesAgents; i++) {
            int SalesAgentId;
            String temp;
            do{
                do{
                    System.out.print("Enter SalesAgent ID: ");
                    temp= scanner.nextLine();
                }while(StringException(temp));
                SalesAgentId = Integer.parseInt(temp);
            }while(SalesAgentId<=0);

            if (isIdUnique(SalesAgentId, SalesAgents)) {
                System.out.print("Enter SalesAgent name: ");
                String SalesAgentName = scanner.nextLine();

                double SalesAgentSalary;
                String tempSalary;
                do{
                    do{
                        System.out.print("Enter Manager salary: ");
                        tempSalary= scanner.nextLine();
                    }while(StringException(tempSalary));
                    
                    SalesAgentSalary = Double.parseDouble(tempSalary);
                }while(SalesAgentSalary<=0);

                SalesAgents.add(new SalesAgent(SalesAgentName, SalesAgentId, SalesAgentSalary));
                System.out.println("SalesAgent added successfully.");
            } else {
                System.out.println("SalesAgent with ID " + SalesAgentId + " already exists. Skipping...");
            }
        }
        if(numSalesAgents<1)
        {
            System.out.println("\nEnter a valid number of Sales Agent\n");
            addSalesAgent(SalesAgents, scanner);
        }
    }
    catch(InputMismatchException | NumberFormatException e)
    //catch(Exception e)
    {
        System.out.println("\nEnter a valid number\n");
    }
    }
    
    public static void removeSalesAgent(ArrayList<SalesAgent> SalesAgents, Scanner scanner) {
        int idToRemove=0;
        try{
        System.out.print("Enter SalesAgent ID to remove: ");
        idToRemove = scanner.nextInt();
        scanner.nextLine(); 
        }
        catch(Exception e)
        {
            System.out.println("\nEnter a valid ID");
        }
        for (SalesAgent SalesAgent : SalesAgents) {
            if (SalesAgent.id == idToRemove) {
                SalesAgents.remove(SalesAgent);
                System.out.println("SalesAgent with ID " + idToRemove + " removed successfully.");
                return;
            }
        }
        System.out.println("SalesAgent with ID " + idToRemove + " not found.");
    }

    public static void SalesAgentEnquiry(ArrayList<SalesAgent> SalesAgents) {
        System.out.println("SalesAgent Enquiry:");
        for (SalesAgent SalesAgent : SalesAgents) {
            SalesAgent.displayInfo();
        }
        System.out.println("\n");
    }
}

class ShowInfo {
    Scanner scanner=new Scanner (System.in);

    private static double calculateTotalSalary(ArrayList<Employee> employees) // manager + developer + salesAggent
    {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculatePay();
        }
        return totalSalary;
    }

    private static void managerEnquiry(ArrayList<Manager> managers) {
        System.out.println("Manager Enquiry:");
        for (Manager manager : managers) {
            manager.displayInfo();
        }
        System.out.println("\n");
    }
    private static void developerEnquiry(ArrayList<Developer> developers) {
        System.out.println("Developer Enquiry:");
        for (Developer developer : developers) {
            developer.displayInfo();
        }
        System.out.println("\n");
    }
    private static void SalesAgentEnquiry(ArrayList<SalesAgent> SalesAgents) {
        System.out.println("SalesAgent Enquiry:");
        for (SalesAgent SalesAgent : SalesAgents) {
            SalesAgent.displayInfo();
        }
        System.out.println("\n");
    }

    public static void showInfo(ArrayList<Manager> managers, ArrayList<Developer> developers, ArrayList<SalesAgent> SalesAgents, double totalRevenue) throws IOException {
        // printing details of each employee
        managerEnquiry(managers);
        developerEnquiry(developers);
        SalesAgentEnquiry(SalesAgents); 
        
        System.out.println("Total Revenue of company : " + totalRevenue);
        double totalSalary = calculateTotalSalary(concatenateLists(managers, developers, SalesAgents));
        double remainingRevenue = totalRevenue- totalSalary;
        if(remainingRevenue<0)
            System.out.println("In loss,  revenue :"+ remainingRevenue);
        else 
            System.out.println("remaining revenue :"+ remainingRevenue);
        
        // file handle code starts 
        {
            ArrayList<Employee> employees = concatenateLists(managers, developers, SalesAgents);
            FileWriter fw = new FileWriter("/home/himanshukakkar/MySirG/project/PayrollSystem.txt");
            BufferedWriter bf = new BufferedWriter(fw);
            for (Employee emp : employees) {
                System.out.println("for each loop working\n");
                bf.write("Name: "+emp.name + "  ID: "+emp.id+"    Salary: "+emp.salary+"\n");
            }
            bf.close();
        }    
    }

    private static ArrayList<Employee> concatenateLists(ArrayList<Manager> managers, ArrayList<Developer> developers, ArrayList<SalesAgent> SalesAgents) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(managers);
        employees.addAll(developers);
        employees.addAll(SalesAgents);
        return employees;
    }
}

public class PayrollSystem {
    private static double totalAnnualRevenue;
    static Employee emp=new Employee("xyz",00,00);

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String temp="";
        do{    
            do{
                    System.out.print("Enter total annual revenue of the company: ");
                    temp= scanner.nextLine();             
            }while( emp.StringException(temp));
                totalAnnualRevenue=Double.parseDouble(temp);
        }while(totalAnnualRevenue<0);
    

        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Developer> developers = new ArrayList<>();
        ArrayList<SalesAgent> SalesAgents = new ArrayList<>();

        while (true) {
            
            int choice;
            String tempChoice;
        try{
            do{
                System.out.println("\nChoose an option:");
                System.out.println("1. Manager Operations");
                System.out.println("2. Developer Operations");
                System.out.println("3. SalesAgent Operations");
                System.out.println("4. Show complete Info");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                tempChoice= scanner.nextLine();
            }while(emp.StringException(tempChoice));

            choice= Integer.parseInt(tempChoice);
        }
        catch(NumberFormatException e) //no input
        {
            System.out.println("\nEnter a valid choice\n");
            continue;
        }

            switch (choice) {
                case 1:
                    managerOperations(managers, scanner);
                    break;
                case 2:
                    developerOperations(developers, scanner);
                    break;
                case 3:
                    SalesAgentOperations(SalesAgents, scanner);
                    break;
                case 4:
                {
                    try{
                    ShowInfo.showInfo(managers, developers, SalesAgents, totalAnnualRevenue);
                    }
                    catch(IOException e)
                    { 
                        System.out.println("\nFile Handling Exception\n");
                    }
                    break;
                }
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
        
    }


    private static void managerOperations(ArrayList<Manager> managers, Scanner scanner) {
        while (true) {
            int choice;
            String tempChoice;
            try{
                do{
                    System.out.println("\nManager Operations:");
                    System.out.println("1. Add Manager");
                    System.out.println("2. Remove Manager");
                    System.out.println("3. Manager Enquiry");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    tempChoice = scanner.nextLine();
                }while(emp.StringException(tempChoice));

                choice= Integer.parseInt(tempChoice);
            }
            catch(NumberFormatException e)
            {
                System.out.println("\nEnter a valid choice\n");
                continue;   
            }

            switch (choice) {
                case 1:
                    Manager.addManager(managers, scanner);
                    break;
                case 2:
                    Manager.removeManager(managers, scanner);
                    break;
                case 3:
                    Manager.managerEnquiry(managers);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void developerOperations(ArrayList<Developer> developers, Scanner scanner) {
        while (true) {
            int choice;
            String tempChoice;
            try{
                do{
                    System.out.println("\nDeveloper Operations:");
                    System.out.println("1. Add Developer");
                    System.out.println("2. Remove Developer");
                    System.out.println("3. Developer Enquiry");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    tempChoice =scanner.nextLine();
                }while(emp.StringException(tempChoice));
                choice = Integer.parseInt(tempChoice);
            }
            catch(NumberFormatException e)
            {
                System.out.println("\nEnter a valid Chice");
                continue;
            } 

            switch (choice) {
                case 1:
                    Developer.addDeveloper(developers, scanner);
                    break;
                case 2:
                    Developer.removeDeveloper(developers, scanner);
                    break;
                case 3:
                    Developer.developerEnquiry(developers);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void SalesAgentOperations(ArrayList<SalesAgent> SalesAgents, Scanner scanner) {
        while (true) {
            int choice;
            String tempChoice;
            try{
                do{
                    System.out.println("\nSalesAgent Operations:");
                    System.out.println("1. Add SalesAgent");
                    System.out.println("2. Remove SalesAgent");
                    System.out.println("3. SalesAgent Enquiry");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    tempChoice =scanner.nextLine();
                }while(emp.StringException(tempChoice));
                choice = Integer.parseInt(tempChoice);
            }
            catch(NumberFormatException e)
            {
                System.out.println("\nEnter a valid Chice");
                continue;
            } 

            switch (choice) {
                case 1:
                    SalesAgent.addSalesAgent(SalesAgents, scanner);
                    break;
                case 2:
                    SalesAgent.removeSalesAgent(SalesAgents, scanner);
                    break;
                case 3:
                    SalesAgent.SalesAgentEnquiry(SalesAgents);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

}
