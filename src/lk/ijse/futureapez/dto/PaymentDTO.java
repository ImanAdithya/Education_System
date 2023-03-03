package lk.ijse.futureapez.dto;

public class PaymentDTO {
  private String pId;
  private String stId;
  private String stName;
  private String batch;
  private String courseName;

    public PaymentDTO(String pId, String stId, String stName, String batch, String courseName, double payment) {
        this.pId = pId;
        this.stId = stId;
        this.stName = stName;
        this.batch = batch;
        this.courseName = courseName;
        this.payment = payment;
    }

    private double payment;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
