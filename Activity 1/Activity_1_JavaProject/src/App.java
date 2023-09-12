import worker.Date;
import worker.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        
        Employee james_bond = new Employee(
            "James Bond", 
            100000, 
            new Date(9, 17, 2023)
        );

        System.out.println(james_bond.printEmployee());

    }
}
