public class Student {
    private String name;
    private College college;
    private Campus campus;
    private int studentId;

    public Student() {

    }

    public Student(int studentId, String name, College college, Campus campus) {
        this.studentId = studentId;
        this.name = name;
        this.college = college;
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String toString() {
        String str = "Student Name: " + getName() + "\nCollege: " + college.getName() + "\n" + campus.toString();
        return str;
    }
}
