package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.MarkDAO;
import lk.ijse.futureapez.entity.Mark;
import lk.ijse.futureapez.util.CrudUtil;
import lk.ijse.futureapez.view.tm.MarkTm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkDAOImpl implements MarkDAO {
    @Override
    public boolean add(Mark mark) throws SQLException, ClassNotFoundException {
        String sql="insert into mark values(?,?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,mark.getMarkId(),mark.getStId(),mark.getStName(),mark.getBatch(),mark.getCourseId(),mark.getExamId(),mark.getExamName(),mark.getMark());
    }

    @Override
    public boolean update(Mark entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String markId) throws SQLException, ClassNotFoundException {
        String sql="delete from mark where markId=?";
        return CrudUtil.execute(sql,markId);
    }

    public  ObservableList getMarksDetails(String stId) throws SQLException, ClassNotFoundException {
        String sql="select * from mark where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        ObservableList list= FXCollections.observableArrayList();

        while (result.next()){
            list.add(new MarkTm (result.getString(1),result.getString(5),result.getString(6),result.getString(7),result.getDouble(8),result.getString(4)));
        }
        return list;
    }

}
