package ro.jademy.hr;

import java.util.ArrayList;
import java.util.List;

public class HRApp {

    private List<Department> departments;

    public HRApp(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> searchEmployee(java.lang.String abc) {
        List<Employee> foundEmployees = new ArrayList<>();
        for(Department department : departments) {
            for(Employee employee : department.getEmployeesList()) {
                if(employee.getFirstName().contains(abc) || employee.getLastName().contains(abc)) {
                    foundEmployees.add(employee);
                }
            }
        }
        return foundEmployees;
    }
}
