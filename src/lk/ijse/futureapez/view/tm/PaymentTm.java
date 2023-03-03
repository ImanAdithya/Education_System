package lk.ijse.futureapez.view.tm;

public class PaymentTm {
    private String paymentId;
    private String studentId;
    private String studentName;
    private String batch;
    private String courseName;

    public PaymentTm(String paymentId, String studentId, String studentName, String batch, String courseName, double payAmount) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.batch = batch;
        this.courseName = courseName;
        this.payAmount = payAmount;
    }

    private double payAmount;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }
}