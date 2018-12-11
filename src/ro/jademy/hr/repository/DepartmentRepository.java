package ro.jademy.hr.repository;

import ro.jademy.hr.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public static List<Department> getDepartments(Connection sqlConnection) throws SQLException {
        Statement st = sqlConnection.createStatement();
        java.lang.String sql = ("SELECT dept_no,dept_name FROM departments ORDER BY dept_no;");
        ResultSet rs = st.executeQuery(sql);
        List<Department> departmentList = new ArrayList<>();
        while(rs.next()) {
            java.lang.String deptNo = rs.getString("dept_no");
            java.lang.String deptName = rs.getString("dept_name");
            departmentList.add(new Department(deptNo,deptName));
        }
        return departmentList;
    }
}
