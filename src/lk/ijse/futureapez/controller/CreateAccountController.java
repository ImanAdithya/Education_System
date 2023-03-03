package lk.ijse.futureapez.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.futureapez.bo.BOFactory;
import lk.ijse.futureapez.bo.custom.CourseBO;
import lk.ijse.futureapez.bo.custom.CreateAccBO;
import lk.ijse.futureapez.bo.custom.impl.CreateAccBOImpl;
import lk.ijse.futureapez.dto.CreateAccountDTO;
import lk.ijse.futureapez.entity.CreateAccount;
import lk.ijse.futureapez.util.Notification;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountController {
    public AnchorPane contextCreateAccount;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public PasswordField txtRetypepassword;
    public TextField txtEmail;
    public Label lblcheck;

    //CreateAccDAO createAccDAO=new CreateAccImpl ();
   // CreateAccBO createAccBO=new CreateAccBOImpl ();
    CreateAccBO createAccBO  = (CreateAccBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CREATE_ACC);

    public void onActionCreateAccount(ActionEvent actionEvent) {

        String userName=txtUserName.getText();
        String password=txtPassword.getText();
        String reTypePass=txtRetypepassword.getText();
        String email=txtEmail.getText();

        if (password.equals(reTypePass)){
            CreateAccountDTO createAccountDTO=new CreateAccountDTO (userName,password,email);
            try {
                boolean isAddeduser= createAccBO.add(createAccountDTO);
                Notification.notification("Account Created");
                System.out.println("Added User");
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }else{
            lblcheck.setText("Invalid Password");
        }
    }

    public void OnActionGmail(KeyEvent keyEvent) {

    }



    public void OnkeyPress(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("('^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$')");
        Matcher matcher = pattern.matcher(txtEmail.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            //txtEmail.set(RED);
            txtEmail.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

        } else {
            //txtEmail.setFocused(BLUE);
            txtEmail.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }
    }
}
