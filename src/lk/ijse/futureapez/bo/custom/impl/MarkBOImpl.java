package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.MarkBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dao.custom.ExamDAO;
import lk.ijse.futureapez.dao.custom.MarkDAO;
import lk.ijse.futureapez.dao.custom.StudentDAO;
import lk.ijse.futureapez.dao.custom.impl.MarkDAOImpl;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.ExamDTO;
import lk.ijse.futureapez.dto.MarkDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Exam;
import lk.ijse.futureapez.entity.Mark;
import lk.ijse.futureapez.entity.Student;

import java.sql.SQLException;

public class MarkBOImpl implements MarkBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    MarkDAO markDAO = (MarkDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MARK);
    ExamDAO examDAO = (ExamDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXAM);
    @Override
    public ObservableList getMarksDetails(String stId) throws SQLException, ClassNotFoundException {
        ObservableList list=markDAO.getMarksDetails (stId);
        return list;
    }

    @Override
    public boolean addMark(MarkDTO dto) throws SQLException, ClassNotFoundException {
        return markDAO.add (new Mark (dto.getMarkId (),dto.getStId (),dto.getStName (),dto.getBatch (),dto.getCourseId (),dto.getExamId (),dto.getExamName (),dto.getMark ()));
       //new Mark (dto.getMarkId (),dto.getStId (),dto.getStName (),dto.getBatch (),dto.getCourseId (),dto.getExamId (),dto.getExamName (),dto.getMark ());
    }

    @Override
    public boolean updateMark(MarkDTO dto) throws SQLException, ClassNotFoundException {
        return markDAO.update (new Mark (dto.getMarkId (),dto.getStId (),dto.getStName (),dto.getBatch (),dto.getCourseId (),dto.getExamId (),dto.getExamName (),dto.getMark ()));
    }

    @Override
    public boolean deleteMark(String id) throws SQLException, ClassNotFoundException {
        return markDAO.delete (id);
    }
    @Override
    public ObservableList loadExam(String courseId) throws SQLException, ClassNotFoundException {
        ObservableList list=examDAO.loadExam (courseId);
        return list;
    }

    @Override
    public Exam getExamdetail(String examId) throws SQLException, ClassNotFoundException {
        return examDAO.getExamdetail (examId);
    }

    @Override
    public ObservableList loadExams(String courseId) throws SQLException, ClassNotFoundException {
        ObservableList list=examDAO.loadExams (courseId);
        return list;
    }

    @Override
    public boolean addExam(ExamDTO dto) throws SQLException, ClassNotFoundException {
        return examDAO.add (new Exam (dto.getExamId (),dto.getExamName (),dto.getCourseId ()));
    }

    @Override
    public boolean updateExam(ExamDTO dto) throws SQLException, ClassNotFoundException {
        return examDAO.update (new Exam (dto.getExamId (),dto.getExamName (),dto.getCourseId ()));
    }

    @Override
    public boolean deleteExam(String id) throws SQLException, ClassNotFoundException {
        return examDAO.delete (id);
    }
    @Override
    public ObservableList<String> getCourseIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> ids=courseDAO.getCourseIds ();
        return ids;
    }
    @Override
    public CourseDTO getCourseDetail(String cId) throws SQLException, ClassNotFoundException {
        Course course= courseDAO.getCourseDetail (cId);
        return new CourseDTO (course.getCid (),course.getcName (),course.getcFee (),course.getcDuration (),course.gettName ());
    }
    @Override
    public ObservableList<String> loadCourseId(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> courseIds=courseDAO.loadCourseId (stId);
        return courseIds;
    }
    @Override
    public Student loadstName(String stId) throws SQLException, ClassNotFoundException {
        return studentDAO.loadstName (stId);
    }

    @Override
    public ObservableList loadBatch(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> allBatch=studentDAO.loadbatch (stId);
        return allBatch;
    }

    @Override
    public ObservableList<String> getStIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> stIds=studentDAO.getStIds ();
        return  stIds;
    }


}
