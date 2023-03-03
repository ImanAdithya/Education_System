package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Exam;

import java.sql.SQLException;

public interface ExamDAO extends CrudDAO<Exam> {
    ObservableList loadExam(String courseId) throws SQLException, ClassNotFoundException;
    Exam getExamdetail(String examId) throws SQLException, ClassNotFoundException;

    ObservableList loadExams(String courseId) throws SQLException, ClassNotFoundException;


}
