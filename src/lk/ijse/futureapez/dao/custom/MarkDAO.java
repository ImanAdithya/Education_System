package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Mark;

import java.sql.SQLException;

public interface MarkDAO extends CrudDAO<Mark> {
    ObservableList getMarksDetails(String stId) throws SQLException, ClassNotFoundException;
}
