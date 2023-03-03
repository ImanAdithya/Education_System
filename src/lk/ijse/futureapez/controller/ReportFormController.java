package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import lk.ijse.futureapez.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ReportFormController implements Initializable {
    public JFXButton payment;
    public JFXButton salary;

    public void onActionStuentReport(ActionEvent actionEvent) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/futureapez/report/Cherry.jrxml");

        HashMap<String , Object> hm = new HashMap<>();
       /* hm.put("KJVSLVB" , txtEmpName.getText());
        hm.put("dfsf" , txtEmpAddress.getText());*/

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport , hm , DBConnection.getDbConnection().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }



    public void onActionPaymentReport(ActionEvent actionEvent) {
    }

    public void onActionSalaryReport(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // payment.setVisible(false);
        //salary.setVisible(false);

    }
}
