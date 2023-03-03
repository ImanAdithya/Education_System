package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.CourseBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dao.custom.EmployeeDAO;
import lk.ijse.futureapez.dao.custom.SubjectDAO;
import lk.ijse.futureapez.dao.custom.impl.CourseDAOImpl;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.SubjectDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Subject;
import lk.ijse.futureapez.view.tm.CourseTm;

import java.sql.SQLException;

public class CourseBOImpl implements CourseBO {

    //CourseDAO courseDAO=new CourseDAOImpl ();
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    SubjectDAO subjectDAO = (SubjectDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBJECT);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ObservableList<CourseTm> loadAllDetail() throws SQLException, ClassNotFoundException {
        ObservableList<CourseTm> loadAll=courseDAO.loadAllDetail ();
        return loadAll;
    }

    @Override
    public ObservableList<String> getCourseIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> ids=courseDAO.getCourseIds ();
        return ids;
    }

    @Override
    public String getCourseName(String courseName) throws SQLException, ClassNotFoundException {
        return courseDAO.getCourseName (courseName);
    }

    @Override
    public CourseDTO getCourseDetail(String cId) throws SQLException, ClassNotFoundException {
        Course course= courseDAO.getCourseDetail (cId);
        return new CourseDTO (course.getCid (),course.getcName (),course.getcFee (),course.getcDuration (),course.gettName ());
    }

    @Override
    public ObservableList<String> loadCourse(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> course=courseDAO.loadCourse (stId);
        return course;
    }

    @Override
    public CourseDTO loadCourseDetail(String courseId) throws SQLException, ClassNotFoundException {
        Course course=courseDAO.loadCourseDetail (courseId);
        return new CourseDTO (course.getCid (),course.getcName (),course.getcFee (),course.getcDuration (),course.gettName ());
    }

    @Override
    public ObservableList<CourseDTO> loadCourseAll() throws SQLException, ClassNotFoundException {
        ObservableList loadAll=courseDAO.loadCourseAll ();
        return loadAll;
    }

    @Override
    public Course laodFee(String courseName) throws SQLException, ClassNotFoundException {
        return courseDAO.laodFee (courseName);
    }

    @Override
    public String getCourseFee(String courseName) throws SQLException, ClassNotFoundException {
        return courseDAO.getCourseFee (courseName);
    }

    @Override
    public ObservableList<String> loadCourseId(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> courseIds=courseDAO.loadCourseId (stId);
        return courseIds;
    }

    @Override
    public int getcourseCount() throws SQLException, ClassNotFoundException {
        return  courseDAO.getcourseCount ();
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return courseDAO.add (new Course (courseDTO.getCid (),courseDTO.getcName (),courseDTO.getcFee (),courseDTO.getcDuration (),courseDTO.gettName ()));
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return courseDAO.update (new Course (courseDTO.getCid (),courseDTO.getcName (),courseDTO.getcFee (),courseDTO.getcDuration (),courseDTO.gettName ()));
    }

    @Override
    public boolean deleteCourse(String id) throws SQLException, ClassNotFoundException {
        return courseDAO.delete (id);
    }
    @Override
    public ObservableList searchSubject(String courseId) throws SQLException, ClassNotFoundException {
        ObservableList list=subjectDAO.searchSubject (courseId);
        return list;
    }

    @Override
    public boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.add (new Subject (dto.getSubjectId (),dto.getSubjectName (),dto.getCourseId ()));

    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.update (new Subject (dto.getSubjectId (),dto.getSubjectName (),dto.getCourseId ()));
    }

    @Override
    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException {
        return subjectDAO.delete (id);
    }
    @Override
    public ObservableList<Course> loadTeacher() throws SQLException, ClassNotFoundException {
        ObservableList<Course> allTeacher= employeeDAO.loadTeacher ();
        return allTeacher;
    }

}
