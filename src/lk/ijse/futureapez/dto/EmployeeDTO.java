package lk.ijse.futureapez.dto;

public class EmployeeDTO {
    private String empId;
    private String empName;
    private String address;
    private String nic;
    private String jobRole;
    private String contact;

    public EmployeeDTO(String empId, String empName, String address, String nic, String jobRole, String contact) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
        this.nic = nic;
        this.jobRole = jobRole;
        this.contact = contact;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
