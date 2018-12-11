package ro.jademy.hr;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Salary {

    private BigDecimal salary;
    private Date fromDate;
    private Date toDate;

    public Salary(BigDecimal salary, Date fromDate, Date toDate) {
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary1 = (Salary) o;
        return Objects.equals(salary, salary1.salary) &&
                Objects.equals(fromDate, salary1.fromDate) &&
                Objects.equals(toDate, salary1.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, fromDate, toDate);
    }

    @Override
    public String toString() {
        return " salary=" + salary +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
