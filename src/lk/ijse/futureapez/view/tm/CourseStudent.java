package lk.ijse.futureapez.view.tm;

public class CourseStudent {
    private String stId;
    private String name;
    private String courseId;


    public CourseStudent(String stId, String name, String courseId, String courseName, String teacherName, double fee, String duration) {
        this.stId = stId;
        this.name = name;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.fee = fee;
        this.duration = duration;
    }

    private String courseName;


    private String teacherName;
    private double fee;
    private String duration;


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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
