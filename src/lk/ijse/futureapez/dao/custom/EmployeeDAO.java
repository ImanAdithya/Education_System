package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee> {

    ObservableList loadEmployee() throws SQLException, ClassNotFoundException;
    Employee getEmployeeDetail(String empId) throws SQLException, ClassNotFoundException;
    ObservableList getEmpIds() throws SQLException, ClassNotFoundException;
    Employee getEmpName(String empId) throws SQLException, ClassNotFoundException;
    ObservableList<Course>loadTeacher() throws SQLException, ClassNotFoundException;
    int getEmployeeCount() throws SQLException, ClassNotFoundException;
    int geteacherCount() throws SQLException, ClassNotFoundException;
}
