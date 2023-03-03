package lk.ijse.futureapez.dao.custom;

import java.sql.SQLException;

public interface LoginDAO extends SuperDAO{
    boolean getUserDetail(String username,String pass) throws SQLException, ClassNotFoundException;
    int getUser(String username, String pass) throws SQLException, ClassNotFoundException;
}
