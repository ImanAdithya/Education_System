package lk.ijse.futureapez.dao.custom.impl;

import lk.ijse.futureapez.dao.custom.CreateAccDAO;
import lk.ijse.futureapez.entity.CreateAccount;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.SQLException;

public class CreateAccImpl implements CreateAccDAO {
    @Override
    public boolean add(CreateAccount createAccount) throws SQLException, ClassNotFoundException {
        String sql="insert into user values(?,?,?)";
        return CrudUtil.execute(sql,createAccount.getUserName(),createAccount.getPassword(),createAccount.getEmail());
    }

    @Override
    public boolean update(CreateAccount entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
