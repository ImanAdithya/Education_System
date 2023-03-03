package lk.ijse.futureapez.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import lk.ijse.futureapez.bo.custom.SalaryBO;
import lk.ijse.futureapez.bo.custom.StudentBO;
import lk.ijse.futureapez.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.futureapez.bo.custom.impl.SalaryBOImpl;
import lk.ijse.futureapez.dto.EmployeeDTO;
import lk.ijse.futureapez.dto.SalaryDTO;
import lk.ijse.futureapez.entity.Employee;
import lk.ijse.futureapez.entity.Salary;
import lk.ijse.futureapez.util.Notification;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalaryManageFormController implements Initializable {
    public TableView tblSalary;
    public TableColumn colSalaryId;
    public TableColumn colEmpId;
    public TableColumn colEmpName;
    public TableColumn colType;
    public TableColumn colAmount;
    public TableColumn colDate;
    public TableColumn colOption;
    public JFXComboBox cmbEmpid;
    public TextField txtEmpName;
    public TextField txtSalary;
    public JFXDatePicker txtDate;
    public TextField txtAmount;

    //SalaryDAO salaryDAO=new SalaryDAOImpl ();
   // EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
   // SalaryBO salaryBO=new SalaryBOImpl ();
    SalaryBO salaryBO  = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SALARY);
   // EmployeeBO employeeBO=new EmployeeBOImpl ();
   //EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEmpIds();
        loadEmpName();

        colSalaryId.setCellValueFactory(new PropertyValueFactory<>("salaryId"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }



    public void onActionAddSalary(ActionEvent actionEvent) {
        String salaryId=txtSalary.getText();
        String empId= String.valueOf(cmbEmpid.getValue());
        String empName=txtEmpName.getText();
        String date= String.valueOf(txtDate.getValue());
        double amount= Double.parseDouble(txtAmount.getText());

        SalaryDTO salaryDTO=new SalaryDTO (salaryId,empId,empName,amount,date);

        try {
            boolean isAddedSalary=salaryBO.addSalary (salaryDTO);
            Notification.notification("Salary Added Succuss");
            System.out.println("Added");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void OnActionSearch(ActionEvent actionEvent) {
        String empId= String.valueOf(cmbEmpid.getValue());
        try {
            ObservableList loadDetail=salaryBO.loadSalaryDetail(empId);
            tblSalary.setItems(loadDetail);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void OnActionUpdate(ActionEvent actionEvent) {
        String salId=txtSalary.getText();
        String empId= String.valueOf(cmbEmpid.getValue());
        String empName=txtEmpName.getText();
        String date= String.valueOf(txtDate.getValue());
        double amount= Double.parseDouble(txtAmount.getText());

        SalaryDTO salaryDTO=new SalaryDTO (salId,empId,empName,amount,date);

        try {
            boolean isUpdateSalary=salaryBO.updateSalary (salaryDTO);
            Notification.notification("Salary Updated Succuss");
            System.out.println("updated");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    public void loadEmpIds(){
        try {
            ObservableList empIds= salaryBO.getEmpIds();
            cmbEmpid.setItems(empIds);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    private void loadEmpName() {

        cmbEmpid.setOnAction(event -> {
            String empId = cmbEmpid.getSelectionModel().getSelectedItem().toString();
            try {
                EmployeeDTO employee = salaryBO.getEmpName(empId);
                txtEmpName.setText(employee.getEmpName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });

    }

    public void mouseEventSalary(MouseEvent mouseEvent) {
        int index=tblSalary.getSelectionModel().getSelectedIndex();
        String salaryId=colSalaryId.getCellData(index).toString();//select Column value

        try {
            Salary salary= (Salary) salaryBO.loadAllSalary (salaryId);
            txtSalary.setText(salary.getSalaryId());
            cmbEmpid.setValue(salary.getEmpId());
            txtEmpName.setText(salary.getEmpName());
            txtAmount.setText(String.valueOf(salary.getAmount()));
            txtDate.setValue(LocalDate.parse(salary.getDate()));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void OnActionDeleteSalary(ActionEvent actionEvent) {
        int index=tblSalary.getSelectionModel().getSelectedIndex();
        String salaryId=colSalaryId.getCellData(index).toString();//select Column value

        try {
            boolean isDeleted=salaryBO.deleteSalary (salaryId);
            Notification.notification("Salary Deleted Succuss");
            System.out.println("deleted");
            tblSalary.getItems().remove(index);//Delete from Table
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void OnkeyPress(KeyEvent keyEvent) {
        Pattern pattern =Pattern.compile("(S0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtSalary.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtSalary.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtSalary.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }
    }
}
