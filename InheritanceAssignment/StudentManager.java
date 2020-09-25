import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    List<Student> studentList = new ArrayList<>();
    List<Campus> campusList = new ArrayList<>();
    List<College> collegeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StudentManager studentManager = new StudentManager();
        studentManager.readStudent();
        studentManager.display();
    }

    public void readStudent() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Patrick 1\\Desktop\\Java\\InheritanceAssignment\\src\\student.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        Student student;
        readCollege();
        readCampus();

        while(line != null) {
            String[] data = line.split(",");
            int collegeId = Integer.parseInt(data[2]);
            int campusId = Integer.parseInt(data[3]);
            College college = searchByCollegeId(collegeId);
            Campus campus = searchByCampusId(campusId);
            student = new Student(Integer.parseInt(data[0]), data[1], college, campus);
            studentList.add(student);
            line = bufferedReader.readLine();
        }
    }

    public void readCollege() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Patrick 1\\Desktop\\Java\\InheritanceAssignment\\src\\college.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        College college;

        while(line != null) {
            String[] data = line.split(",");
            college = new College(Integer.parseInt(data[0]), data[1], data[2]);
            collegeList.add(college);
            line = bufferedReader.readLine();
        }
    }

    public void readCampus() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Patrick 1\\Desktop\\Java\\InheritanceAssignment\\src\\campus.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        Campus campus;
        readCollege();

        while(line != null) {
            String[] data = line.split(",");
            campus = new Campus(Integer.parseInt(data[0]), data[2], data[3]);
            campusList.add(campus);
            line = bufferedReader.readLine();
        }
    }

    public void display() {
        for(Student s : studentList) {
            System.out.println(s.toString());
            System.out.println("-------------------");
        }
    }

    public College searchByCollegeId(int id) {
        for(College college : collegeList) {
            if(college.getCollegeId() == id) {
                return college;
            }
        }
        return null;
    }

    public Campus searchByCampusId(int id) {
        for(Campus campus : campusList) {
            if(campus.getCampusId() ==  id) {
                return campus;
            }
        }
        return null;
    }
}
