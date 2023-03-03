package lk.ijse.futureapez.view.tm;

public class CourseTm {
    private String courseId;
    private String courseName;
    private double courseFee;
    private String courseDue;
    private String teacherName;

    public CourseTm(String courseId, String courseName, double courseFee, String courseDue, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.courseDue = courseDue;
        this.teacherName = teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getCourseDue() {
        return courseDue;
    }

    public void setCourseDue(String courseDue) {
        this.courseDue = courseDue;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
