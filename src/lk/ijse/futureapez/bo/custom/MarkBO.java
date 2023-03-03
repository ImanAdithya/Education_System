package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.ExamDTO;
import lk.ijse.futureapez.dto.MarkDTO;
import lk.ijse.futureapez.entity.Exam;
import lk.ijse.futureapez.entity.Mark;
import lk.ijse.futureapez.entity.Student;

import java.sql.SQLException;

public interface MarkBO extends SuperBO {
    ObservableList getMarksDetails(String stId) throws SQLException, ClassNotFoundException;
    boolean addMark(MarkDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateMark(MarkDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteMark(String id)throws SQLException, ClassNotFoundException ;
    ObservableList loadExam(String courseId) throws SQLException, ClassNotFoundException;
    Exam getExamdetail(String examId) throws SQLException, ClassNotFoundException;
    ObservableList loadExams(String courseId) throws SQLException, ClassNotFoundException;
    boolean addExam(ExamDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateExam(ExamDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteExam(String id)throws SQLException, ClassNotFoundException ;
    ObservableList loadCourseId(String stId) throws SQLException, ClassNotFoundException;
    ObservableList getCourseIds() throws SQLException, ClassNotFoundException;
    CourseDTO getCourseDetail(String cId) throws SQLException, ClassNotFoundException;
    ObservableList getStIds() throws SQLException, ClassNotFoundException;
    Student loadstName(String stId) throws SQLException, ClassNotFoundException;
    ObservableList loadBatch(String stId) throws SQLException, ClassNotFoundException;


}
