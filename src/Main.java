package Employee_management_System;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println("\n================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(
                            name,
                            email,
                            phone,
                            department,
                            	salary
                    );

                    employeeDAO.addEmployee(employee);

                    break;


                case 2:

                    List<Employee> employees =
                            employeeDAO.getAllEmployees();

                    System.out.println("\nID | NAME | EMAIL | PHONE | DEPARTMENT | SALARY");

                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }

                    break;


                case 3:

                    System.out.print("Enter Employee ID: ");

                    int searchId = scanner.nextInt();

                    Employee foundEmployee =
                            employeeDAO.getEmployeeById(searchId);

                    if (foundEmployee != null) {
                        System.out.println(foundEmployee);
                    } else {
                        System.out.println("Employee not found!");
                    }

                    break;


                case 4:

                    System.out.print("Enter Employee ID: ");

                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();

                    Employee updatedEmployee =
                            new Employee(
                                    updateId,
                                    newName,
                                    newEmail,
                                    newPhone,
                                    newDepartment,
                                    newSalary
                            );

                    employeeDAO.updateEmployee(updatedEmployee);

                    break;


                case 5:

                    System.out.print("Enter Employee ID: ");

                    int deleteId = scanner.nextInt();

                    employeeDAO.deleteEmployee(deleteId);

                    break;


                case 6:

                    System.out.println(
                            "Thank you for using Employee Management System!"
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println("Invalid choice!");

            }
        }
    }
}
