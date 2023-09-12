import worker.Date;
import worker.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Date james_bond_hire_date = new Date(9, 17, 2023);
        Employee james_bond = new Employee(
            "James Bond", 
            100000, 
            james_bond_hire_date
        );

        System.out.println(james_bond.printEmployee());

    }
}
