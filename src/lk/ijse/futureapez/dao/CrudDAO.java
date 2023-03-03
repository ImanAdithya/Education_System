package lk.ijse.futureapez.dao;

import lk.ijse.futureapez.dao.custom.SuperDAO;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {
    boolean add(T entity) throws SQLException, ClassNotFoundException;
    boolean update(T entity) throws SQLException, ClassNotFoundException;
    boolean delete(String id)throws SQLException, ClassNotFoundException ;


}
