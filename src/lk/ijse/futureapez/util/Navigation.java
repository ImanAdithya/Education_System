package lk.ijse.futureapez.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

public class Navigation {
    private static AnchorPane anchorPane;

    public static void navigate(Routes routes,AnchorPane anchorPane) throws IOException {
        Navigation.anchorPane=anchorPane;
        Navigation.anchorPane.getChildren().clear();
        Stage window=(Stage)Navigation.anchorPane.getScene().getWindow();
       // Image image=new Image("/lk//ijse//futureapez/assets/");

        switch (routes){
            case DASHBOARD:
                window.setTitle("DASHBOARD");
                iniUi("DashboardForm.fxml");
                break;
            case STUDENT:
                window.setTitle("STUDENT");
                iniUi("StudentManageForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("EMPLOYEE");
                iniUi("EmployeManageForm.fxml");
                break;
            case SALARY:
                window.setTitle("SALARY");
                iniUi("SalaryManageForm.fxml");
                break;
            case MARK:
                window.setTitle("MARK");
                iniUi("AddMarkForm.fxml");
                break;
            case COURSE:
                window.setTitle("COURSE");
                iniUi("CourseManageForm.fxml");
                break;
            case PAYMENT:
                window.setTitle("PAYMENT");
                iniUi("PaymentForm.fxml");
                break;
            case LOGIN:
                window.setTitle("LOGIN");
                iniUi("LoginForm.fxml");
                break;
            case REPORT:
                window.setTitle("REPORT");
                iniUi("ReportForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR,"Not suitable ui found!").show();

        }
    }

    private static void iniUi(String location) throws IOException {
        Navigation.anchorPane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/futureapez/view/"+location)));
    }
}
