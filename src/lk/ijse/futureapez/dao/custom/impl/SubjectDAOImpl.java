package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.SubjectDAO;
import lk.ijse.futureapez.entity.Subject;
import lk.ijse.futureapez.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDAOImpl implements SubjectDAO {
    public ObservableList searchSubject(String courseId) throws SQLException, ClassNotFoundException {
        String sql="select * from subject where courseId=? ";
        ResultSet result=CrudUtil.execute(sql,courseId);

        ObservableList list= FXCollections.observableArrayList();

        while (result.next()){
            list.add(new Subject(result.getString(1),result.getString(2),result.getString(3)));
        }
        return list;
    }

    @Override
    public boolean add(Subject subject) throws SQLException, ClassNotFoundException {
        String sql="insert into subject values(?,?,?)";
        return CrudUtil.execute(sql,subject.getSubjectId(),subject.getSubjectName(),subject.getCourseId());

    }
    @Override
    public boolean update(Subject subject) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  boolean delete(String subjectId) throws SQLException, ClassNotFoundException {
        String sql="delete from subject where sId=?";
        return CrudUtil.execute(sql,subjectId);
    }
}
