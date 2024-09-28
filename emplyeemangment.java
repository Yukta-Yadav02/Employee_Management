
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  

class Employee {
    private int id;
   private String name;
   private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + "," + name + "," + salary;
    }
}
class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        loadEmployees();
    }


    public void addEmployee(int id, String name, int salary) {
        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        saveEmployees();
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee(int id) {
        Scanner sc = new Scanner(System.in);
        boolean employeeFound = false;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employeeFound = true;
                System.out.println("Choose what to update:");
                System.out.println("1: Name");
                System.out.println("2: Salary");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter new employee name: ");
                    String name = sc.next();
                    emp.setName(name);
                    saveEmployees();
                    System.out.println("Employee name updated successfully");
                } else if (choice == 2) {
                    System.out.print("Enter new employee salary: ");
                    int salary = sc.nextInt();
                    emp.setSalary(salary);
                    saveEmployees();
                    System.out.println("Employee salary updated successfully");
                } else {
                    System.out.println("Invalid choice");
                    return;
                }
            }
        }

        if (!employeeFound) {
            System.out.println("Employee with ID " + id + " not found");
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
        saveEmployees();
        System.out.println("Employee deleted successfully");
    }

    public void displayAllEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private void loadEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 3) {
                    int id = Integer.parseInt(p[0]);
                    String name = p[1];
                    int salary = Integer.parseInt(p[2]);
                    employees.add(new Employee(id, name, salary));
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees) {
                bw.write(emp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public  class emplyeemangment{
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    int salary = scanner.nextInt();
                    ems.addEmployee(id, name, salary);
                    break;
                case 2:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    ems.updateEmployee(updateId);
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.deleteEmployee(deleteId);

                    break;
                case 4:
                    System.out.println("All Employees:");
                    ems.displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }

        
    }

}
