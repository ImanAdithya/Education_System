package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.SalaryDAO;
import lk.ijse.futureapez.entity.Salary;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryDAOImpl implements SalaryDAO {

    public boolean add(Salary salary) throws SQLException, ClassNotFoundException {
        String sql="Insert into salary values(?,?,?,?,?)";
        return  CrudUtil.execute(sql,salary.getSalaryId(),salary.getEmpId(),salary.getEmpName(),salary.getAmount(),salary.getDate());
    }

    public  ObservableList loadSalaryDetail(String empId) throws SQLException, ClassNotFoundException {
        String sql="select * from salary where eId=?";
        ResultSet result=CrudUtil.execute(sql,empId);

        ObservableList list=FXCollections.observableArrayList();

        while (result.next()){
            list.add(new Salary(result.getString(1),result.getString(2),result.getString(3),result.getDouble(4),result.getString(5)));
        }

        return list;
    }

    public  Salary loadAllSalary(String salaryId) throws SQLException, ClassNotFoundException {
        String sql="select * from salary where salaryId=? ";
        ResultSet resultSet=CrudUtil.execute(sql,salaryId);

        while (resultSet.next()){
            return new Salary(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5));
        }

        return null;

    }

    public  boolean update(Salary salary) throws SQLException, ClassNotFoundException {
        String sql="update salary set eId=?,eName=?,sAmount=?,date=? where salaryId=?";
        return CrudUtil.execute(sql,salary.getEmpId(),salary.getEmpName(),salary.getAmount(),salary.getDate(),salary.getSalaryId());
    }

    public  boolean delete(String salaryId) throws SQLException, ClassNotFoundException {
        String sql="delete from salary where salaryId=?";
        return CrudUtil.execute(sql,salaryId);
    }
}
