package lk.ijse.futureapez.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.futureapez.bo.BOFactory;
import lk.ijse.futureapez.bo.custom.CourseBO;
import lk.ijse.futureapez.bo.custom.DashboardBO;
import lk.ijse.futureapez.bo.custom.EmployeeBO;
import lk.ijse.futureapez.bo.custom.StudentBO;
import lk.ijse.futureapez.bo.custom.impl.CourseBOImpl;
import lk.ijse.futureapez.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.futureapez.bo.custom.impl.StudentBOImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label lblStudent;
    public Label lblTeacher;
    public Label lblEmployee;
    public Label lblCourse;


      DashboardBO dashboardBO  = (DashboardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DASHBOARD);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    getStudentCount();
    getTeacherCount();
    getEmployeeCount();
    getCourseCount();
    }

    private void getCourseCount() {
        try {
            int courseCount = dashboardBO.getcourseCount();
            lblCourse.setText(String.valueOf(courseCount));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getStudentCount(){
        try {
            int stCount = dashboardBO.getStCount();
            lblStudent.setText(String.valueOf(stCount));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getTeacherCount(){
        try {
            int teacherCount = dashboardBO.geteacherCount();
            lblTeacher.setText(String.valueOf(teacherCount));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void getEmployeeCount(){
        try {
            int employeeCount = dashboardBO.getEmployeeCount();
            lblEmployee.setText(String.valueOf(employeeCount));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
