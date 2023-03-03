package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.SubjectDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.view.tm.CourseTm;

import java.sql.SQLException;

public interface CourseBO  extends SuperBO {
    ObservableList<CourseTm> loadAllDetail() throws SQLException, ClassNotFoundException;
    String getCourseName(String courseName) throws SQLException, ClassNotFoundException;
    ObservableList loadCourse(String stId) throws SQLException, ClassNotFoundException;
    CourseDTO loadCourseDetail(String courseId) throws SQLException, ClassNotFoundException;
    ObservableList<CourseDTO> loadCourseAll() throws SQLException, ClassNotFoundException;
    Course laodFee(String courseName) throws SQLException, ClassNotFoundException;
    String getCourseFee(String courseName) throws SQLException, ClassNotFoundException;
    int getcourseCount() throws SQLException, ClassNotFoundException;
    boolean addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;
    boolean updateCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;
    boolean deleteCourse(String id)throws SQLException, ClassNotFoundException ;
      ObservableList searchSubject(String courseId) throws SQLException, ClassNotFoundException;
    boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteSubject(String id)throws SQLException, ClassNotFoundException ;
    ObservableList loadCourseId(String stId) throws SQLException, ClassNotFoundException;
    ObservableList getCourseIds() throws SQLException, ClassNotFoundException;
    CourseDTO getCourseDetail(String cId) throws SQLException, ClassNotFoundException;
    ObservableList<Course>loadTeacher() throws SQLException, ClassNotFoundException;



}
