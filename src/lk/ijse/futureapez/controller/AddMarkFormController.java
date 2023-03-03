package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.futureapez.bo.custom.MarkBO;
import lk.ijse.futureapez.dto.CourseDTO;
import lk.ijse.futureapez.dto.ExamDTO;
import lk.ijse.futureapez.dto.MarkDTO;
import lk.ijse.futureapez.entity.*;
import lk.ijse.futureapez.util.Notification;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMarkFormController implements Initializable {


    public JFXButton onActionUpdate;
    public JFXComboBox cmbCourse;
    public TextField txtExamId;
    public TextField txtCourseName;
    public TextField txtExam;
    public TableView tblExam;
    public TableColumn colExamId;
    public TableColumn colCourseId;
    public TableColumn colExam;

    public  static int index;
    public JFXComboBox cmbStId;
    public TextField txtStName;
    public JFXComboBox cmbBatch;
    public JFXComboBox cmbMarkCourse;
    public JFXComboBox cmbExam;
    public TextField txtMarks;
    public TextField txtExamName;
    public TextField txtMarkid;
    public TableView tblMark;
    public TableColumn colStid;
    public TableColumn colCourseName;
    public TableColumn colMarkExamID;
    public TableColumn colMarkExamName;
    public TableColumn colMark;
    public TableColumn colBatch;
    public static int indexMark;


   // ExamBO examBO  = (ExamBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EXAM);

    MarkBO markBO  = (MarkBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MARK);

    //CourseBO courseBO  = (CourseBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COURSE);

    //StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadCourses();
        loadCourseName();
        colExamId.setCellValueFactory(new PropertyValueFactory<>("ExamId"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colExam.setCellValueFactory(new PropertyValueFactory<>("ExamName"));

        loadStudentId();
        loadStudentDetails();
        getExam();
        getExamName();

        colMarkExamID.setCellValueFactory(new PropertyValueFactory<>("examId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colStid.setCellValueFactory(new PropertyValueFactory<>("stId"));
        colMarkExamName.setCellValueFactory(new PropertyValueFactory<>("examName"));
        colMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("batch"));


    }

    public void onActionAdd(ActionEvent actionEvent) {
        String examId=txtExamId.getText();
        String examName=txtExam.getText();
        String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();

        ExamDTO examDTO=new ExamDTO (examId,examName,courseId);

        try {
            boolean isExamAdded= markBO.addExam (examDTO);
            Notification.notification("Exam Added Succuss");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void onActionDelete(ActionEvent actionEvent) {
        String examId=txtExamId.getText();

        try {
            boolean isdeletedExam=markBO.deleteExam (examId);
            Notification.notification("Exam Delete Succuss");
            tblExam.getItems().remove(index);//Delete from Table
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void onActionSearch(ActionEvent actionEvent) {
        String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();
        ObservableList list= null;
        try {
            list = markBO.loadExam(courseId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tblExam.setItems(list);
    }

    public void LoadCourses(){
        try {
            ObservableList courses= markBO.getCourseIds ();
            cmbCourse.setItems(courses);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public  void loadCourseName(){
        cmbCourse.setOnAction(event -> {
            String courseId=cmbCourse.getSelectionModel().getSelectedItem().toString();
            CourseDTO courseDTO= null;
            try {
                courseDTO = markBO.getCourseDetail (courseId);
                txtCourseName.setText(courseDTO.getcName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }


        });
    }


    public void MouseEventTable(MouseEvent mouseEvent) {
        index=tblExam.getSelectionModel().getSelectedIndex();
        String examId=colExamId.getCellData(index).toString();//select Column value
        try {
            Exam exam= markBO.getExamdetail(examId);
            cmbCourse.setValue(exam.getCourseId());
            txtExamId.setText(exam.getExamId());
            txtExam.setText(exam.getExamName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void loadStudentId(){

        try {
           ObservableList stIds = markBO.getStIds();
            cmbStId.setItems(stIds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadStudentDetails(){
        cmbStId.setOnAction(event -> {
           String stId= cmbStId.getSelectionModel().getSelectedItem().toString();
           getBatch(stId);
           getCourseId(stId);

            try {
                Student student=markBO.loadstName (stId);
                txtStName.setText(student.getStName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });

    }

    private void getCourseId(String stId) {
        try {
            ObservableList courseIds=markBO.loadCourseId(stId);
            cmbMarkCourse.setItems(courseIds);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    private void getBatch(String stId) {
        try {
            ObservableList batches=markBO.loadBatch(stId);
            cmbBatch.setItems(batches);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getExam(){
        cmbMarkCourse.setOnAction(event -> {
            String courseId=cmbMarkCourse.getSelectionModel().getSelectedItem().toString();

            try {
                ObservableList examList=markBO.loadExams(courseId);
                cmbExam.setItems(examList);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });
    }

    public void getExamName(){
        cmbExam.setOnAction(event -> {
            String examId=cmbExam.getSelectionModel().getSelectedItem().toString();

            try {
                Exam exam=markBO.getExamdetail(examId);
                txtExamName.setText(exam.getExamName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });
    }


    public void onActionAddMark(ActionEvent actionEvent) {
        String markId=txtMarkid.getText();
        String stId=cmbStId.getSelectionModel().getSelectedItem().toString();
        String stName=txtStName.getText();
        String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
        String courseId=cmbMarkCourse.getSelectionModel().getSelectedItem().toString();
        String examId=cmbExam.getSelectionModel().getSelectedItem().toString();
        String examName=txtExamName.getText();
        double stMarks= Double.parseDouble(txtMarks.getText());

        MarkDTO markDTO=new MarkDTO (markId,stId,stName,batch,courseId,examId,examName,stMarks);
        try {
            boolean isAddedMarks=markBO.addMark (markDTO);
            Notification.notification("Mark Added Succuss");
            System.out.println("Added mark");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void onActionSearchMark(ActionEvent actionEvent) {
        String stId=cmbStId.getSelectionModel().getSelectedItem().toString();

        try {

           // MarkTm markTm=new MarkTm(mark.getStId(),mark.getStName(),mark.getExamId(),mark.getExamName(),mark.getMark(),mark.getBatch());
            ObservableList markList=markBO.getMarksDetails(stId);
            tblMark.setItems(markList);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    public void OnActionMarkDelete(ActionEvent actionEvent) {
        System.out.println(indexMark);
         String markId=colStid.getCellData(indexMark).toString();//select Column value
        try {
            boolean isDeletedMark=markBO.deleteMark (markId);
            Notification.notification("Exam Deleted Succuss");
            tblMark.getItems().remove(indexMark);//Delete from Table
            System.out.println("deleted Mark");
            Notification.notification("Mark Deleted Succuss");

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void MarkOnAction(MouseEvent mouseEvent) {
        indexMark=tblMark.getSelectionModel().getSelectedIndex();
    }

    public void MarkIdKeyPressd(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(M0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtMarkid.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtMarkid.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtMarkid.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }

    public void examIdKeypressed(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(E0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtExamId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtExamId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtExamId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }
}
