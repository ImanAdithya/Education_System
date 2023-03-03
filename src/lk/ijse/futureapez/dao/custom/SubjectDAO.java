package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Subject;

import java.sql.SQLException;

public interface SubjectDAO  extends CrudDAO<Subject> {
     ObservableList searchSubject(String courseId) throws SQLException, ClassNotFoundException;
}
