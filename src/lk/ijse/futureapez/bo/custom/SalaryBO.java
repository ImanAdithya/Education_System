package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.dto.SalaryDTO;
import lk.ijse.futureapez.entity.Employee;
import lk.ijse.futureapez.entity.Salary;

import java.sql.SQLException;

public interface SalaryBO  extends SuperBO {
    ObservableList loadSalaryDetail(String empId) throws SQLException, ClassNotFoundException;
    Salary loadAllSalary(String salaryId) throws SQLException, ClassNotFoundException;
    boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteSalary(String id)throws SQLException, ClassNotFoundException ;
    ObservableList<String> getEmpIds() throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmpName(String empId) throws SQLException, ClassNotFoundException;


}
