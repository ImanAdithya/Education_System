package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.futureapez.bo.BOFactory;
import lk.ijse.futureapez.bo.custom.CourseBO;
import lk.ijse.futureapez.bo.custom.PaymentBO;
import lk.ijse.futureapez.bo.custom.StudentBO;
import lk.ijse.futureapez.bo.custom.impl.CourseBOImpl;
import lk.ijse.futureapez.bo.custom.impl.PaymentBOImpl;
import lk.ijse.futureapez.bo.custom.impl.StudentBOImpl;
import lk.ijse.futureapez.dto.PaymentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Payment;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.util.Notification;
import lk.ijse.futureapez.view.tm.PaymentTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentFormController implements Initializable {
    public JFXComboBox cmbstId;
    public TextField txtStName;
    public TextField txtBatch;

    public TextField txtPaymentId;


    public Label lblPayStatus;
    public TableView tblPayment;
    public TextField txtCourseName;
    public TextField txtPayAmount;
    public TextField txtFee;
    public TableColumn colPayId;
    public TableColumn colStId;
    public TableColumn colStName;
    public TableColumn colBatch;
    public TableColumn colCourse;
    public TableColumn colPayAmount;
    public JFXComboBox cmbBatch;
    public JFXComboBox cmbCourse;
    public  static int index;

    //CourseBO courseBO  = (CourseBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COURSE);
   // StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    PaymentBO paymentBO  = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadStudentIds();
        getStudentName();
        getFee();

        colPayId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colStId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colPayAmount.setCellValueFactory(new PropertyValueFactory<>("payAmount"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("batch"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("courseName"));




    }

    public void OnActionPay(ActionEvent actionEvent)  {
        String pId=txtPaymentId.getText();
        String stId=cmbstId.getSelectionModel().getSelectedItem().toString();
        String stName=txtStName.getText();
        String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
        String courseName=cmbCourse.getSelectionModel().getSelectedItem().toString();
        double payAmount= Double.parseDouble(txtPayAmount.getText());

        PaymentDTO paymentDTO=new PaymentDTO (pId,stId,stName,batch,courseName,payAmount);

        try {
            boolean isPay=paymentBO.addPayment (paymentDTO);
            setHavePay(stId,courseName);
            Notification.notification("Payment Succuss");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

   /* private void paymentStatus(String stId,double pAmount,double havetoPay) {
        lblPayStatus.setText("");
        try {
            CourseStudent courseStudent=PaymentModel.loadDetails(stId);
            double CourseFee=courseStudent.getFee();

            if (CourseFee==pAmount){
                havetoPay=CourseFee-pAmount;
                lblPayStatus.setText("Payment Fully SuccusFull");
            }else{
                havetoPay=CourseFee-pAmount;
                System.out.println(havetoPay);
                lblPayStatus.setText("You Have to Pay "+havetoPay+".00");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


        ------------------
        /*double CourseFee=courseStudent.getFee();

        if (CourseFee==payAmount){
            haveToPay=CourseFee-payAmount;
            lblPayStatus.setText("Payment Fully SuccusFull");
        }else{
            haveToPay=CourseFee-payAmount;
            System.out.println(haveToPay);
            lblPayStatus.setText("You Have to Pay "+haveToPay+".00");
        }*/


    public void onActionUpdate(ActionEvent actionEvent) {
        String pId=txtPaymentId.getText();
        String stId=cmbstId.getSelectionModel().getSelectedItem().toString();
        String stName=txtStName.getText();
        String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
        String courseName=cmbCourse.getSelectionModel().getSelectedItem().toString();
        double payAmount= Double.parseDouble(txtPayAmount.getText());

        PaymentDTO paymentDTO=new PaymentDTO (pId,stId,stName,batch,courseName,payAmount);


        try {
            boolean isUpdatePayment=paymentBO.updatePayment (paymentDTO);
            Notification.notification("Payment Updated Succuss");
            setHavePay(stId,courseName);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void onActionDelete(ActionEvent actionEvent) {
        String payId=txtPaymentId.getText();
        String stId=cmbstId.getSelectionModel().getSelectedItem().toString();
        String courseName=cmbCourse.getSelectionModel().getSelectedItem().toString();

        try {
            boolean isDeleted=paymentBO.deletePayment (payId);
            tblPayment.getItems().remove(index);//Delete from Table
            Notification.notification("Payement Deleted Succuss");
            setHavePay(stId,courseName);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void loadStudentIds(){
        try {
            ObservableList studentIds= paymentBO.loadIds();
            cmbstId.setItems(studentIds);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public void OnActionSearch(ActionEvent actionEvent) {
        String stId=cmbstId.getSelectionModel().getSelectedItem().toString();

        try {
            ObservableList<PaymentTm> paymentDetail=paymentBO.loadAll(stId);
            tblPayment.setItems(paymentDetail);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getStudentName(){

        cmbstId.setOnAction(event -> {

            String stId=cmbstId.getSelectionModel().getSelectedItem().toString();
            getBatch(stId);
            getCourse(stId);
            try {
                Student student=paymentBO.loadstName(stId);
                txtStName.setText(student.getStName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });
    }

    public void getBatch(String stId){
        try {
            ObservableList batch=paymentBO.loadbatch(stId);
            cmbBatch.setItems(batch);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getCourse(String stId){
        try {
            ObservableList course=paymentBO.loadCourse(stId);
            cmbCourse.setItems(course);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getFee(){
        cmbCourse.setOnAction(event -> {
          String courseName =cmbCourse.getSelectionModel().getSelectedItem().toString();

            try {
                Course course=paymentBO.laodFee(courseName);
                txtFee.setText(String.valueOf(course.getcFee()));
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }


        });
    }

    public void pIdKeypressed(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(P0)([0-9]{1})([0-9])");
        Matcher matcher = pattern.matcher(txtPaymentId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtPaymentId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtPaymentId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }


    }

    public void OnClickPayment(MouseEvent mouseEvent) {
         index=tblPayment.getSelectionModel().getSelectedIndex();
        String payementId=colPayId.getCellData(index).toString();//select Column value

        try {
            Payment payment=paymentBO.getPaymnetDetail(payementId);
            String courseName= paymentBO.getCourseName(payment.getCourseName());
            txtPaymentId.setText(payment.getpId());
            cmbstId.setValue(payment.getStId());

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void setHavePay(String stId,String courseName) throws SQLException, ClassNotFoundException {
        double payTotal= Double.parseDouble(paymentBO.getPaymentTotal(stId));
        double courseFee= Double.parseDouble(paymentBO.getCourseFee(courseName));
        double HaveToPay=courseFee-payTotal;
        lblPayStatus.setText(String.valueOf("Rs "+HaveToPay));
    }
}

