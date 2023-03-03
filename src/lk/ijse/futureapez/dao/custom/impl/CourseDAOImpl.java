package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.util.CrudUtil;
import lk.ijse.futureapez.view.tm.CourseTm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO {
    public  boolean add(Course course) throws SQLException, ClassNotFoundException {
        String sql="insert into course values(?,?,?,?,?)";
        return CrudUtil.execute(sql,course.getCid(),course.getcName(),course.getcFee(),course.getcDuration(),course.gettName());
    }
    public  boolean delete(String courseId) throws SQLException, ClassNotFoundException {
        String sql="delete from course where courseId=?";
        return CrudUtil.execute(sql,courseId);
    }
    public  boolean update(Course course) throws SQLException, ClassNotFoundException {
        String sql="update course set courseName=?,fee=?,duration=?,tName=? where courseId=?";
        return CrudUtil.execute(sql,course.getcName(),course.getcFee(),course.getcDuration(),course.gettName(),course.getCid());
    }

    public  ObservableList <CourseTm>loadAllDetail() throws SQLException, ClassNotFoundException {
        String sql="select * from course";
        ResultSet result=CrudUtil.execute(sql);

        ObservableList<CourseTm> AllDetail=FXCollections.observableArrayList();

        while (result.next()){
            AllDetail.add(new CourseTm(result.getString(1),result.getString(2),result.getDouble(3),result.getString(4),result.getString(5)));
        }
        return AllDetail;

    }

    public  ObservableList getCourseIds() throws SQLException, ClassNotFoundException {
        String sql="select courseId from course";
        ResultSet result=CrudUtil.execute(sql);

        ObservableList list=FXCollections.observableArrayList();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;
    }

    public String getCourseName(String courseName) throws SQLException, ClassNotFoundException {
        String sql="select fee from course where courseName=?";
        ResultSet result=CrudUtil.execute(sql,courseName);

        while (result.next()){
            return result.getString(1);
        }
        return null;
    }

    public  Course getCourseDetail(String cId) throws SQLException, ClassNotFoundException {
        String sql="select * from course where courseId=?";
        ResultSet result=CrudUtil.execute(sql,cId);

        while (result.next()){
            return new Course(result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getString(5));
        }
        return null;
    }

    public  ObservableList loadCourse(String stId) throws SQLException, ClassNotFoundException {
        String sql="select courseName from studentcourse where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        ObservableList list=FXCollections.observableArrayList();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;

    }

    public  Course loadCourseDetail(String courseId) throws SQLException, ClassNotFoundException {
        String sql="select * from course where courseId=?";
        ResultSet result=CrudUtil.execute(sql,courseId);

        while (result.next()){
            return new Course(result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getString(5));
        }
        return null;
    }

    public ObservableList<CourseDTO> loadCourseAll() throws SQLException, ClassNotFoundException {
        String sql="select * from course";
        ResultSet result= CrudUtil.execute(sql);
        ObservableList courseList=FXCollections.observableArrayList();

        while(result.next()){
            courseList.add(result.getString(1));
        }
        return courseList;
    }
    public Course laodFee(String courseName) throws SQLException, ClassNotFoundException {
        String sql="select * from course where courseName=?";
        ResultSet result=CrudUtil.execute(sql,courseName);
        while (result.next()) {
            return new Course(result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getString(5));
        }
        return null;
    }

    public String getCourseFee(String courseName) throws SQLException, ClassNotFoundException {
        String sql="select fee from course where courseName=?";
        ResultSet result=CrudUtil.execute(sql,courseName);
        while (result.next()){
            return  result.getString(1);
        }
        return  null;

    }

    public ObservableList loadCourseId(String stId) throws SQLException, ClassNotFoundException {
        String sql="select courseId from studentCourse where stId=?";
        ResultSet resultSet=CrudUtil.execute(sql,stId);

        ObservableList list=FXCollections.observableArrayList();

        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public int getcourseCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from course ";
        ResultSet resultSet= CrudUtil.execute(sql);


        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);

    }









}
