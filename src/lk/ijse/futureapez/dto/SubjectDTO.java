package lk.ijse.futureapez.dto;

public class SubjectDTO {
    private String subjectId;
    private String subjectName;
    private String courseId;

    public SubjectDTO(String subjectId, String subjectName, String courseId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.courseId = courseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
