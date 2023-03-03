package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.futureapez.bo.BOFactory;
import lk.ijse.futureapez.bo.custom.CourseBO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.SubjectDTO;
import lk.ijse.futureapez.util.Notification;
import lk.ijse.futureapez.view.tm.CourseTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseManageFormController implements Initializable {
    public TextField txtCourseFee;
    public TextField txtCourseId;
    public TextField txtCourseName;
    public TextField txtDuration;
    public JFXComboBox cmbTeachers;
    public TableView tblCourses;
    public TableColumn colCid;
    public TableColumn colCName;
    public TableColumn colCfee;
    public TableColumn colCDuration;
    public TableColumn  colTeacher;
    public TableView tblSuject;
    public TableColumn colCourseIdS;
    public TableColumn colSubjectId;
    public TableColumn colSubjectName;
    public TextField txtSCourseName;
    public TextField txtSubjectId;
    public TextField txtSubjectName;
    public JFXComboBox cmbCourseId;
    public static int index;
    //public static String subjectId;



    CourseBO courseBO  = (CourseBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COURSE);
    //SubjectBO subjectBO  = (SubjectBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUBJECT);
    //EmployeeBO employeeBO   = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTeacher();

        colCid.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colCName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCfee.setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        colCDuration.setCellValueFactory(new PropertyValueFactory<>("courseDue"));
        colTeacher.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        loadAllCourseDetail();

        loadCourseIds();
        getCourseName();

        colSubjectId.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        colSubjectName.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        colCourseIdS.setCellValueFactory(new PropertyValueFactory<>("courseId"));


    }

    public void OnActionAdd(ActionEvent actionEvent) {
        String courseId=txtCourseId.getText();
        String courseName=txtCourseName.getText();
        double fee= Double.parseDouble(txtCourseFee.getText());
        String duration=txtDuration.getText();
        String teacher=cmbTeachers.getSelectionModel().getSelectedItem().toString();

        CourseDTO courseDTO=new CourseDTO (courseId,courseName,fee,duration,teacher);

        try {
            boolean isAddedSubject=courseBO.addCourse (courseDTO);
            Notification.notification("Subject Added Succuss");
            loadAllCourseDetail();
            tblCourses.refresh();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println (e);
        }

    }

    public void onActionDelete(ActionEvent actionEvent) {
        int selectedIdTeacher=tblCourses.getSelectionModel().getSelectedIndex();//selected row index
        String courseId=colCid.getCellData(selectedIdTeacher).toString();//select Column value

        try {
            boolean isDeleted=courseBO.deleteCourse (courseId);
            Notification.notification("Subject Deleted Succuss");
            tblCourses.getItems().remove(selectedIdTeacher);//Delete from Table
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void onActionUpdate(ActionEvent actionEvent) {
        String courseId=txtCourseId.getText();
        String courseName=txtCourseName.getText();
        double fee= Double.parseDouble(txtCourseFee.getText());
        String duration=txtDuration.getText();
        String teacher=cmbTeachers.getSelectionModel().getSelectedItem().toString();

        CourseDTO courseDTO=new CourseDTO (courseId,courseName,fee,duration,teacher);

        try {
            boolean isUpdateCourse=courseBO.updateCourse (courseDTO);
            Notification.notification("Subject Updated Succuss");
            System.out.println("Course Update Succuess");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public void loadTeacher(){
        try {
            ObservableList techerList=courseBO.loadTeacher();
            cmbTeachers.setItems(techerList);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void loadAllCourseDetail(){
        try {
            ObservableList<CourseTm> loadAll=courseBO.loadAllDetail();
            tblCourses.setItems(loadAll);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void tblCourseClick(MouseEvent mouseEvent) {
        int index=tblCourses.getSelectionModel().getSelectedIndex();
        String cId=colCid.getCellData(index).toString();//select Column value

        try {
            CourseDTO courseDTO= courseBO.getCourseDetail(cId);
            txtCourseId.setText(courseDTO.getCid());
            txtCourseName.setText(courseDTO.getcName());
            txtCourseFee.setText(String.valueOf(courseDTO.getcFee()));
            txtDuration.setText(courseDTO.getcDuration());
            cmbTeachers.setValue(courseDTO.gettName());

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    public void onActionSubjectAdd(ActionEvent actionEvent) {
        String courseId=cmbCourseId.getSelectionModel().getSelectedItem().toString();
        String subId=txtSubjectId.getText();
        String subName=txtSubjectName.getText();

        SubjectDTO subjectDTO=new SubjectDTO (subId,subName,courseId);
        try {
            boolean isAddedSubject=courseBO.addSubject (subjectDTO);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public void onActionSubjectDelete(ActionEvent actionEvent) {
        String subjectId = colSubjectId.getCellData(index).toString();//select Column value
        try {
            boolean isDeleted=courseBO.deleteSubject (subjectId);
            System.out.println(subjectId);
            tblSuject.getItems().remove(index);//Delete from Table
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void loadCourseIds(){
        try {
            ObservableList courseIds=courseBO.getCourseIds();
            cmbCourseId.setItems(courseIds);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getCourseName(){
        cmbCourseId.setOnAction(event -> {
            String courseId=cmbCourseId.getSelectionModel().getSelectedItem().toString();

            try {
                CourseDTO courseDTO=courseBO.getCourseDetail(courseId);
                txtSCourseName.setText(courseDTO.getcName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }


        });
    }


    public void OnActionSearchSub(ActionEvent actionEvent) {
        String courseId=cmbCourseId.getSelectionModel().getSelectedItem().toString();
        try {
            ObservableList subjectDetails=courseBO.searchSubject(courseId);
            tblSuject.setItems(subjectDetails);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getSelected(MouseEvent mouseEvent) {
         index = tblSuject.getSelectionModel().getSelectedIndex();

    }

    public void Onkeypress(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(C0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtCourseId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtCourseId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtCourseId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }
    }
}

