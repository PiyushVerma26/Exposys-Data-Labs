package hello.tech.exposysdatalabs.Modals;

public class FormModal {
    String streamCourse;
    String duration;
    String name;
    String email;
    String phone;
    String ten;
    String twelve;
    String college;
    String UserId;

    public FormModal(String streamCourse, String duration, String name, String UserId, String email, String phone, String ten, String twelve, String college) {
        this.streamCourse = streamCourse;
        this.duration = duration;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.ten = ten;
        this.twelve = twelve;
        this.college = college;

    }
    public FormModal(){

    }

    public String getStreamCourse() {
        return streamCourse;
    }

    public void setStreamCourse(String streamCourse) {
        this.streamCourse = streamCourse;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTwelve() {
        return twelve;
    }

    public void setTwelve(String twelve) {
        this.twelve = twelve;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}