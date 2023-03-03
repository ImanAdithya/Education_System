package lk.ijse.futureapez.bo.custom.impl;

import lk.ijse.futureapez.bo.custom.CreateAccBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CreateAccDAO;
import lk.ijse.futureapez.dao.custom.impl.CreateAccImpl;
import lk.ijse.futureapez.dto.CreateAccountDTO;
import lk.ijse.futureapez.entity.CreateAccount;

import java.sql.SQLException;

public class CreateAccBOImpl implements CreateAccBO {

    //CreateAccDAO createAccDAO=new CreateAccImpl ();
    CreateAccDAO createAccDAO = (CreateAccDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CREATE_ACC);
    @Override
    public boolean add(CreateAccountDTO dto) throws SQLException, ClassNotFoundException {
        return createAccDAO.add (new CreateAccount (dto.getUserName (),dto.getPassword (),dto.getEmail ()));
    }
}
