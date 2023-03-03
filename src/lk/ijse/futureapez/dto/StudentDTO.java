package lk.ijse.futureapez.dto;

public class StudentDTO {
    private String stId;
    private String stName;
    private String nic;
    private String Address;
    private String email;
    private String contact;
    private String batch;

    public StudentDTO(String stId, String stName, String nic, String address, String email, String contact, String batch, String gender) {
        this.stId = stId;
        this.stName = stName;
        this.nic = nic;
        Address = address;
        this.email = email;
        this.contact = contact;
        this.batch = batch;
        this.gender = gender;
    }

    private String gender;

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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
