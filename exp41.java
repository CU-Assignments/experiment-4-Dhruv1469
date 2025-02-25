import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class exp41 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added.");
                    break;
                
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            System.out.print("Enter New Name: ");
                            scanner.nextLine(); 
                            emp.name = scanner.nextLine();
                            System.out.print("Enter New Salary: ");
                            emp.salary = scanner.nextDouble();
                            System.out.println("Employee updated.");
                            break;
                        }
                    }
                    break;
                
                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    employees.removeIf(emp -> emp.id == removeId);
                    System.out.println("Employee removed.");
                    break;
                
                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println(emp);
                            break;
                        }
                    }
                    break;
                
                case 5:
                    System.out.println("\nEmployee List:");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;
                
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
