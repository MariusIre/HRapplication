package ro.jademy.hr;

import ro.jademy.hr.repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HRappTest {

    public static void main(java.lang.String[] args){
        Connection connection = getConnection();
        //connection.setAutoCommit(false);
        showEmployees(EmployeeRepository.getEmployees(connection));
    }


    public static void showDepartments(Connection connection) throws SQLException{
        Statement st = connection.createStatement();
        java.lang.String sql = ("SELECT dept_no,dept_name FROM departments ORDER BY dept_no;");
        ResultSet rs = st.executeQuery(sql);
        List<Department> departmentList = new ArrayList<>();
        while(rs.next()) {
            java.lang.String dept_no = rs.getString("dept_no");
            java.lang.String dept_name = rs.getString("dept_name");
            departmentList.add(new Department(dept_no,dept_name));
        }
        for(Department department : departmentList) {
            System.out.println(department.getDeptName() + " " + department.getDeptNo());
        }
    }

    public static void showEmployees(List<Employee> employees) {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static Connection getConnection(){
        java.lang.String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
        java.lang.String username = "root";
        java.lang.String password = "231231";

        System.out.println("Connecting database...");
        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
