package lk.ijse.futureapez.dto;

public class SalaryDTO {

    private String salaryId;
    private String empId;

    public SalaryDTO(String salaryId, String empId, String empName, double amount, String date) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.empName = empName;
        this.amount = amount;
        this.date = date;
    }

    private String empName;
    private double amount;
    private String date;

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
