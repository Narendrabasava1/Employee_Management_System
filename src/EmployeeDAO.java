package Employee_management_System;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees " +
                "(name, email, phone, department, salary) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getDepartment());
            statement.setDouble(5, employee.getSalary());

            statement.executeUpdate();

            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // VIEW ALL EMPLOYEES
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    // SEARCH EMPLOYEE
    public Employee getEmployeeById(int employeeId) {

        String sql =
                "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // UPDATE EMPLOYEE
    public void updateEmployee(Employee employee) {

        String sql = "UPDATE employees SET " +
                "name = ?, email = ?, phone = ?, " +
                "department = ?, salary = ? " +
                "WHERE employee_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getDepartment());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getEmployeeId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE EMPLOYEE
    public void deleteEmployee(int employeeId) {

        String sql =
                "DELETE FROM employees WHERE employee_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}