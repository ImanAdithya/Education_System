package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.view.tm.CourseTm;

import java.sql.SQLException;

public interface CourseDAO extends CrudDAO<Course> {
      ObservableList <CourseTm>loadAllDetail() throws SQLException, ClassNotFoundException;
      ObservableList getCourseIds() throws SQLException, ClassNotFoundException;
      String getCourseName(String courseName) throws SQLException, ClassNotFoundException;
      Course getCourseDetail(String cId) throws SQLException, ClassNotFoundException;
      ObservableList loadCourse(String stId) throws SQLException, ClassNotFoundException;
      Course loadCourseDetail(String courseId) throws SQLException, ClassNotFoundException;
      ObservableList<CourseDTO> loadCourseAll() throws SQLException, ClassNotFoundException;
      Course laodFee(String courseName) throws SQLException, ClassNotFoundException;
      String getCourseFee(String courseName) throws SQLException, ClassNotFoundException;
      ObservableList loadCourseId(String stId) throws SQLException, ClassNotFoundException;
      int getcourseCount() throws SQLException, ClassNotFoundException;

}
