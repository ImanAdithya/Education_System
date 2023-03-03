package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
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
import lk.ijse.futureapez.bo.custom.StudentBO;
import lk.ijse.futureapez.bo.custom.impl.CourseBOImpl;
import lk.ijse.futureapez.bo.custom.impl.StudentBOImpl;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.StudentDTO;
import lk.ijse.futureapez.entity.Course;
import lk.ijse.futureapez.entity.Student;
import lk.ijse.futureapez.entity.Teacher;
import lk.ijse.futureapez.util.Notification;
import lk.ijse.futureapez.view.tm.CourseStudent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManageFormController implements Initializable {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtEmail;
    public TextField txtContact;
    public JFXComboBox cmbCourse;
    public TableView tblStudent;
    public TextField txtStId;
    public TextField txtBatch;
    public TextField txtDuration;
    public TextField txtFee;
    public TextField txtCourseName;
    public JFXComboBox cmbGender;
    public TableColumn colstId;
    public TableColumn colstName;
    public TableColumn colAddress;
    public TableColumn colCourse;
    public TableColumn colTeacher;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TableColumn colOption;
    public TableColumn colNic;
    public JFXComboBox cmbTeacherId;
    public TextField txtTeacherName;
    public TableColumn colGender;
    public TableColumn colCourseName;
    public TableColumn colEmail;
    public TableColumn colBatch;
    public JFXComboBox cmbtest;
    public static  ObservableList<CourseDTO> CourseIds=FXCollections.observableArrayList();
    public static ObservableList<Teacher>teacherList=FXCollections.observableArrayList();
    public TextField txtTeacherId;
    public TextField txtTeacherName1;

    StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    //CourseBO courseBO  = (CourseBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCourseID();
        loadCourseDetails();
        setGender();
        colstId.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colTeacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("batch"));
        loadTable();

    }

    public void onActionAdd(ActionEvent actionEvent) {
        String stId=txtStId.getText();
        String stName=txtName.getText();
        String nic=txtNic.getText();
        String address=txtAddress.getText();
        String contact=txtContact.getText();
        String email=txtEmail.getText();
        String batch=txtBatch.getText();
        String gender=cmbGender.getSelectionModel().getSelectedItem().toString();
        String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();
        String courseName=txtCourseName.getText();
        Double fee= Double.valueOf(txtFee.getText());
        String duration=txtDuration.getText();
       // String tId=txtTeacherId.getText();
        String teacherName=txtTeacherName1.getText();

        StudentDTO studentDTO=new StudentDTO (stId,stName,nic,address,email,contact,batch,gender);
        CourseDTO courseDTO=new CourseDTO (courseId,courseName,fee,duration,teacherName);

        boolean check=checkExistsStudent(stId);


            if (check){
                try {
                    boolean isRegisterExists=studentBO.existsRegister(studentDTO,courseDTO);
                    Notification.notification("Student Register Succuss");
                    loadTable();
                } catch (SQLException e) {
                    System.out.println(e);
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                }
            }else{

                try {
                    boolean isRegisterStudent=studentBO.registerStudent(studentDTO,courseDTO);
                    Notification.notification("Student Register Succuss");
                    loadTable();
                    System.out.println("Student Register Succuess");
                } catch (SQLException e) {
                    System.out.println(e);
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                }
            }


    }

    public void onActionUpdate(ActionEvent actionEvent) {
        String stId=txtStId.getText();
        String stName=txtName.getText();
        String nic=txtNic.getText();
        String address=txtAddress.getText();
        String contact=txtContact.getText();
        String email=txtEmail.getText();
        String batch=txtBatch.getText();
        String gender=cmbGender.getSelectionModel().getSelectedItem().toString();
        String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();
        String courseName=txtCourseName.getText();
        Double fee= Double.valueOf(txtFee.getText());
        String duration=txtDuration.getText();
        //String tId=txtTeacherId.getText();
        String teacherName=txtTeacherName1.getText();

        StudentDTO studentDTO=new StudentDTO (stId,stName,nic,address,email,contact,batch,gender);
        CourseDTO courseDTO=new CourseDTO (courseId,courseName,fee,duration,teacherName);

        try {
            boolean isUpdateStudent=studentBO.update(studentDTO,courseDTO);
            Notification.notification("Student Update Succuss");
            loadTable();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void OnActionDelete(ActionEvent actionEvent) {
        int selectedId=tblStudent.getSelectionModel().getSelectedIndex();//selected row index
        String stId=colstId.getCellData(selectedId).toString();//select Column value

       try {
            boolean isDeleteStudent=studentBO.deleteStudent (stId);//delete from database
           Notification.notification("Student Deleted Succuss");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        tblStudent.getItems().remove(selectedId);//Delete from Table
    }

    public void loadCourseID(){

        try {
             CourseIds= studentBO.loadCourseAll();
            cmbCourse.setItems(CourseIds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadCourseDetails(){
      cmbCourse.setOnAction(event -> {
          String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();
          try {
              CourseDTO courseDTO=studentBO.loadCourseDetail(courseId);
              txtCourseName.setText(courseDTO.getcName());
              txtDuration.setText(courseDTO.getcDuration());
              txtFee.setText(String.valueOf(courseDTO.getcFee()));
              txtTeacherName1.setText(courseDTO.gettName());
              //txtTeacherId.setText(course.gettId());

          } catch (SQLException e) {
              System.out.println(e);
          } catch (ClassNotFoundException e) {
              System.out.println(e);
          }
      });

    }


    public void setGender(){
        ObservableList<String> data = FXCollections.observableArrayList("Male","Female");
        cmbGender.setItems(data);
    }

    public void loadTable(){
        try {
            ObservableList AllStudent=studentBO.loadAll();
            tblStudent.setItems(AllStudent);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void getSelected(MouseEvent mouseEvent) {
        int index=tblStudent.getSelectionModel().getSelectedIndex();
        String stId=colstId.getCellData(index).toString();//select Column value
        try {
            StudentDTO student=studentBO.getStudentDetail(stId);
            CourseStudent courseStudent=studentBO.getStudentCourseId(stId);
            txtStId.setText(student.getStId());
            txtName.setText(student.getStName());
            txtAddress.setText(student.getAddress());
            txtEmail.setText(student.getEmail());
            txtBatch.setText(student.getBatch());
            cmbGender.setValue(student.getGender());
            txtContact.setText(student.getContact());
            txtNic.setText(student.getNic());
            int cId=CourseIds.indexOf(courseStudent.getCourseId());
            cmbCourse.getSelectionModel().select(cId);
          /* int tId=teacherList.indexOf(courseStudent.getTeacherId());
            cmbTeacherId.getSelectionModel().select(tId);*/
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        /*tblStudent.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (null!=newValue){

            }
        });*/
    }

    public boolean checkExistsStudent(String stId){
        boolean exists=false;
        // stId=txtStId.getText();
        try {
            ArrayList<String> stIds=studentBO.getStudentIds();

            for (String checkIndex:stIds
                 ) {
                if (checkIndex.equals(stId)){
                    exists=true;
                    break;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return exists;

    }

    public void OnkeyPressedStId(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(ST0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtStId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtStId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtStId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }
    }


    public void EmailKeyPress(KeyEvent keyEvent) {
        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher matcher = emailPattern.matcher(txtEmail.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtEmail.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtEmail.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }

    public void contactKeyPressed(KeyEvent keyEvent) {
        Pattern contactPattern = Pattern.compile("^(07)([0-9]{8})$");
        Matcher matcher = contactPattern.matcher(txtContact.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtContact.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtContact.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }
}

