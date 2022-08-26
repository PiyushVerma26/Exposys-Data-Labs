package hello.tech.exposysdatalabs.Modals;

public class UserDetail {
    public String email;
    public String password;
    public String uId;

    public UserDetail( String email, String password, String uId) {
        this.email = email;
        this.password = password;
        this.uId = uId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
