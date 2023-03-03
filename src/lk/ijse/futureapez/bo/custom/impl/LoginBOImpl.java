package lk.ijse.futureapez.bo.custom.impl;

import lk.ijse.futureapez.bo.custom.LoginBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.LoginDAO;
import lk.ijse.futureapez.dao.custom.impl.LoginDAOImpl;
import org.jfree.util.Log;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {

    //LoginDAO loginDAO=new LoginDAOImpl ();
    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGIN);
    @Override
    public boolean getUserDetail(String username, String pass) throws SQLException, ClassNotFoundException {
        return loginDAO.getUserDetail (username,pass);
    }

    @Override
    public int getUser(String username, String pass) throws SQLException, ClassNotFoundException {
        return loginDAO.getUser (username,pass);
    }
}
