/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author khadk
 */
public class Employee {
    private final String empId;
    private final String fullName;
    private final String department;
    private final double salary;

    // Keep your existing constructor and getters...
    public Employee(String empId, String fullName, String department, double salary) {
        this.empId = empId;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public static LinkedList<Employee> getInitialData() {
     LinkedList<Employee> list = new LinkedList<>();
  
    list.add(new Employee("E001", "Khadka Admin", "Management", 95000.0));
    list.add(new Employee("E002", "Sita Sharma", "Sales", 45000.0));
    list.add(new Employee("E003", "Ram Bahadur", "Maintenance", 35000.0));
    list.add(new Employee("E004", "Gita Thapa", "Reception", 40000.0));
    list.add(new Employee("E005", "Hari Prasad", "Security", 30000.0));
    list.add(new Employee("E006", "Maya Devi", "Accounting", 55000.0));
    list.add(new Employee("E007", "Rohan Das", "IT Support", 48000.0));
    list.add(new Employee("E008", "Sunita Williams", "Marketing", 52000.0));
    list.add(new Employee("E009", "Binod Kumar", "Logistics", 38000.0));
    list.add(new Employee("E010", "Anjali Rai", "Human Resources", 60000.0));
    list.add(new Employee("E011", "Kiran Shah", "Inventory", 32000.0));
    list.add(new Employee("E012", "Pooja Hegde", "Customer Service", 41000.0));
    
    return list;
    }

    public String getEmpId() { return empId; }
    public String getFullName() { return fullName; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}
