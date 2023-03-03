package lk.ijse.futureapez.view.tm;

public class MarkTm {
    private String stId;
    private String courseName;
    private String examId;

    public MarkTm(String stId, String courseName, String examId, String examName, double mark, String batch) {
        this.stId = stId;
        this.courseName = courseName;
        this.examId = examId;
        this.examName = examName;
        this.mark = mark;
        this.batch = batch;
    }

    private String examName;
    private double mark;
    private String batch;

    public String getStId() {
        return stId;
    }


    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
