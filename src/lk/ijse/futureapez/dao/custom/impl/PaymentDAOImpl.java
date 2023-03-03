package lk.ijse.futureapez.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.custom.PaymentDAO;
import lk.ijse.futureapez.entity.Payment;
import lk.ijse.futureapez.util.CrudUtil;
import lk.ijse.futureapez.view.tm.PaymentTm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public  boolean add(Payment payment) throws SQLException, ClassNotFoundException {
        String sql="insert into payment values(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,payment.getpId(),
                payment.getCourseName(),
                payment.getPayment(),
                payment.getStId(),
                payment.getStName(),
                payment.getBatch());
    }

    @Override
    public boolean update(Payment payment) throws SQLException, ClassNotFoundException {
        String sql="update payment set courseName=?,PayAmount=?,stId=?,stName=?,batch=? where pId=?";
        return CrudUtil.execute(sql,payment.getCourseName(),payment.getPayment(),payment.getStId(),payment.getStName(),payment.getBatch(),payment.getpId());

    }

    @Override
    public boolean delete(String payId) throws SQLException, ClassNotFoundException {
        String sql="delete from payment where pId=?";
        return  CrudUtil.execute(sql,payId);
    }
    public Payment getPaymnetDetail(String payementId) throws SQLException, ClassNotFoundException {
        String sql="select * from payment where pId=?";
        ResultSet result=CrudUtil.execute(sql,payementId);

        while (result.next()){
            return new Payment(result.getString(1),result.getString(4),result.getString(5),result.getString(6),result.getString(2),result.getDouble(3));
        }
        return null;
    }
    public ObservableList<PaymentTm> loadAll(String stId) throws SQLException, ClassNotFoundException {
        String sql="select * from payment where stId=?";
        ResultSet resultSet=CrudUtil.execute(sql,stId);

        ObservableList<PaymentTm> list= FXCollections.observableArrayList();

        while (resultSet.next()){
            list.add(new PaymentTm(resultSet.getString(1),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(2),resultSet.getDouble(3)));
        }
        return list;
    }

    public String getPaymentTotal(String stId) throws SQLException, ClassNotFoundException {
        String sql="select SUM(PayAmount) from payment where stId=?";
        ResultSet result=CrudUtil.execute(sql,stId);

        while (result.next()){
            return result.getString(1);
        }
        return null;
    }

}
