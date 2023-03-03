package lk.ijse.futureapez.dto;

public class TeacherDTO {
    private String teacherId;
    private String teacherName;
    private String teacherNic;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherGender;
    private String teacherContact;

    public String getTeacherId() {
        return teacherId;
    }

    public TeacherDTO(String teacherId, String teacherName, String teacherNic, String teacherAddress, String teacherEmail, String teacherGender, String teacherContact) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherNic = teacherNic;
        this.teacherAddress = teacherAddress;
        this.teacherEmail = teacherEmail;
        this.teacherGender = teacherGender;
        this.teacherContact = teacherContact;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNic() {
        return teacherNic;
    }

    public void setTeacherNic(String teacherNic) {
        this.teacherNic = teacherNic;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(String teacherContact) {
        this.teacherContact = teacherContact;
    }
}
