package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Salary;

import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<Salary> {
    ObservableList loadSalaryDetail(String empId) throws SQLException, ClassNotFoundException;
    Salary loadAllSalary(String salaryId) throws SQLException, ClassNotFoundException;
}
