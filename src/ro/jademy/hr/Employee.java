package ro.jademy.hr;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Employee {

    private int id;
    private String department;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private Date birthDate;
    private Genders gender;
    private Date hireDate;
    private List<Title> titles;
    private List<Salary> salaries;

    public Employee(int id, String department, java.lang.String firstName, java.lang.String lastName, Date birthDate, Genders gender, Date hireDate, List<Title> titles, List<Salary> salaries) {
        this.id = id;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hireDate = hireDate;
        this.titles = titles;
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Genders getGender() {
        return gender;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public void addSalary(Salary salary) {
        salaries.add(salary);
    }

    public void addTitle(Title title) {
        titles.add(title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                gender == employee.gender &&
                Objects.equals(department, employee.department) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(hireDate,employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, firstName, lastName, birthDate, gender);
    }

    @Override
    public java.lang.String toString() {
        return "Employee{" +
                "id=" + id +
                ", department=" + department +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", titles=" + titles.get(titles.size() - 1) +
                ", salaries=" + salaries.get(salaries.size() - 1) +
                '}';
    }
}
