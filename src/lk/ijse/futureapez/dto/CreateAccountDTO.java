package lk.ijse.futureapez.dto;

public class CreateAccountDTO {
    private String userName;
    private String password;
    private String email;

    public String getUserName() {
        return userName;
    }

    public CreateAccountDTO(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
