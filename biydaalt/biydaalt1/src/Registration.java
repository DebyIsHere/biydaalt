import java.io.*;
import java.util.*;

public class Registration {
    private List<Subject> subjects = new ArrayList<>();
    private List<Major> majors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void readSubjects(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                subjects.add(new Subject(p[0], p[1], Double.parseDouble(p[2])));
            }
        } catch (Exception e) {
            System.out.println("Cannot read Subjects file.");
        }
    }

    public void readMajors(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                majors.add(new Major(p[0], p[1]));
            }
        } catch (Exception e) {
            System.out.println("Cannot read Professions file.");
        }
    }

    public void readExams(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                students.add(new Student(p[0], p[1], Double.parseDouble(p[2]), p[3]));
            }
        } catch (Exception e) {
            System.out.println("Cannot read Exams file.");
        }
    }

    public void showSubjects() {
        System.out.println("Subjects:");
        for (Subject s : subjects) System.out.println(" - " + s);
    }

    public void showMajors() {
        System.out.println("Majors:");
        for (Major m : majors) System.out.println(" - " + m);
    }

    public void showStudents() {
        System.out.println("Students and GPA:");
        for (Student s : students) System.out.println(" - " + s);
    }

    public void showFStudents() {
        System.out.println("F Students:");
        for (Student s : students)
            if (s.getGrade().equalsIgnoreCase("F"))
                System.out.println(" - " + s.getId());
    }
}