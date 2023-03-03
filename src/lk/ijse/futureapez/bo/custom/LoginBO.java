package lk.ijse.futureapez.bo.custom;

import lk.ijse.futureapez.bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    boolean getUserDetail(String username,String pass) throws SQLException, ClassNotFoundException;
    int getUser(String username, String pass) throws SQLException, ClassNotFoundException;
}
