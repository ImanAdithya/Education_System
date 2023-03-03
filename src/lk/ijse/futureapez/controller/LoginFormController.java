package lk.ijse.futureapez.controller;

import animatefx.animation.BounceIn;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.futureapez.bo.BOFactory;
import lk.ijse.futureapez.bo.custom.EmployeeBO;
import lk.ijse.futureapez.bo.custom.LoginBO;
import lk.ijse.futureapez.bo.custom.impl.LoginBOImpl;
import lk.ijse.futureapez.util.Notification;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class LoginFormController implements Initializable {


    public AnchorPane contextLogin;
    public JFXTextField txtUseName;
    public JFXPasswordField txtPass;
    public Label lblLogincheck;
    public ImageView logo;


    LoginBO loginBO   = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ZoomIn zoomIn = new ZoomIn(logo);
        zoomIn.setSpeed(0.2);
        zoomIn.play();
    }
    public void onActionCreate(MouseEvent mouseEvent) throws IOException {
        Stage stage1=new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/futureapez/view/CreateAccount.fxml"))));
        stage1.show();
    }

    public void onActionLogin(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

            String username=txtUseName.getText();
            String pass=txtPass.getText();

        /*    int num=LoginModel.getUser(username,pass);

            if (num==1){
                Stage stage3=new Stage();
                stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/futureapez/view/ReceptionDashBoard.fxml"))));
                stage3.show();

                Stage stage4=(Stage) contextLogin.getScene().getWindow();
                stage4.close();

            }else{
                lblLogincheck.setText("Inbhde");
            }*/


        try {
            boolean isValide = loginBO.getUserDetail(username,pass);

            if (username.isEmpty()==true || pass.isEmpty()==true){

                lblLogincheck.setText("Fill User Name or Password");
                new BounceIn(txtUseName).play();
                new BounceIn(txtPass).play();

            }
            else if (txtUseName.getText().equals("admin") && txtPass.getText().equals("1234")) {
                    Stage stage3 = new Stage();
                    stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/futureapez/view/Dashboard.fxml"))));
                    stage3.show();

                    Stage stage4 = (Stage) contextLogin.getScene().getWindow();
                    stage4.close();
                   Notification.notification("Admin Login Succuess");
                   return;

            }else if (isValide) {
                Stage stage3 = new Stage();
                stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/futureapez/view/ReceptionDashBoard.fxml"))));
                stage3.show();

                Stage stage4 = (Stage) contextLogin.getScene().getWindow();
                stage4.close();
                Notification.notification("User login Succus");
                return;
            }else{
                lblLogincheck.setText("Invalid UserName Or Password");
                new BounceIn(txtUseName).play();
                new BounceIn(txtPass).play();
                txtPass.setFocusColor(Paint.valueOf("#d63031"));
                txtUseName.setFocusColor(Paint.valueOf("Red"));

            }

        } catch ( Exception e) {
            System.out.println(e);
        }

    }



}
