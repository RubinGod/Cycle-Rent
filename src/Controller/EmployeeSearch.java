package Controller;

import Model.Employee;
import java.util.List;

public class EmployeeSearch {
    public static Employee searchByName(List<Employee> list, String name) {
        for (Employee emp : list) {
            if (emp.getFullName().equalsIgnoreCase(name.trim())) {
                return emp;
            }
        }
        return null;
    }
}