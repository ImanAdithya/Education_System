package lk.ijse.futureapez.bo.custom;

import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.CreateAccountDTO;
import lk.ijse.futureapez.entity.CreateAccount;

import java.sql.SQLException;

public interface CreateAccBO extends SuperBO {
    boolean add(CreateAccountDTO createAccountDTO) throws SQLException, ClassNotFoundException;
}
