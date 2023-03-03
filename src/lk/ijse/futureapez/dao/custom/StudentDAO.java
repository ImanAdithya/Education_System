package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.view.tm.CourseStudent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO extends CrudDAO<Student> {
    // ObservableList<Course> loadCourseAll() throws SQLException, ClassNotFoundException;
    ObservableList loadAll() throws SQLException, ClassNotFoundException;

    Student getStudentDetail(String stId) throws SQLException, ClassNotFoundException;

    CourseStudent getStudentCourseId(String stId) throws SQLException, ClassNotFoundException;

    ArrayList getStudentIds() throws SQLException, ClassNotFoundException;

    boolean existsRegister(Student student, Course course) throws SQLException, ClassNotFoundException;

    Student loadstName(String stId) throws SQLException, ClassNotFoundException;

    ObservableList loadbatch(String stId) throws SQLException, ClassNotFoundException;

    boolean registerStudent(Student student, Course course) throws SQLException, ClassNotFoundException;

    boolean update(Student student, Course course) throws SQLException, ClassNotFoundException;

    ObservableList loadIds() throws SQLException, ClassNotFoundException;

    ObservableList getStIds() throws SQLException, ClassNotFoundException;

    ObservableList loadBatch(String stId) throws SQLException, ClassNotFoundException;

    int getStCount() throws SQLException, ClassNotFoundException;
}
