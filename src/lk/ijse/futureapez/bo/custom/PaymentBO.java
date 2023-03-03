package lk.ijse.futureapez.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.bo.SuperBO;
import lk.ijse.futureapez.dto.PaymentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Payment;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.view.tm.PaymentTm;

import java.sql.SQLException;

public interface PaymentBO extends SuperBO {
    Payment getPaymnetDetail(String payementId) throws SQLException, ClassNotFoundException;
    ObservableList<PaymentTm> loadAll(String stId) throws SQLException, ClassNotFoundException;
    String getPaymentTotal(String stId) throws SQLException, ClassNotFoundException;
    boolean addPayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
    boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
    boolean deletePayment(String id)throws SQLException, ClassNotFoundException ;
    public String getCourseName(String courseName) throws SQLException, ClassNotFoundException ;
    public String getCourseFee(String courseName) throws SQLException, ClassNotFoundException;
    public Course laodFee(String courseName) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadCourse(String stId) throws SQLException, ClassNotFoundException;
    ObservableList<String>loadIds() throws SQLException, ClassNotFoundException ;
    Student loadstName(String stId) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadbatch(String stId) throws SQLException, ClassNotFoundException;

}
