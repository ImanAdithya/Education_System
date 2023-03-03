package lk.ijse.futureapez.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.custom.PaymentBO;
import lk.ijse.futureapez.dao.DAOFactory;
import lk.ijse.futureapez.dao.custom.CourseDAO;
import lk.ijse.futureapez.dao.custom.PaymentDAO;
import lk.ijse.futureapez.dao.custom.StudentDAO;
import lk.ijse.futureapez.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.futureapez.dto.PaymentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Payment;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.view.tm.PaymentTm;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {
    //PaymentDAO paymentDAO=new PaymentDAOImpl ();
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public Payment getPaymnetDetail(String payementId) throws SQLException, ClassNotFoundException {
        return paymentDAO.getPaymnetDetail (payementId);
    }

    @Override
    public ObservableList<PaymentTm> loadAll(String stId) throws SQLException, ClassNotFoundException {
        return paymentDAO.loadAll (stId);
    }

    @Override
    public String getPaymentTotal(String stId) throws SQLException, ClassNotFoundException {
        return paymentDAO.getPaymentTotal (stId);
    }

    @Override
    public boolean addPayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.add (new Payment (dto.getpId (),dto.getStId (),dto.getStName (),dto.getBatch (),dto.getCourseName (),dto.getPayment ()));
    }

    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update (new Payment (dto.getpId (),dto.getStId (),dto.getStName (),dto.getBatch (),dto.getCourseName (),dto.getPayment ()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete (id);
    }
    @Override
    public ObservableList<String> loadCourse(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> course=courseDAO.loadCourse (stId);
        return course;
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
    public String getCourseName(String courseName) throws SQLException, ClassNotFoundException {
        return courseDAO.getCourseName (courseName);
    }

    @Override
    public ObservableList<String>loadIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> loadIds=studentDAO.loadIds ();
        return  loadIds;
    }
    @Override
    public Student loadstName(String stId) throws SQLException, ClassNotFoundException {
        return studentDAO.loadstName (stId);
    }
    @Override
    public ObservableList<String> loadbatch(String stId) throws SQLException, ClassNotFoundException {
        ObservableList<String> allBatch=studentDAO.loadbatch (stId);
        return allBatch;
    }



}
