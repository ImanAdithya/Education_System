package lk.ijse.futureapez.dto;

public class CourseDTO {
  private String cid;
  private String cName;
  private double cFee;
  private String cDuration;

    public CourseDTO(String cid, String cName, double cFee, String cDuration, String tName) {
        this.cid = cid;
        this.cName = cName;
        this.cFee = cFee;
        this.cDuration = cDuration;
        this.tName = tName;
    }

    public CourseDTO() {
    }

    private String tName;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public double getcFee() {
        return cFee;
    }

    public void setcFee(double cFee) {
        this.cFee = cFee;
    }

    public String getcDuration() {
        return cDuration;
    }

    public void setcDuration(String cDuration) {
        this.cDuration = cDuration;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
