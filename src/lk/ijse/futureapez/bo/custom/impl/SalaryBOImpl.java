package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.SalaryBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.EmployeeDAO;
import lk.ijse.futureapez.dao.custom.SalaryDAO;
import lk.ijse.futureapez.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.dto.SalaryDTO;
import lk.ijse.futureapez.entity.Employee;
import lk.ijse.futureapez.entity.Salary;
import rex.utils.S;

import java.sql.SQLException;

public class SalaryBOImpl implements SalaryBO {

    //SalaryDAO salaryDAO=new SalaryDAOImpl ();
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public ObservableList loadSalaryDetail(String empId) throws SQLException, ClassNotFoundException {
        ObservableList list=salaryDAO.loadSalaryDetail (empId);
        return list;
    }

    @Override
    public Salary loadAllSalary(String salaryId) throws SQLException, ClassNotFoundException {
        return salaryDAO.loadAllSalary (salaryId);
    }

    @Override
    public boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.add (new Salary (dto.getSalaryId (),dto.getEmpId (),dto.getEmpName (),dto.getAmount (),dto.getDate ()));
    }

    @Override
    public boolean updateSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update (new Salary (dto.getSalaryId (),dto.getEmpId (),dto.getEmpName (),dto.getAmount (),dto.getDate ()));
    }

    @Override
    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException {
        return salaryDAO.delete (id);
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


}
