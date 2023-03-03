package lk.ijse.futureapez.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.futureapez.util.Navigation;
import lk.ijse.futureapez.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ReceptionDashBoardController implements Initializable {
    public AnchorPane receptionDashboardContext;
    public Label lblTime;

    public void OnActionDashboard(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,receptionDashboardContext);
    }

    public void OnActionStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENT,receptionDashboardContext);
    }

    public void OnActionCourse(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.COURSE,receptionDashboardContext);
    }

    public void OnActionMarks(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MARK,receptionDashboardContext);
    }

    public void OnActionPayment(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT,receptionDashboardContext);
    }

    public void OnActionLouOut(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/ijse/futureapez/view/LoginForm.fxml"));
        Parent parent=fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClock();
    }
}
