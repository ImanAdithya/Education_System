package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.StudentBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dao.custom.StudentDAO;
import lk.ijse.futureapez.dao.custom.impl.StudentDAOImpl;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.StudentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.view.tm.CourseStudent;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {

   // StudentDAO studentDAO=new StudentDAOImpl ();
   StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    @Override
    public ObservableList<Student> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<Student> all=studentDAO.loadAll();
        return all;

    }

    @Override
    public StudentDTO getStudentDetail(String stId) throws SQLException, ClassNotFoundException {
        Student s = studentDAO.getStudentDetail (stId);
        return new StudentDTO (s.getStId (),s.getStName (),s.getNic (),s.getAddress (),s.getEmail (),s.getContact (),s.getBatch (),s.getGender ());
        //stId, String stName, String nic, String address, String email, String contact, String batch, String gender
    }

    @Override
    public CourseStudent getStudentCourseId(String stId) throws SQLException, ClassNotFoundException {
         return studentDAO.getStudentCourseId (stId);
    }

    @Override
    public ArrayList<String> getStudentIds() throws SQLException, ClassNotFoundException {
        ArrayList<String>stIds= studentDAO.getStudentIds ();
        return stIds;
    }

    @Override
    public boolean existsRegister(StudentDTO stDto, CourseDTO cDto) throws SQLException, ClassNotFoundException {
        Student student=new Student (stDto.getStId (),stDto.getStName (),stDto.getNic (),stDto.getAddress (),stDto.getEmail (),stDto.getContact (),stDto.getBatch (),stDto.getGender ());
        Course course=new Course (cDto.getCid (),cDto.getcName (),cDto.getcFee (),cDto.getcDuration (),cDto.gettName ());
        return studentDAO.existsRegister (student,course);
    }

    @Override
    public StudentDTO loadstName(String stId) throws SQLException, ClassNotFoundException {
        Student s = studentDAO.loadstName (stId);
        return new StudentDTO (s.getStId (),s.getStName (),s.getNic (),s.getAddress (),s.getEmail (),s.getContact (),s.getBatch (),s.getGender ());
    }

    @Override
    public ObservableList<String> loadbatch(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> allBatch=studentDAO.loadbatch (stId);
        return allBatch;
    }

    @Override
    public boolean registerStudent(StudentDTO stDto, CourseDTO cDto) throws SQLException, ClassNotFoundException {
        Student student=new Student (stDto.getStId (),stDto.getStName (),stDto.getNic (),stDto.getAddress (),stDto.getEmail (),stDto.getContact (),stDto.getBatch (),stDto.getGender ());
        Course course=new Course (cDto.getCid (),cDto.getcName (),cDto.getcFee (),cDto.getcDuration (),cDto.gettName ());
        return studentDAO.registerStudent (student,course);
    }

    @Override
    public boolean update(StudentDTO stDto, CourseDTO cDto) throws SQLException, ClassNotFoundException {
        Student student=new Student (stDto.getStId (),stDto.getStName (),stDto.getNic (),stDto.getAddress (),stDto.getEmail (),stDto.getContact (),stDto.getBatch (),stDto.getGender ());
        Course course=new Course (cDto.getCid (),cDto.getcName (),cDto.getcFee (),cDto.getcDuration (),cDto.gettName ());
        return studentDAO.update (student,course);
    }

    @Override
    public ObservableList<String>loadIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> loadIds=studentDAO.loadIds ();
        return  loadIds;
    }

    @Override
    public ObservableList<String> getStIds() throws SQLException, ClassNotFoundException {
         ObservableList<String> stIds=studentDAO.getStIds ();
         return  stIds;
    }

    @Override
    public ObservableList<String> loadBatch(String stId) throws SQLException, ClassNotFoundException {
         ObservableList<String> batch=studentDAO.loadBatch (stId);
         return batch;
    }

    @Override
    public int getStCount() throws SQLException, ClassNotFoundException {
        return studentDAO.getStCount ();
    }

    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
       // return studentDAO.add (student);
        return false;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        //return studentDAO.update (student);
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete (id);
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

}
