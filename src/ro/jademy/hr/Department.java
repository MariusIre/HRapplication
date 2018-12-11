package ro.jademy.hr;

import java.util.List;
import java.util.Objects;

public class Department {

    private java.lang.String deptNo;                  //fixed value of 4
    private java.lang.String deptName;                //40 max chars
    private List<Employee> employeesList;

    public Department(java.lang.String deptNo, java.lang.String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public java.lang.String getDeptNo() {
        return deptNo;
    }

    public java.lang.String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void addEmployeeToDepartment(Employee e) {
        employeesList.add(e);
    }

    public Employee getEmployee(Employee e) {
        return employeesList.stream().filter(employee -> employee.equals(e)).findFirst().orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptNo.equals(that.deptNo) &&
                deptName.equals(that.deptName) &&
                employeesList.equals(that.employeesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, deptName, employeesList);
    }

    @Override
    public java.lang.String toString() {
        return "ro.jademy.hr.Department{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                ", employeesList=" + employeesList +
                '}';
    }
}
