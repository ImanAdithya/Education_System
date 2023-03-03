package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.ExamDAO;
import lk.ijse.futureapez.entity.Exam;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDAOImpl implements ExamDAO {
    @Override
    public boolean add(Exam exam) throws SQLException, ClassNotFoundException {
        String sql="insert into exam values(?,?,?)";
        return CrudUtil.execute(sql,exam.getExamId(),exam.getExamName(),exam.getCourseId());
    }

    @Override
    public boolean update(Exam entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String examId) throws SQLException, ClassNotFoundException {
        String sql="delete from exam where examId=?";
        return CrudUtil.execute(sql,examId);

    }

    public  ObservableList loadExam(String courseId) throws SQLException, ClassNotFoundException {
        String sql="select * from exam where courseId=?";
        ResultSet result=CrudUtil.execute(sql,courseId);

        ObservableList list= FXCollections.observableArrayList();

        while (result.next()){
            list.add(new Exam(result.getString(1),result.getString(2),result.getString(3)));
        }
        return list;

    }

    public  Exam getExamdetail(String examId) throws SQLException, ClassNotFoundException {
        String sql="select * from exam where examId=?";
        ResultSet resultSet=CrudUtil.execute(sql,examId);

        while (resultSet.next()){
            return  new Exam(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        return null;
    }
    public  ObservableList loadExams(String courseId) throws SQLException, ClassNotFoundException {
        String sql="select examId from exam where courseId=?";
        ResultSet result=CrudUtil.execute(sql,courseId);

        ObservableList list=FXCollections.observableArrayList();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;

    }



}
