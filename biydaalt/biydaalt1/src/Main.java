public class Main {
    public static void main(String[] args) {
        Registration reg = new Registration();
        String basePath = System.getProperty("user.dir") + "/src/";
        reg.readSubjects(basePath + "Subjects.txt");
        reg.readMajors(basePath + "Professions.txt");
        reg.readExams(basePath + "Exams.txt");
        reg.showSubjects();
        reg.showMajors();
        reg.showStudents();
        reg.showFStudents();
    }
}