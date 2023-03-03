package lk.ijse.futureapez.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.futureapez.dao.CrudDAO;
import lk.ijse.futureapez.entity.Payment;
import lk.ijse.futureapez.view.tm.PaymentTm;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment> {
     Payment getPaymnetDetail(String payementId) throws SQLException, ClassNotFoundException;
     ObservableList<PaymentTm> loadAll(String stId) throws SQLException, ClassNotFoundException;
     String getPaymentTotal(String stId) throws SQLException, ClassNotFoundException;
}
