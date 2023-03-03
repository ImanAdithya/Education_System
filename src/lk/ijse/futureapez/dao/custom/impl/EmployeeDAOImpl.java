package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.EmployeeDAO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Employee;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public  boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        String sql="insert into employee values(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,employee.getEmpId(),employee.getEmpName(),employee.getAddress(),employee.getNic(),employee.getJobRole(),employee.getContact());
    }
    @Override
    public  boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql="update employee set eName=?,eAddress=?,eNic=?,eRole=?,eContact=? where eId=?";
        return CrudUtil.execute(sql,employee.getEmpName(),employee.getAddress(),employee.getNic(),employee.getJobRole(),employee.getContact(),employee.getEmpId());
    }
    @Override
    public  boolean delete(String teacherId) throws SQLException, ClassNotFoundException {
        String sql="delete from employee where eId=?";
        return CrudUtil.execute(sql,teacherId);
    }

    @Override
    public ObservableList loadEmployee() throws SQLException, ClassNotFoundException {
        String sql="select * from employee";
        ResultSet result=CrudUtil.execute(sql);

        ObservableList listTeacher= FXCollections.observableArrayList();

        while (result.next()){
            listTeacher.add(new Employee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)));
        }
        return listTeacher;
    }

    @Override
    public Employee getEmployeeDetail(String empId) throws SQLException, ClassNotFoundException {
        String sql="select * from employee where eId=?";
        ResultSet result=CrudUtil.execute(sql,empId);

        while (result.next()){
            return new Employee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
        }
        return null;
    }


    public  ObservableList getEmpIds() throws SQLException, ClassNotFoundException {
        String sql="select eId from employee";
        ResultSet result= CrudUtil.execute(sql);

        ObservableList list= FXCollections.observableArrayList();
        while (result.next()){
            list.add(result.getString(1));
        }
        return list;
    }

    public  Employee getEmpName(String empId) throws SQLException, ClassNotFoundException {
        String sql="select * from employee where eId=?";
        ResultSet result=CrudUtil.execute(sql,empId);

        while (result.next()){
            return new Employee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
        }
        return null;
    }

    public  ObservableList<Course>loadTeacher() throws SQLException, ClassNotFoundException {
        String sql="select eName from employee where eRole='Teacher'";
        ResultSet result=CrudUtil.execute(sql);

        ObservableList list= FXCollections.observableArrayList();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;

    }
    public int geteacherCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from employee where eRole='Teacher' ";
        ResultSet resultSet= CrudUtil.execute(sql);


        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }

    public int getEmployeeCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from employee where eRole='Worker' ";
        ResultSet resultSet= CrudUtil.execute(sql);


        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }



}
