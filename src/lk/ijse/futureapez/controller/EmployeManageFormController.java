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
import lk.ijse.futureapez.bo.custom.EmployeeBO;
import lk.ijse.futureapez.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.entity.Employee;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeManageFormController implements Initializable {
    public TextField txtEmpId;
    public TextField txtEname;
    public TextField txtEAddress;
    public TextField txtEnic;
    public JFXComboBox cmbJobRole;
    public TextField txtContatct;
    public TableView tblTeacher;
    public TableColumn colTid;
    public TableColumn colTname;
    public TableColumn colTnic;
    public TableColumn colTrole;
    public TableColumn colTcontact;
    public TableColumn colTAddress;

    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    //EmployeeBO employeeBO=new EmployeeBOImpl ();
    EmployeeBO employeeBO   = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setJobRole();
        colTid.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colTname.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colTnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colTrole.setCellValueFactory(new PropertyValueFactory<>("jobRole"));
        colTcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colTAddress.setCellValueFactory(new PropertyValueFactory<>("address"));


        loadAllEmployee ();
    }
    public void onActionEmployeeAdd(ActionEvent actionEvent) {
        String eId=txtEmpId.getText();
        String eNic=txtEnic.getText();
        String eContact= txtContatct.getText();
        String eAddress=txtEAddress.getText();
        String eName=txtEname.getText();
        String jobRole=cmbJobRole.getSelectionModel().getSelectedItem().toString();

        EmployeeDTO employeeDTO=new EmployeeDTO (eId,eName,eAddress,eNic,jobRole,eContact);

        try {
            boolean isAddEmployee= employeeBO.addEmployee (employeeDTO);
            System.out.println("Employee Added Success");
            loadAllEmployee ();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void OnActionUpdate(ActionEvent actionEvent) {
        String eId=txtEmpId.getText();
        String eNic=txtEnic.getText();
        String eContact= txtContatct.getText();
        String eAddress=txtEAddress.getText();
        String eName=txtEname.getText();
        String jobRole=cmbJobRole.getSelectionModel().getSelectedItem().toString();

        EmployeeDTO employeeDTO=new EmployeeDTO (eId,eName,eAddress,eNic,jobRole,eContact);

        try {
            boolean isUpdateEmployee=employeeBO.updateEmployee (employeeDTO);
            System.out.println("Update Employee Succuess");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }
    public void onActionDelete(ActionEvent actionEvent) {

        int selectedIdTeacher=tblTeacher.getSelectionModel().getSelectedIndex();//selected row index
        String TeacherId=colTid.getCellData(selectedIdTeacher).toString();//select Column value

        try {
            boolean isDeletedTeacher= employeeBO.deleteEmployee (TeacherId);
            tblTeacher.getItems().remove(selectedIdTeacher);//Delete from Table
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void setJobRole(){
        ObservableList<String> data = FXCollections.observableArrayList("Teacher","Worker");
        cmbJobRole.setItems(data);
    }
    public void loadAllEmployee(){
        try {
            ObservableList AllTeachers=employeeBO.loadEmployee ();
            tblTeacher.setItems(AllTeachers);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void tblEmployee(MouseEvent mouseEvent) {
        int index=tblTeacher.getSelectionModel().getSelectedIndex();
        String empId=colTid.getCellData(index).toString();//select Column value

        try {
            EmployeeDTO employee=  employeeBO.getEmployeeDetail(empId);
            txtEmpId.setText(employee.getEmpId());
            txtEname.setText(employee.getEmpName());
            txtContatct.setText(employee.getContact());
            txtEnic.setText(employee.getNic());
            txtEAddress.setText(employee.getAddress());
            cmbJobRole.setValue(employee.getJobRole());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void KeypressId(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(E0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtEmpId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtEmpId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtEmpId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }
    }

    public void OnKeyPressNic(KeyEvent keyEvent) {
    }
}
