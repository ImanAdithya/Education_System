package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.StudentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.view.tm.CourseStudent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    ObservableList<Student> loadAll() throws SQLException, ClassNotFoundException;

    StudentDTO getStudentDetail(String stId) throws SQLException, ClassNotFoundException;

    CourseStudent getStudentCourseId(String stId) throws SQLException, ClassNotFoundException;

    ArrayList getStudentIds() throws SQLException, ClassNotFoundException;

    boolean existsRegister(StudentDTO student, CourseDTO course) throws SQLException, ClassNotFoundException;

    ObservableList loadbatch(String stId) throws SQLException, ClassNotFoundException;

    boolean registerStudent(StudentDTO stDto, CourseDTO cDto) throws SQLException, ClassNotFoundException;

    boolean update(StudentDTO stDto, CourseDTO cDto) throws SQLException, ClassNotFoundException;

    ObservableList loadIds() throws SQLException, ClassNotFoundException;
    int getStCount() throws SQLException, ClassNotFoundException;
    boolean addStudent(Student student) throws SQLException, ClassNotFoundException;
    boolean updateStudent(Student student) throws SQLException, ClassNotFoundException;
    boolean deleteStudent(String id)throws SQLException, ClassNotFoundException ;
    ObservableList getStIds() throws SQLException, ClassNotFoundException;
    StudentDTO loadstName(String stId) throws SQLException, ClassNotFoundException;
    ObservableList loadBatch(String stId) throws SQLException, ClassNotFoundException;
    CourseDTO loadCourseDetail(String courseId) throws SQLException, ClassNotFoundException ;
    ObservableList<CourseDTO> loadCourseAll() throws SQLException, ClassNotFoundException;

}
