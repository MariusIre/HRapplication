package ro.jademy.hr.repository;

import ro.jademy.hr.Employee;
import ro.jademy.hr.Genders;
import ro.jademy.hr.Salary;
import ro.jademy.hr.Title;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public static List<Employee> getEmployees(Connection sqlConnection)  {
        try {
            List<Employee> employeeList = new ArrayList<>();
            Statement getBasicInfo = sqlConnection.createStatement();
            Statement getExtraInfo = sqlConnection.createStatement();
            String basicInfoQuerry = ("Select emp_no as empNo,birth_date as birthDate,first_name as firstName," +
                    "last_name as lastName,gender,hire_date as hireDate from employees;");
            ResultSet basicInfoResults = getBasicInfo.executeQuery(basicInfoQuerry);
            while (basicInfoResults.next()) {
                int empNo = basicInfoResults.getInt("empNo");
                String firstName = basicInfoResults.getString("firstName");
                String lastName = basicInfoResults.getString("lastName");
                Date birthDate = basicInfoResults.getDate("birthDate");
                Genders gender = Genders.valueOf(basicInfoResults.getString("gender"));
                Date hireDate = basicInfoResults.getDate("hireDate");
                List<Salary> salaries = new ArrayList<>();
                List<Title> titles = new ArrayList<>();
                String salaryQuerry = ("SELECT s.salary as salary,s.from_date as fromDate,s.to_date as toDate FROM salaries s JOIN employees e on s.emp_no = e.emp_no where e.first_name = '" + firstName + "' AND e.last_name = '" + lastName + "';");
                ResultSet salaryResults = getExtraInfo.executeQuery(salaryQuerry);
                while (salaryResults.next()) {
                    int salary = salaryResults.getInt("salary");
                    Date fromDate = salaryResults.getDate("fromDate");
                    Date toDate = salaryResults.getDate("toDate");
                    Salary addSalary = new Salary(new BigDecimal(salary), fromDate, toDate);
                    salaries.add(addSalary);
                }
                String titleQuerry = ("SELECT t.title as title,d.dept_name as department ,t.from_date as fromDate,t.to_date as toDate FROM titles t JOIN employees e on t.emp_no = e.emp_no JOIN dept_emp de on de.emp_no = e.emp_no JOIN departments d on d.dept_no = de.dept_no where e.first_name = '" + firstName + "' AND e.last_name = '" + lastName + "' order by t.to_date;");
                ResultSet titleResults = getExtraInfo.executeQuery(titleQuerry);
                String curentDept = "";
                while (titleResults.next()) {
                    String title = titleResults.getString("title");
                    String department = titleResults.getString("department");
                    Date fromDate = titleResults.getDate("fromDate");
                    Date toDate = titleResults.getDate("toDate");
                    Title addTitle = new Title(title, department, fromDate, toDate);
                    titles.add(addTitle);
                    curentDept = department;
                }
                employeeList.add(new Employee(empNo, curentDept, firstName, lastName, birthDate, gender, hireDate, titles, salaries));
            }
            return employeeList;
        }catch(SQLException e) {
            System.out.println("Employee retrieving from database failed.");
        }
        return new ArrayList<Employee>();
    }
}
