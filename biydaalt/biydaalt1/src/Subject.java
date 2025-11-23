public class Subject {
    private String id;
    private String name;
    private double credit;

    public Subject(String id, String name, double credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + credit + ")";
    }
}
