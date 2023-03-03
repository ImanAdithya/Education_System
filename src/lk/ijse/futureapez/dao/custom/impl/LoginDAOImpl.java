package lk.ijse.futureapez.dao.custom.impl;

import lk.ijse.futureapez.dao.custom.LoginDAO;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {
    public boolean getUserDetail(String username,String pass) throws SQLException, ClassNotFoundException {
        String sql = "select * from user where UserName=? AND Password=?";
        ResultSet resultSet = CrudUtil.execute(sql, username,pass);
/*
        while (resultSet.next()) {
            return new CreateAccount(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        }
        return null;*/
        boolean a=resultSet.next();

        if (a){
            return true;
        }
        return false;
    }

    public int getUser(String username, String pass) throws SQLException, ClassNotFoundException {
        String sql="select count(1) from user where UserName=? AND Password=?;";
        ResultSet resultSet=CrudUtil.execute(sql,username,pass);

        int i=1;

        while (resultSet.next()){
            if (resultSet.getInt(1)==i){
                return i;
            }
        }
        return Integer.parseInt(null);
    }

}
