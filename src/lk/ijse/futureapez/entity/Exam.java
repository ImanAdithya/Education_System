package lk.ijse.futureapez.entity;

public class Exam {
    private String ExamId;
    private String ExamName;
    private String courseId;

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String examId) {
        ExamId = examId;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }


    public Exam(String examId, String examName, String courseId) {
        ExamId = examId;
        ExamName = examName;
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
