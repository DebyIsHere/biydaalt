public class Student {
    private String id;
    private String subjectId;
    private double score;
    private String grade;

    public Student(String id, String subjectId, double score, String grade) {
        this.id = id;
        this.subjectId = subjectId;
        this.score = score;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return id + " - " + subjectId + " : " + score + " (" + grade + ")";
    }
}