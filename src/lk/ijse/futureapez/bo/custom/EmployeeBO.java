package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Employee;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    ObservableList loadEmployee() throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmployeeDetail(String empId) throws SQLException, ClassNotFoundException;
    ObservableList getEmpIds() throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmpName(String empId) throws SQLException, ClassNotFoundException;
    ObservableList<Course>loadTeacher() throws SQLException, ClassNotFoundException;
    int getEmployeeCount() throws SQLException, ClassNotFoundException;
    int geteacherCount() throws SQLException, ClassNotFoundException;
    boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id)throws SQLException, ClassNotFoundException ;

}
