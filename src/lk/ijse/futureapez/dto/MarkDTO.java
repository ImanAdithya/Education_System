package lk.ijse.futureapez.dto;

public class MarkDTO {
    private String markId;
    private String stId;
    private String stName;
    private String batch;
    private String courseId;
    private String examId;
    private String examName;

    public MarkDTO(String markId, String stId, String stName, String batch, String courseId, String examId, String examName, double mark) {
        this.markId = markId;
        this.stId = stId;
        this.stName = stName;
        this.batch = batch;
        this.courseId = courseId;
        this.examId = examId;
        this.examName = examName;
        this.mark = mark;
    }

    private double mark;

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
