package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.EmployeeBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.EmployeeDAO;
import lk.ijse.futureapez.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public ObservableList<EmployeeDTO> loadEmployee() throws SQLException, ClassNotFoundException {
        ObservableList<Employee> employees=employeeDAO.loadEmployee ();
        ObservableList<EmployeeDTO> employeeDTOS= FXCollections.observableArrayList ();

        for (Employee e : employees) {
            employeeDTOS.add (new EmployeeDTO (e.getEmpId (),e.getEmpName (),e.getAddress (),e.getNic (),e.getJobRole (),e.getContact ()));
        }
        return  employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployeeDetail(String empId) throws SQLException, ClassNotFoundException {
        Employee e = employeeDAO.getEmployeeDetail (empId);
        return new EmployeeDTO (e.getEmpId (),e.getEmpName (),e.getAddress (),e.getNic (),e.getJobRole (),e.getContact ());
    }

    @Override
    public ObservableList<String> getEmpIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> empId=employeeDAO.getEmpIds ();
        return empId;
    }

    @Override
    public EmployeeDTO getEmpName(String empId) throws SQLException, ClassNotFoundException {
        Employee e = employeeDAO.getEmpName (empId);
        return new EmployeeDTO (e.getEmpId (),e.getEmpName (),e.getAddress (),e.getNic (),e.getJobRole (),e.getContact ());
    }

    @Override
    public ObservableList<Course> loadTeacher() throws SQLException, ClassNotFoundException {
        ObservableList<Course> allTeacher= employeeDAO.loadTeacher ();
        return allTeacher;
    }

    @Override
    public int getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeCount ();
    }

    @Override
    public int geteacherCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.geteacherCount ();
    }

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.add (new Employee(dto.getEmpId (),dto.getEmpName (),dto.getAddress (),dto.getNic (),dto.getJobRole (),dto.getContact ()));

    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update (new Employee(dto.getEmpId (),dto.getEmpName (),dto.getAddress (),dto.getNic (),dto.getJobRole (),dto.getContact ()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete (id);
    }
}
