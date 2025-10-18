import entity.Employee;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Employee employee = new Employee(1001,"Gaurav Gimonkar","CSE",76000);
        Employee employee1 = new Employee(1002,"Harshal Dabhade","EE",89000);
        Employee employee2= new Employee(1003,"Mohit Dhote","EXTC",97000);
        Employee employee3 = new Employee(1004,"Yuvraj Kothe","CSE",90000);
        Employee employee4 = new Employee(1005,"Suraj Manale","EE",91000);

        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);




        char cont = 'n';
        do {
            System.out.println("""
                -------- EMPLOYEE MANAGEMENT SYSTEM ------------
                    1. Add New Employee.
                    2. Show All Employees.
                    3. show Employee with ID.
                    4. Update Employee.
                    5. Delete employee by ID.
                -------------------------------------------------
                 Select The option to perform Operation
                """);
            int optionInput = sc.nextInt();
            switch(optionInput) {
                case 1:
                    if ((createNewEmployee())) {
                        System.out.println("Employee Created Successfully ! ");
                    } else {
                        System.out.println("Some thing wrong...");
                    }
                    break;
                case 2:
                    System.out.println("Option 2");
                    showAllEmployees();
                    break;
                case 3:
                    if(!serachEmployeeById()){
                        System.out.println("Employee with id : not exist.");
                    }
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployeeById();
                    break;
                default:
                    System.out.println("Invalid option seletion");

            }
            System.out.println();
            System.out.println("Enter 'y' to continue. Press Other any key to Exit.");
            cont = sc.next().charAt(0);

        }while (cont == 'y' || cont == 'Y');

    }

    public static boolean createNewEmployee(){
        System.out.println("Enter the new Id for Employee");
        int employeeId=sc.nextInt();
        System.out.println("Enter the name of employee");
        String name = sc.nextLine();
        name = sc.nextLine();
        System.out.println("Enter the department");
        String department = sc.nextLine();
        System.out.println("Enter the salary");
        double salary = sc.nextDouble();
        try {
        Employee employee = new Employee(employeeId,name,department,salary);
        employees.add(employee);

        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static void showAllEmployees(){
        System.out.println("I am in show list");
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static boolean serachEmployeeById(){
        System.out.println("Enter the Employee ID");
        int idToSerach = sc.nextInt();
        ListIterator<Employee> itr = employees.listIterator();
        while (itr.hasNext()){
            Employee e = itr.next();
            if(e.getEmployeeId()==idToSerach){
                System.out.println(e);
                return true;
            }
        }

        return false;
    }

    public static Employee serachEmployeeByIdGiveEmployee(int id){
        ListIterator<Employee> itr = employees.listIterator();
        while (itr.hasNext()){
            Employee e = itr.next();
            if(e.getEmployeeId()==id){
                System.out.println(e);
                return e;
            }
        }
        return null;
    }

    public static boolean updateEmployee(){
        System.out.println("Enter Employee id to Update");
        int updationId = sc.nextInt();
        Employee employee = serachEmployeeByIdGiveEmployee(updationId);
        if(employee== null){
            return false;
        }
        System.out.println("what exactly you want to update");
        System.out.println("""
                1. update id.
                2. update name.
                3. update department.
                4. update salary
                
                Select Operation by entering option number
                
                """);
        int option=sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Enter new ID");
                int newId = sc.nextInt();
                employees.remove(employee);
                employee.setEmployeeId(newId);
                employees.add(employee);
                System.out.println("id updated ");
                return true;
            case 2:
                System.out.println("Enter correct name");
                String updatedName= sc.nextLine();
                updatedName= sc.nextLine();
                employees.remove(employee);
                employee.setEmployeeName(updatedName);
                employees.add(employee);
                System.out.println("Name updated ");
                return true;
            case 3:
                System.out.println("Enter new department name");
                String newDepartmentName = sc.nextLine();
                newDepartmentName = sc.nextLine();
                employees.remove(employee);
                employee.setDepartment(newDepartmentName);
                employees.add(employee);
                System.out.println("Department updated");
                return true;
            case 4:
                System.out.println("Enter Updated salary. ");
                double newSalary = sc.nextDouble();
                employees.remove(employee);
                employee.setSalary(newSalary);
                employees.add(employee);
                System.out.println("Salary updated");
                return true;


        }
        return false;
    }

    public static boolean deleteEmployeeById(){
        System.out.println("Enter employee id to delete");
        int employeeIdToDelete = sc.nextInt();
        Employee employee = serachEmployeeByIdGiveEmployee(employeeIdToDelete);
        if( employee== null){
            System.out.println("Employee with "+ employeeIdToDelete+" is not in database");
            return false;
        }else {
            employees.remove(employee);
            System.out.println("Employee : "+ employee+" removed from database ");
            return true;
        }
    }

}