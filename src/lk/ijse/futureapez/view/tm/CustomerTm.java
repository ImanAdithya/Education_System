package lk.ijse.futureapez.view.tm;

public class CustomerTm {
    private String stId;
    private String name;
    private String nic;
    private String address;
    private String courseName;
    private String teacher;
    private String duration;
    private String fee;
    private String email;

    public CustomerTm(String stId, String name, String nic, String address, String courseName, String teacher, String duration, String fee, String email, String gender, String batch) {
        this.stId = stId;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.courseName = courseName;
        this.teacher = teacher;
        this.duration = duration;
        this.fee = fee;
        this.email = email;
        this.gender = gender;
        this.batch = batch;
    }

    private String gender;
    private String batch;




    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
