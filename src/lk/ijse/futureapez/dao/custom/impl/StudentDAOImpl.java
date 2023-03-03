package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.StudentDAO;
import lk.ijse.futureapez.db.DBConnection;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.util.CrudUtil;
import lk.ijse.futureapez.view.tm.CourseStudent;
import lk.ijse.futureapez.view.tm.CustomerTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean add(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  boolean delete(String stId) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM studentCourse WHERE stId=?";
        return CrudUtil.execute(sql,stId);
    }

    public boolean registerStudent(Student student, Course course) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            String sql1 = "insert into student values(?,?,?,?,?,?,?,?)";
            boolean isAddedStudent = CrudUtil.execute(sql1, student.getStId(),
                    student.getStName(),
                    student.getNic(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getContact(),
                    student.getBatch(),
                    student.getGender());

            if (isAddedStudent) {
                String sql3 = "insert into studentCourse values(?,?,?,?,?,?,?,?)";
                boolean isAddedStudentCourse = CrudUtil.execute(sql3, student.getStId(),
                        student.getStName(),
                        course.getCid(),
                        course.getcName(),
                        course.gettName(),
                        course.getcFee(),
                        course.getcDuration(),
                        student.getBatch());
                if (isAddedStudentCourse) {
                    DBConnection.getDbConnection().getConnection().commit();
                    return true;
                }
            }

            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        }finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }

    public  boolean update(Student student, Course course) throws SQLException, ClassNotFoundException {

        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            String sql1 = "update student set name=?,nic=?,address=?,email=?,contact=?,batch=?,gender=? where stId=?";
            boolean isStudentUpdate = CrudUtil.execute(sql1, student.getStName(),
                    student.getNic(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getContact(),
                    student.getBatch(),
                    student.getGender(),
                    student.getStId());

            if (isStudentUpdate) {
                String sql2 = "update studentCourse set name=?,courseId=?,courseName=?,tName=?,fee=?,duration=?,batch=? " +
                        "where stId=?";
                boolean isUpdatestSubject = CrudUtil.execute(sql2, student.getStName(),
                        course.getCid(),
                        course.getcName(),
                        course.gettName(),
                        course.getcFee(),
                        course.getcDuration(),
                        student.getStId(),
                        student.getBatch());

                if (isUpdatestSubject) {
                    DBConnection.getDbConnection().getConnection().commit();
                    return true;
                }
            }

            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        }finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }
    public  ObservableList<Student> loadAll() throws SQLException, ClassNotFoundException {
        String sql="select student.stId,student.name,student.nic,student.address,studentCourse.courseName," +
                "studentCourse.tName,studentCourse.duration,studentCourse.fee,student.email,student.gender," +
                "student.batch from studentCourse inner join student on student.stId=studentCourse.stId";
        ResultSet result=CrudUtil.execute(sql);

        ObservableList list=FXCollections.observableArrayList();
        while (result.next()){

            list.add(new CustomerTm (result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9),
                    result.getString(10),
                    result.getString(11)));
        }
        return list;
    }

    public  Student getStudentDetail(String stId) throws SQLException, ClassNotFoundException {
        String sql="select * from student where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        while (result.next()){
            return new Student(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8));
        }
        return null;
    }

    public  CourseStudent getStudentCourseId(String stId) throws SQLException, ClassNotFoundException {
        String sql="select * from studentCourse where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        while (result.next()){
            return new CourseStudent(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDouble(6),
                    result.getString(7));
        }
        return null;
    }

    public  ArrayList getStudentIds() throws SQLException, ClassNotFoundException {
        String sql="select stId from student";
        ResultSet result=CrudUtil.execute(sql);

        ArrayList list=new ArrayList<>();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;
    }

    public  boolean existsRegister(Student student, Course course) throws SQLException, ClassNotFoundException {
        String sql = "insert into studentCourse values(?,?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql, student.getStId(),
                student.getStName(),
                course.getCid(),
                course.getcName(),
                course.gettName(),
                course.getcFee(),
                course.getcDuration(),
                student.getBatch());

    }
    public Student loadstName(String stId) throws SQLException, ClassNotFoundException {
        String sql="select *  from student where stId=?";
        ResultSet resultSet=CrudUtil.execute(sql,stId);
        while (resultSet.next()){
            return new Student(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));
        }
        return null;
    }

    public  ObservableList loadbatch(String stId) throws SQLException, ClassNotFoundException {
        String sql="select batch from studentcourse where stId=?;";
        ResultSet resultSet=CrudUtil.execute(sql,stId);

        ObservableList list=FXCollections.observableArrayList();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;
    }
    public  ObservableList loadIds() throws SQLException, ClassNotFoundException {
        String sql="select stId from student";
        ResultSet result= CrudUtil.execute(sql);

        ObservableList idList= FXCollections.observableArrayList();

        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public  ObservableList getStIds() throws SQLException, ClassNotFoundException {
        String sql="select stId from student";
        ResultSet result= CrudUtil.execute(sql);
        ObservableList list=FXCollections.observableArrayList();
        while (result.next()){
            list.add(result.getString(1));
        }
        return list;
    }
    public  ObservableList loadBatch(String stId) throws SQLException, ClassNotFoundException {
        String sql="select batch from studentcourse where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        ObservableList list=FXCollections.observableArrayList();

        while (result.next()){
            list.add(result.getString(1));
        }
        return list;
    }
    public int getStCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from student";
        ResultSet resultSet= CrudUtil.execute(sql);


        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);

    }






}
