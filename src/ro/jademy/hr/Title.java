package ro.jademy.hr;

import java.sql.Date;
import java.util.Objects;

public class Title {

    private String title;
    private String department;
    private Date fromDate;
    private Date toDate;

    public Title(String title, String department, Date fromDate, Date toDate) {
        this.title = title;
        this.department = department;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
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
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title) &&
                Objects.equals(department, title1.department) &&
                Objects.equals(fromDate, title1.fromDate) &&
                Objects.equals(toDate, title1.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, department, fromDate, toDate);
    }

    @Override
    public java.lang.String toString() {
        return " title='" + title + '\'' +
                ", department=" + department +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
